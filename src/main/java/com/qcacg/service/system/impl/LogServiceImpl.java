package com.qcacg.service.system.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.LogEntity;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.LogService;

@Service
public class LogServiceImpl extends BaseServiceImpl<LogEntity> implements LogService
{
	public PageInfo<LogEntity> queryLogForList()
	{
		return this.queryPageForList();
	}
	
	
	
}
