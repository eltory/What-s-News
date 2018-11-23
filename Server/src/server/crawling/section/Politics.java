package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Politics extends Crawler implements Runnable{
   private static final int SID1 = 100; // Á¤Ä¡
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
		sid2.put("BlueHouse", "264");
		sid2.put("Assembly/party", "265");
		sid2.put("NorthKorea", "268");
		sid2.put("Administrative", "266");
		sid2.put("Defense/Diplomacy", "267");
		sid2.put("GeneralPolitics", "269");
	}
}