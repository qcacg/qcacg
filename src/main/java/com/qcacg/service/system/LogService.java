package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.LogEntity;
import com.qcacg.service.BaseService;

public interface LogService extends BaseService<LogEntity>
{
	public PageInfo<LogEntity> queryLogForList();

}
