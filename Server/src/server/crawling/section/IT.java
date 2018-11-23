package server.crawling.section;

import java.io.IOException;
import java.util.HashMap;

import server.crawling.Crawler;

/**
 * @author a301d
 */

public class IT extends Crawler implements Runnable {
	private static final int SID1 = 105; // IT & Science
	private HashMap<String, String> sid2 = new HashMap<String, String>();

	public IT() {
		setSid();
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				for (String key : sid2.keySet()) {
					System.out.println("IT");
					super.article_read(root + "&sid1=" + SID1 + "&sid2=" + sid2.get(key));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setSid() {
		sid2.put("Mobile", "731");
		sid2.put("Internet/SNS", "226");
		sid2.put("Communications/NewMedia", "227");
		sid2.put("GeneralIT", "230");
		sid2.put("Security/Hacking", "732");
		sid2.put("Computer", "283");
		sid2.put("Game/Review", "229");
		sid2.put("GeneralScience", "228");
	}
}