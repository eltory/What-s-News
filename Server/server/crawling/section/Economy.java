package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Economy extends Crawler implements Runnable{
   private static final int SID1 = 101; // ï¿½ï¿½ï¿½ï¿½
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   //¹¹ÁöÀÌ°Ç
   public Economy() {
      setSid();
      Thread t = new Thread(this);
      t.start();
   }
   
   
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
      sid2.put("ï¿½ï¿½ï¿½ï¿½", "259");
      sid2.put("ï¿½ï¿½ï¿½ï¿½", "258");
      sid2.put("ï¿½ï¿½ï¿½/ï¿½ï¿½ï¿½", "261");
      sid2.put("ï¿½ß±ï¿½/ï¿½ï¿½Ã³", "771");
      sid2.put("ï¿½Îµï¿½ï¿½ï¿½", "260");
      sid2.put("ï¿½Û·Î¹ï¿½ ï¿½ï¿½ï¿½ï¿½", "262");
      sid2.put("ï¿½ï¿½È°ï¿½ï¿½ï¿½ï¿½", "310");
      sid2.put("ï¿½ï¿½ï¿½ï¿½ ï¿½Ï¹ï¿½", "263");
   }
}