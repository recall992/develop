package org.hwl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class MongDBUtils {
	static{
		
	}
	
	public static void main(String[] args) {
		List<ServerAddress> seeds=new ArrayList<>();
		seeds.add(new ServerAddress("192.168.226.128", 27017));
		seeds.add(new ServerAddress("192.168.226.128", 27018));
		MongoClient mongoClient = new MongoClient(seeds);
		MongoDatabase mybatis= mongoClient.getDatabase("mybatis");
		MongoCollection userCollection= mybatis.getCollection("User");
		for(int i=0;i<1000;i++){
			userCollection.insertOne(JSON.serialize(new User(i, "name"+i, "address"+i)));
		}
		mongoClient.close();
	}
}
