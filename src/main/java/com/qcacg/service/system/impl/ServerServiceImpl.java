package com.qcacg.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.ServerEntity;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.ServerService;
import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl extends BaseServiceImpl<ServerEntity> implements ServerService
{

	@Override
	public PageInfo<ServerEntity> queryMonitorForList()
	{
		return this.queryPageForList();
	}

	@Override
	public String addServiceInfo(ServerEntity entity)
	{
		return this.save(entity);
	}

}
