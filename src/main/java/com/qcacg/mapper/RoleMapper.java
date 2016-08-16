package com.qcacg.mapper;

import com.qcacg.entity.RoleEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<RoleEntity>
{
	public List<RoleEntity> findRoleByUser(String userId);

}
