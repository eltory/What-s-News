package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Living extends Crawler implements Runnable{
   private static final int SID1 = 103; // 생활,문화
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
      sid2.put("건강정보", "241");
      sid2.put("자동차/시승기", "239");
      sid2.put("도로/교통", "240");
      sid2.put("여행/레저", "237");
      sid2.put("음식/맛집", "238");
      sid2.put("패션/뷰티", "376");
      sid2.put("공연/전시", "242");
      sid2.put("책", "243");
      sid2.put("종교", "244");
      sid2.put("날씨", "248");
      sid2.put("생활문화 일반", "245");
   }
}