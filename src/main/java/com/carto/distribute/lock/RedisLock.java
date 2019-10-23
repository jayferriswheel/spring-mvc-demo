package com.carto.distribute.lock;

import redis.clients.jedis.Jedis;

/**
 *
 *
 *
 */
public class RedisLock {
    // SETNX lock.foo <current Unix Time + lock timeout + 1>

    private Jedis jedis;
}
