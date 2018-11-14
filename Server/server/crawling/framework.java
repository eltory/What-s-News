package server.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class framework {
	final String URL = "https://news.naver.com/";
	private HashMap<String, String> sid_major;
	private HashMap<String, String> sid_sub;
	
	public framework() {
		sid_major = new HashMap<String, String>();
		sid_sub = new HashMap<String, String>();
		
		// Hash set�� ���⼭ �ϴ°� �´��� �𸣰���.
		//setSid();
	}
	
	public void setSid() {      
	      /* 
	       * ���̹� ����
	       * sid1 -> major: ��з�
	       * sid2 -> sub: �Һз�
	       */
	      sid_major.put("��ġ", "100"); 
	      sid_sub.put("û�ʹ�", "264");
	      sid_sub.put("��ȸ/����", "265");
	      sid_sub.put("����", "268");
	      sid_sub.put("����", "266");
	      sid_sub.put("����/�ܱ�", "267");
	      sid_sub.put("��ġ�Ϲ�", "269");
	      
	      sid_major.put("����", "101");
	      sid_sub.put("����", "259");
	      sid_sub.put("����", "258");
	      sid_sub.put("���/���", "261");
	      sid_sub.put("�߱�/��ó", "771");
	      sid_sub.put("�ε���", "260");
	      sid_sub.put("�۷ι� ����", "262");
	      sid_sub.put("��Ȱ����", "310");
	      sid_sub.put("���� �Ϲ�", "263");
	      
	      sid_major.put("��ȸ", "102");
	      sid_sub.put("��ǻ��", "249");
	      sid_sub.put("����", "250");
	      sid_sub.put("�뵿", "251");
	      sid_sub.put("���", "254");
	      sid_sub.put("ȯ��", "252");
	      sid_sub.put("�α�/����", "59b");
	      sid_sub.put("��ǰ/�Ƿ�", "255");
	      sid_sub.put("����", "256");
	      sid_sub.put("�ι�", "276");
	      sid_sub.put("��ȸ �Ϲ�", "257");
	      
	      sid_major.put("��Ȱ/��ȭ", "103");
	      sid_sub.put("�ǰ�����", "241");
	      sid_sub.put("�ڵ���/�ý±�", "239");
	      sid_sub.put("����/����", "240");
	      sid_sub.put("����/����", "237");
	      sid_sub.put("����/����", "238");
	      sid_sub.put("�м�/��Ƽ", "376");
	      sid_sub.put("����/����", "242");
	      sid_sub.put("å", "243");
	      sid_sub.put("����", "244");
	      sid_sub.put("����", "248");
	      sid_sub.put("��Ȱ��ȭ �Ϲ�", "245");
	      
	      sid_major.put("����", "104");
	      sid_sub.put("�ƽþ�/ȣ��", "231");
	      sid_sub.put("�̱�/�߳���", "232");
	      sid_sub.put("����", "233");
	      sid_sub.put("�ߵ�/������ī", "234");
	      sid_sub.put("���� �Ϲ�", "322");
	      
	      sid_major.put("IT/����", "105");
	      sid_sub.put("�����", "731");
	      sid_sub.put("���ͳ�/SNS", "226");
	      sid_sub.put("���/���̵��", "227");
	      sid_sub.put("IT �Ϲ�", "230");
	      sid_sub.put("����/��ŷ", "732");
	      sid_sub.put("��ǻ��", "283");
	      sid_sub.put("����/����", "229");
	      sid_sub.put("���� �Ϲ�", "228");      
	   }
	
	// Hash set�� ���� server_main���� major, sub�� sid�� �� �� �ִ�.
	
	// Stirng parameter�� major + sub sid�� �Էµ� url.
	public void article_read(String major_sub) throws IOException {
		Document doc = Jsoup.connect(major_sub).get();
		
		// Search type06 and type06_headline. 
		boolean exist = false;
		
		Elements elem = doc.select("ul.type06");	// exist �� false.
		//Elements elem2 = doc.select("ul.type06_headline");
		
		String s = elem.html();		// type06�� ��ü html.ul�� ��������
		
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		Matcher m = p.matcher(s);	// �̰��� RE�� ���� ��� ����Ʈ (href)�� ����.
		
		ArrayList<String> list = new ArrayList<>();
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);	// <href => �� ������ http link�� ����.
			
			if (!list.contains(ss.replaceAll("&amp;", "&"))) {	// & ǥ�� ����.
				list.add(ss.replaceAll("&amp;", "&"));
				System.out.println(ss);
			}
		}
		//return �� array list�� ����? string���� ����?
	}
	
	// String parameter�� article_read���� ���� url.
	public void script_process(String href_url) throws IOException {
		Document doc2 = Jsoup.connect(href_url).get();
		Elements e = doc2.select("div#articleBodyContents");
		String tmp = e.text();
		System.out.println(tmp);
		
		// script ���ʿ� ���� ����.
		
		// return News ��ü�� �ϸ� �ɵ�? server_main���� �޾Ƽ� DB_store() �ҷ��� �����Ű��.
	}
	
	public void duplicate_process() {}
	
	
}
