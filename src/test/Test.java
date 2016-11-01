package test;

import redis.clients.jedis.Jedis;

/**
 * Created by lijunyang on 2016/10/30.
 */
public class Test {
    public static void main(String[] args) {
        Jedis jedsi = new Jedis("localhost");
        System.out.println(jedsi.ping());
        System.out.println(jedsi.get("myKet"));
    }
}
