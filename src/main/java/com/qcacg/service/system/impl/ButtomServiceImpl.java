package com.qcacg.service.system.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.ButtonEntity;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.ButtomService;

@Service
public class ButtomServiceImpl extends BaseServiceImpl<ButtonEntity> implements ButtomService
{
	public PageInfo<ButtonEntity> queryButtomForList()
	{
		return this.queryPageForList();
	}
}
