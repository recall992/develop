package develop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class TestRedis {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring.xml");
		ShardedJedisPool jedisPool=ac.getBean(ShardedJedisPool.class);
		ShardedJedis jedis=jedisPool.getResource();
		for(int i=0;i<50000;i++){
			jedis.set("int:"+i, i+"x");
			//jedis.close();
			System.out.println(i);
		}*/
		
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		//Jedis Cluster will attempt to discover cluster nodes automatically
		Jedis jedis = new Jedis("localhost");
		//jedis.set(, "barxxxxxxxxxxxxxx");
		jedis.del("haifeng","foo");
		String value = jedis.get("foo");
		
	}
}
