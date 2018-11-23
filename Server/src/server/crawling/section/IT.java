package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class IT extends Crawler implements Runnable {
	private static final int SID1 = 105; // IT,����
	private HashMap<String, String> sid2 = new HashMap<String, String>();

	public IT() {
		setSid();
	
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				//for (String key : sid2.keySet()) {
				{
					System.out.println("진");
					super.article_read(root + "&sid1=" + SID1 + "&sid2=" + sid2.get("IT 일반"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setSid() {
		sid2.put("�����", "731");
		sid2.put("���ͳ�/SNS", "226");
		sid2.put("���/���̵��", "227");
		sid2.put("IT 일반", "230");
		sid2.put("����/��ŷ", "732");
		sid2.put("��ǻ��", "283");
		sid2.put("����/����", "229");
		sid2.put("���� �Ϲ�", "228");
	}
}