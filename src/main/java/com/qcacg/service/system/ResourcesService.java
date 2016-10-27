package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.ResourcesEntity;
import com.qcacg.service.BaseService;

import java.util.List;
import java.util.Map;

public interface ResourcesService extends BaseService<ResourcesEntity>
{
	public PageInfo<ResourcesEntity> queryResourcrsForList();

	public List<ResourcesEntity> queryResourcesForList();

	public List<ResourcesEntity> findRes(Map<String, String> queryMap);

	public List<ResourcesEntity> findResourcessByRoleId(String roleId);
	
	public List<ResourcesEntity> findResourcessByUserId(Long userId);
	
	public List<ResourcesEntity> findResourcessByMap(Map<String, String> queryMap);

	public String saveOrUpdate(ResourcesEntity entity);

	public String updateGroupByRole(String userId, String roleId, Integer[] resourcesId);
}
