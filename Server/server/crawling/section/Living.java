package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class Living extends Crawler implements Runnable{
   private static final int SID1 = 103; // ��Ȱ,��ȭ
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
      sid2.put("�ǰ�����", "241");
      sid2.put("�ڵ���/�ý±�", "239");
      sid2.put("����/����", "240");
      sid2.put("����/����", "237");
      sid2.put("����/����", "238");
      sid2.put("�м�/��Ƽ", "376");
      sid2.put("����/����", "242");
      sid2.put("å", "243");
      sid2.put("����", "244");
      sid2.put("����", "248");
      sid2.put("��Ȱ��ȭ �Ϲ�", "245");
   }
}