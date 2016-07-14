package org.hwl.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository
public class RedisUtil {

	private static ShardedJedisPool shardedJedisPool;

	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}

	@Autowired
	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		RedisUtil.shardedJedisPool = shardedJedisPool;
	}

	public static ShardedJedis getJedis() {
		return shardedJedisPool.getResource();
	}
}
