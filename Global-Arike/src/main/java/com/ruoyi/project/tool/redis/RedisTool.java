package com.ruoyi.project.tool.redis;

import cn.hutool.core.util.ObjectUtil;
import redis.clients.jedis.Jedis;

/**
 * redis的链接工具
 */
public class RedisTool {
    private final static String host = "192.168.52.142";
    private final static String key = "123456";
    private final static int prot = 6379;


    /**
     * 返回REDIS登陆的实例
     */
    public static Jedis jedisClient() {
        Jedis jedis = new Jedis(host, prot);
        jedis.auth(key);
        return jedis;
    }

    /**
     * 销毁对象
     */
    public static void closeClient(Jedis jedis) {
        jedis.close();
    }

    /**
     * 存放验证码然后设置过期时间为60秒
     */
    public static void setCode(String phoneNo, String code) {
        Jedis jedis = jedisClient();
        jedis.setex(phoneNo, 300, code);
        closeClient(jedis);
    }

    /**
     * 验证当前验证码是否过期
     */

    public static String verifyCode(String phoneNo) {
        Jedis jedis = jedisClient();
        String code = jedis.get(phoneNo);
        closeClient(jedis);
        if (ObjectUtil.isNotNull(code)) {
            return code;
        }
        return null;
    }

    public static void main(String[] args) {
        setCode("15756275361", "789654");
    }

}
