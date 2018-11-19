package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Economy extends Crawler implements Runnable{
   private static final int SID1 = 101; // ����
   private HashMap<String, String> sid2 = new HashMap<String, String>();
   
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
      sid2.put("����", "259");
      sid2.put("����", "258");
      sid2.put("���/���", "261");
      sid2.put("�߱�/��ó", "771");
      sid2.put("�ε���", "260");
      sid2.put("�۷ι� ����", "262");
      sid2.put("��Ȱ����", "310");
      sid2.put("���� �Ϲ�", "263");
   }
}