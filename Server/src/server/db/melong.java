package server.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class melong {
   static void insert() {
      MongoClient mongo = new MongoClient("localhost", 35001);
      
      // .getDB()로 db를 연겨하고, .getCollection()으로 collection을 가져온다.
      DB db = mongo.getDB("news");
      DBCollection coll = db.getCollection("news_count");
      
      // BasciDBObject를 생성하여 document를 만든다.
      BasicDBObject doc = new BasicDBObject();
      doc.put("video", "test.avi");
      
      // 생성한 document를 .insert()로 collection에 삽입.
      coll.insert(doc);
   }
}