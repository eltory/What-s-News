package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Politics extends Crawler implements Runnable{
   private static final int SID1 = 100; // 정치
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
   public Politics() {
      setSid();
      Thread t = new Thread(this);
      t.start();
   }
   
   @Override
   public void run() {
      try {
         for (String key : sid2.keySet()) {
            super.article_read(root + "&sid1=" + SID1 + "&sid2=" + sid2.get(key));
         }
      } catch(IOException e) {
         e.printStackTrace();
      }
   }
   
   public void setSid() { 
      sid2.put("청와대", "264");
      sid2.put("국회/정당", "265");
      sid2.put("북한", "268");
      sid2.put("행정", "266");
      sid2.put("국방/외교", "267");
      sid2.put("정치일반", "269");   
   }
}