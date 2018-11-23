package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Economy extends Crawler implements Runnable{
   private static final int SID1 = 101; // 경제
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
   public Economy() {
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
      sid2.put("금융", "259");
      sid2.put("증권", "258");
      sid2.put("산업/재계", "261");
      sid2.put("중기/벤처", "771");
      sid2.put("부동산", "260");
      sid2.put("글로벌 경제", "262");
      sid2.put("생활경제", "310");
      sid2.put("경제 일반", "263");
   }
}