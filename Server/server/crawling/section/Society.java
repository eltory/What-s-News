package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Society extends Crawler implements Runnable{
   private static final int SID1 = 102; // ��ȸ
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
      sid2.put("��ǻ��", "249");
      sid2.put("����", "250");
      sid2.put("�뵿", "251");
      sid2.put("���", "254");
      sid2.put("ȯ��", "252");
      sid2.put("�α�/����", "59b");
      sid2.put("��ǰ/�Ƿ�", "255");
      sid2.put("����", "256");
      sid2.put("�ι�", "276");
      sid2.put("��ȸ �Ϲ�", "257");
   }
}