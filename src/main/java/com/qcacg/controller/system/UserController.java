package com.qcacg.controller.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.annotation.SystemLog;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.UserService;
import com.qcacg.util.UserEntityUtil;
import com.qcacg.util.http.ResponseUtils;
import com.qcacg.util.upload.FileRepository;
import com.qcacg.util.upload.UploadUtils;
import net.sf.json.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.io.File;
import java.util.Locale;

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


	/*
     修改或保存个人信息
     */
	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(UserEntity userEntity, @RequestParam("userName")String userName, @RequestParam("birthday")String birthday, @RequestParam("sex")String sex, @RequestParam("information")String information)
	{
		Long userId = UserEntityUtil.getUserFromSession().getUserId();
		userEntity.setUserId(userId);
		userEntity.setUserName(userName);
		userEntity.setBirthday(birthday);
		userEntity.setInformation(information);
		userEntity.setSex(sex);
		return this.userService.saveOrUpdate(userEntity);
	}

	@RequestMapping("batchDelete")
	@ResponseBody
	public String batchDelete(Long ids[])
	{
		return this.userService.batchDelete(ids);
	}

	@RequestMapping("profile")
	public String profile(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	{
		return "profile";
	}

	@RequestMapping(value = "upload")
	public void upload(MultipartHttpServletRequest request, HttpServletResponse response) {

		String message = "";
		String error = "";
		MultipartFile file = request.getFile("Image");
		String path = "";
		if (file == null || file.isEmpty()) {
			error = "文件太小！";
		} else {
			String origName = file.getOriginalFilename();
			int index = origName.lastIndexOf(".");
			String title = index < 0 ? origName : origName.substring(0,
					index);
			String ext = FilenameUtils.getExtension(origName).toLowerCase(
					Locale.ENGLISH);
			File destFile = null;
			try {
				String filename = UploadUtils.generateFilename("jpg");
				path = "/upload/image/userHead" + filename;
				destFile = fileRepository.storeByFilename(path, file);
				message = path;
			} catch (Exception e) {
				error = "上传失败！";
				e.printStackTrace();
				if (destFile != null && destFile.exists()) {
					destFile.delete();
				}
			}
		}
		UserEntity userEntity = UserEntityUtil.getUserFromSession();
		userEntity.setUserHead(path);
		this.userService.update(userEntity);
		JSONObject obj = new JSONObject();
		obj.put("err", error);
		obj.put("msg", message);
		ResponseUtils.renderText(response, obj.toString());
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

/*
获取基本信息
 */
	@RequestMapping("queryUser")
	@ResponseBody
	public UserEntity queryUser()
	{
		Long userId = UserEntityUtil.getUserFromSession().getUserId();
		return this.userService.findByPrimaryKey(userId);
	}



}
