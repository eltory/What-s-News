package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class IT extends Crawler implements Runnable{
   private static final int SID1 = 105; // IT,과학
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
   public IT() {
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
      sid2.put("모바일", "731");
      sid2.put("인터넷/SNS", "226");
      sid2.put("통신/뉴미디어", "227");
      sid2.put("IT 일반", "230");
      sid2.put("보안/해킹", "732");
      sid2.put("컴퓨터", "283");
      sid2.put("게임/리뷰", "229");
      sid2.put("과학 일반", "228");
   }
}

