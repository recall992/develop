package develop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class TestRedis {
	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring.xml");
		ShardedJedisPool jedisPool=ac.getBean(ShardedJedisPool.class);
		ShardedJedis jedis=jedisPool.getResource();
		for(int i=0;i<50000;i++){
			jedis.set("int:"+i, i+"x");
			//jedis.close();
			System.out.println(i);
		}
	}
}
