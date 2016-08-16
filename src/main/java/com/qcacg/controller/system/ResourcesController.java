package com.qcacg.controller.system;

import com.qcacg.annotation.SystemLog;
import com.qcacg.controller.BaseController;
import com.qcacg.entity.ButtonEntity;
import com.qcacg.entity.ResourcesEntity;
import com.qcacg.service.system.ButtomService;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.RoleService;
import com.qcacg.util.CommonUtil;
import com.qcacg.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resources/")
public class ResourcesController extends BaseController
{
	@Autowired
	public ResourcesService resourcesService;
	@Autowired
	public RoleService roleService;
	@Autowired
	private ButtomService buttomService;

	@RequestMapping("list")
	public String list(Model model)
	{
		model.addAttribute("pageInfo", resourcesService.queryResourcrsForList());
		return "/system/resources/list";
	}

	@RequestMapping("editUI")
	public String addUI(Model model, Long id)
	{
		model.addAttribute("list", resourcesService.queryResourcesForList());
		if (id != null)
		{
			ResourcesEntity entity = resourcesService.findByPrimaryKey(id);
			entity.setResourcesDescription(CommonUtil.htmltoString(entity.getResourcesDescription()));
			model.addAttribute("resources", entity);
		}
		return "/system/resources/edit";
	}
	
	@RequestMapping("saveForm")
	@ResponseBody
	@SystemLog(resourcesName = "资源管理", methods = "资源(添加/修改)")
	public String saveUser(ResourcesEntity entity)
	{
		return this.resourcesService.saveOrUpdate(entity);
	}
	
	@RequestMapping("batchDelete")
	@ResponseBody
	@SystemLog(resourcesName = "资源管理", methods = "删除资源")
	public String batchDelete(Long ids[])
	{
		return this.resourcesService.batchDelete(ids);
	}
	
	@ResponseBody
	@RequestMapping("findRes")
	public List<ResourcesEntity> findRes(String userId, String roleId)
	{
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("userId", userId);
		queryMap.put("roleId", roleId);
		return this.resourcesService.findRes(queryMap);
	}

	@ResponseBody
	@RequestMapping("findByButtom")
	public List<ButtonEntity> findByButtom()
	{
		return this.buttomService.queryObjectForList();
	}

	/**
	 * 权限分配页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("permissions")
	public String permissions(Model model)
	{
		List<ResourcesEntity> list = this.resourcesService.queryResourcesForList();
		List<ResourcesEntity> ns = TreeUtil.getChildResourceForms(list, 0);
		model.addAttribute("permissions", ns);
		return "/system/resources/permissions";
	}

	// 这里是修改 ？
	@ResponseBody
	@RequestMapping("roleRes")
	@SystemLog(resourcesName = "系统管理", methods = "用户管理/角色管理-修改权限") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String editRoleRes(String userId,String roleId, Integer[] resId) throws Exception
	{
		return this.resourcesService.updateGroupByRole(userId,roleId,resId);
	}

}
