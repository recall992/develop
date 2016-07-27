package develop;

import redis.clients.jedis.Jedis;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Arrays.asList;

public class Test {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("test");
		
		MongoCollection collection=db.getCollection("restaurants");
		long s=System.currentTimeMillis();
		System.out.println(s);
		for(int i=0;i<100000;i++){
			collection.insertOne(new Document("address",i));
		}
		long e=System.currentTimeMillis();
		collection.find(new Document("address", 200000));
		System.out.println(e);
		System.out.println(s-e);
		System.out.println("end");
	}
}
