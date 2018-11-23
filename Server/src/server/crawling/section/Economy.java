package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Economy extends Crawler implements Runnable{
   private static final int SID1 = 101; // ∞Ê¡¶
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
		sid2.put("Finance", "259");
		sid2.put("Securities", "258");
		sid2.put("Industry/Business", "261");
		sid2.put("Middle/Venture", "771");
		sid2.put("Estate", "260");
		sid2.put("GlobalEconomy", "262");
		sid2.put("LivingEconomy", "310");
		sid2.put("GeneralEconomy", "263");
	}
}