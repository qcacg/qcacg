package com.qcacg.service.system;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.RoleEntity;
import com.qcacg.service.BaseService;

public interface RoleService extends BaseService<RoleEntity>
{

	public PageInfo<RoleEntity> queryRoleForList();

	public String saveOrUpdate(RoleEntity roleEntity);

	public List<RoleEntity> findRoleByUser(String userId);

}
