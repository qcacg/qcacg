package com.qcacg.task;

import com.qcacg.util.EhcacheUtils;
import com.qcacg.util.PropertiesUtils;

public class CacheInit
{

	public void init()
	{
		System.out.println("初始化缓存");
		EhcacheUtils.initCacheManager();
		EhcacheUtils.initCache("cache");
		EhcacheUtils.put("cpu", PropertiesUtils.findPropertiesKey("cpu"));
		EhcacheUtils.put("jvm", PropertiesUtils.findPropertiesKey("jvm"));
		EhcacheUtils.put("ram", PropertiesUtils.findPropertiesKey("ram"));
		EhcacheUtils.put("toEmail", PropertiesUtils.findPropertiesKey("toEmail"));
	}
}
