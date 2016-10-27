package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.ButtonEntity;
import com.qcacg.service.BaseService;

public interface ButtomService extends BaseService<ButtonEntity>
{
	public PageInfo<ButtonEntity> queryButtomForList();
}
