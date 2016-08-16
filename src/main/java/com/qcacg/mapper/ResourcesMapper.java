package com.qcacg.mapper;

import com.qcacg.entity.GroupEntity;
import com.qcacg.entity.ResourcesEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper extends Mapper<ResourcesEntity>
{

	
	public List<ResourcesEntity> findResourcesByUserId(Long userId);
	public List<ResourcesEntity> findResourcessByRoleId(String resourcesId);
	public List<ResourcesEntity> findResourcessByMap(Map<String,String> queryMap);
	
	public List<ResourcesEntity> findRes(Map<String,String> queryMap);
	
	public void deleteByRoleId(String roleId);
	public void deleteByUserId(String userId);
	public void deleteRoleByUserId(String userId);
	
	
	
	public void batchAddRoleGroup(List<GroupEntity> list);
	public void batchAddUserGroup(List<GroupEntity> list);
	
	
	public void treeNodes();






}
