package server.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class melong {
   static void insert() {
      MongoClient mongo = new MongoClient("localhost", 35001);
      
      // .getDB()�� db�� �����ϰ�, .getCollection()���� collection�� �����´�.
      DB db = mongo.getDB("news");
      DBCollection coll = db.getCollection("news_count");
      
      // BasciDBObject�� �����Ͽ� document�� �����.
      BasicDBObject doc = new BasicDBObject();
      doc.put("video", "test.avi");
      
      // ������ document�� .insert()�� collection�� ����.
      coll.insert(doc);
   }
}