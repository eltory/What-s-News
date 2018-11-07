package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class World extends Crawler implements Runnable{
   private static final int SID1 = 104; // ����
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
   public World() {
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
      sid2.put("�ƽþ�/ȣ��", "231");
      sid2.put("�̱�/�߳���", "232");
      sid2.put("����", "233");
      sid2.put("�ߵ�/������ī", "234");
      sid2.put("���� �Ϲ�", "322");
   }
}