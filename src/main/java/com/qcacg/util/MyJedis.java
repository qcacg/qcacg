package com.qcacg.util;

import redis.clients.jedis.Jedis;

/**
 * Created by CaiYuanYu on 2016/10/29.
 */
public class MyJedis {
    private Jedis jedis;

    public MyJedis() {
        this.jedis = new Jedis("localhost");
    }

    public MyJedis(String host, int port) {
        this.jedis = new Jedis(host, port);
    }

    public void set(String key, String value) {
        this.jedis.set(key, value);
    }

    public String getValue(String key) {
        return this.jedis.get(key);
    }

    public Long remove(String key) {
        return this.jedis.del(key);
    }

    public String getTime(String key) {
        String value = this.jedis.get(key);
        String[] data = value.split("\\|");
        String now = data[1];
        return now;
    }

    public Long expire(String key, int second) {
        return jedis.expire(key, second);
    }

    public void updateLoginTime(String key, long time) {
        String now = String.valueOf(time);
        String value = this.getValue(key);
        String[] data = value.split("\\|");
        String tel = data[0];
        value = tel + "|" + now;
        this.jedis.del(key);
        this.jedis.set(key, value);
    }

    public String getTel(String key) {
        String value = this.jedis.get(key);
        String[] data = value.split("\\|");
        String tel = data[0];
        return tel;
    }

    public void setTimeOut(String key, String value) {
        this.jedis.set(key, value);
        this.jedis.expire(key, 300);
    }

    public Long getUserId(String telephone) {
        return Long.valueOf(this.jedis.get(telephone));
    }

    public Long getLong(String jsessionId) {
        String telephone = this.getTel(jsessionId);
        String value = this.jedis.get(telephone);
        Long userId = Long.valueOf(value);
        return userId;
    }
}
