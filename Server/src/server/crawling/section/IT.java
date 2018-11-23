package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class IT extends Crawler implements Runnable {
	private static final int SID1 = 105; // IT,占쏙옙占쏙옙
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
					System.out.println("吏�");
					super.article_read(root + "&sid1=" + SID1 + "&sid2=" + sid2.get("IT �씪諛�"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setSid() {
		sid2.put("占쏙옙占쏙옙占�", "731");
		sid2.put("占쏙옙占싶놂옙/SNS", "226");
		sid2.put("占쏙옙占�/占쏙옙占싱듸옙占�", "227");
		sid2.put("IT �씪諛�", "230");
		sid2.put("占쏙옙占쏙옙/占쏙옙킹", "732");
		sid2.put("占쏙옙퓨占쏙옙", "283");
		sid2.put("占쏙옙占쏙옙/占쏙옙占쏙옙", "229");
		sid2.put("占쏙옙占쏙옙 占싹뱄옙", "228");
	}
}