package com.qcacg.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.LogEntity;
import com.qcacg.service.system.LogService;

@Controller
@RequestMapping("/log/")
public class LogController
{
	@Autowired
	public LogService logService;

	@RequestMapping("list")
	public String list()
	{
		return "/system/log/list";
	}

	@RequestMapping("queryLogForList")
	@ResponseBody
	public PageInfo<LogEntity> queryLogForList()
	{
		return logService.queryLogForList();
	}

}
