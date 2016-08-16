package com.qcacg.service.system;

import com.qcacg.entity.ServerEntity;
import com.qcacg.service.BaseService;
import com.github.pagehelper.PageInfo;

public interface ServerService extends BaseService<ServerEntity>
{
	public PageInfo<ServerEntity> queryMonitorForList();
	public String addServiceInfo(ServerEntity entity);
}
