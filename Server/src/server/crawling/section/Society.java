package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Society extends Crawler implements Runnable{
   private static final int SID1 = 102; // 사회
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
   public Society() {
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
      sid2.put("사건사고", "249");
      sid2.put("교육", "250");
      sid2.put("노동", "251");
      sid2.put("언론", "254");
      sid2.put("환경", "252");
      sid2.put("인권/복지", "59b");
      sid2.put("식품/의료", "255");
      sid2.put("지역", "256");
      sid2.put("인물", "276");
      sid2.put("사회 일반", "257");
   }
}