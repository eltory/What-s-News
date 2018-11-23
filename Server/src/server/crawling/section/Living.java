package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Living extends Crawler implements Runnable{
   private static final int SID1 = 103; // Living & Culture
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
   public Living() {
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
		sid2.put("HealthInfo", "241");
		sid2.put("Car/Test", "239");
		sid2.put("Road/Traffic", "240");
		sid2.put("Travel/Leisure", "237");
		sid2.put("Food/Restaurant", "238");
		sid2.put("Fashion/Beauty", "376");
		sid2.put("Show/Display", "242");
		sid2.put("Book", "243");
		sid2.put("Religion", "244");
		sid2.put("Weather", "248");
		sid2.put("GeneralLiving", "245");
	}
}