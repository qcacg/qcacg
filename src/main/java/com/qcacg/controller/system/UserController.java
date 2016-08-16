package com.qcacg.controller.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.annotation.SystemLog;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.UserService;
import com.qcacg.util.PasswordHelper;
import com.qcacg.util.Result;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController extends BaseController
{


	@Autowired
	public UserService userService;
	@Autowired
	private FileRepository fileRepository;

	@RequestMapping("list")
	@SystemLog(resourcesName = "用户管理", methods = "查询用户")
	public String main(Model model)
	{
		model.addAttribute("res", findResByUser());
		return "/system/user/list";
	}

	@RequestMapping("editUI")
	public String addUI(Model model, Long id)
	{
		if (id != null)
		{
			model.addAttribute("user", userService.findByPrimaryKey(id));
		}
		return "/system/user/edit";
	}

	@RequestMapping("queryUserForList")
	@ResponseBody
	public PageInfo<UserEntity> queryUserForList(String telephone)
	{
		UserEntity entity = null;
		if(StringUtils.isNoneEmpty(telephone))
		{
			entity = new UserEntity();
			entity.setTelephone(telephone);
		}
		return this.userService.queryUserForList(entity);
	}

	@RequestMapping("saveForm")
	@ResponseBody
	@SystemLog(resourcesName = "用户管理", methods = "添加用户")
	public String saveUser(UserEntity form, Long txtGroupsSelect[])
	{
		return this.userService.saveOrUpdate(form, txtGroupsSelect);
	}

	@RequestMapping("batchDelete")
	@ResponseBody
	@SystemLog(resourcesName = "用户管理", methods = "批量删除用户")
	public String batchDelete(Long ids[])
	{
		return this.userService.batchDelete(ids);
	}

	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	{
		return "profile";
	}

	@RequestMapping(value = "/upload")
	public void upload(MultipartHttpServletRequest request,
			@RequestParam(value = "__source", required = false) MultipartFile file3, HttpServletResponse response,
			ModelMap model) throws IOException
	{
		Result result = new Result();
		MultipartFile file = null;
		Map<String, MultipartFile> file2 = request.getFileMap();
		String path = "";
		for (Map.Entry<String, MultipartFile> entry : file2.entrySet())
		{
			file = entry.getValue();
		}
		if (file == null || file.isEmpty())
		{
			result.setMsg("文件太小");
		} else
		{
			result.avatarUrls = new ArrayList<String>();
			result.setSuccess(false);
			result.setMsg("上传失败!");
			boolean isSourcePic = file.getName().equals("__source");
			String fieldName = file.getName();//file对象有问题

			if (file3 != null)
			{
				isSourcePic = true;
				fieldName = file3.getOriginalFilename();
				file = file3;
			}
			if (fieldName.equals("__initParams"))
			{

			}
			// 如果是原始图片 file
			// 域的名称或者以默认的头像域名称的部分“__avatar”打头(默认的头像域名称：__avatar1,2,3...，可在插件配置参数中自定义，参数名：avatar_field_names)
			else if (isSourcePic || fieldName.startsWith("__avatar"))
			{

				// String virtualPath = "/upload/jsp_avatar" + avatarNumber +
				// "_" + fileName + ".jpg";
				// 原始图片（默认的 file 域的名称是__source，可在插件配置参数中自定义。参数名：src_field_name）。
				if (isSourcePic)
				{
					// 文件名，如果是本地或网络图片为原始文件名、如果是摄像头拍照则为 *FromWebcam.jpg
					String sourceFileName = fieldName;
					// 原始文件的扩展名(不包含“.”)
					String sourceExtendName = sourceFileName.substring(sourceFileName.lastIndexOf('.') + 1);
					String filename = UploadUtils.generateFilename(sourceExtendName);
					path = "upload/files" + filename;
					result.sourceUrl = path;
				}
				// 头像图片（默认的 file
				// 域的名称：__avatar1,2,3...，可在插件配置参数中自定义，参数名：avatar_field_names）。
				else
				{
					String filename = UploadUtils.generateFilename("jpg");
					path = "upload/files/userHead" + filename;
					result.avatarUrls.add(request.getContextPath() + path);
					//result.sourceUrl = path;
				}
				fileRepository.storeByFilename(path, file);
			}
		}
		if (result.sourceUrl != null)
		{

		}
		result.sourceUrl = request.getContextPath() + result.sourceUrl;
		result.setSuccess(true);
		result.setMsg("上传成功!");

		UserEntity userEntity = UserEntityUtil.getUserFromSession();
		userEntity.setUserHead(path);
		this.userService.update(userEntity);
		ResponseUtils.renderText(response, JSONObject.fromObject(result).toString());
	}


	@RequestMapping("/updatePassWord")
	@ResponseBody
	public Result updatePassWord(@RequestParam(value = "telephone") String telephone,
								 @RequestParam(value = "oldPassWord") String oldPassWord,
								 @RequestParam(value = "newPassWord") String newPassword){
		oldPassWord = oldPassWord.trim();
		newPassword = newPassword.trim();
		Result result = new Result();
		if(oldPassWord.isEmpty()){
			throw new IllegalArgumentException("缺少旧密码");
		}
		if(newPassword.isEmpty()){
			throw new IllegalArgumentException("缺少新密码");
		}
		if(newPassword.equals(oldPassWord)){
			throw new IllegalArgumentException("新旧密码不能相同");
		}

		UserEntity userEntity = this.userService.findByLoginName(telephone);

		if(userEntity != null && new SimpleHash("md5", oldPassWord, ByteSource.Util.bytes(telephone+userEntity.getCredentialsSalt()), 2).toHex().equals(userEntity.getPassWord())){

			PasswordHelper passwordHelper = new PasswordHelper();
			passwordHelper.encryptPassword(userEntity);
			result.setSuccess(true);
			return result;
		}
		result.setMsg("原密码输入错误");
		result.setSuccess(false);
		return result;
	}



}
