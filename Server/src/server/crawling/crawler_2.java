package server.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawler_2 {
	public static void main(String[] args) throws IOException {
		// URL�� "https://news.naver.com/" �� ���̹� ���� �⺻ home���� ����.
		// <body-wrap-header-lnb_inner-lnb_menu-li>�� ���� ��ġ~IT�� href read.
		// ����� news-IT �� url�� ����.(���� ���� skip�Ǿ� �ִ� ��.)
		final String URL = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=731";
		// Hash�� Major sid �� ù-�� loop ����. (�� major �� thread ����.)
		// Thread���� sub sid �� ù-�� loop ���鼭 �� sid�� head->body (20��) ��� �а�
		// ��� text�� text processing method call �ϰ� ������ text�� news ��ü�� ����.
		// �� ��ü�� DB�� ����.
		// �̰� IT(major)�� �����(sub)�� ��� �Ѱ��� read-process-store ����.
		
		Pattern p = Pattern.compile("href=\"(.*?)\"");	// href�� ��ũ�� �������� ���� RE.

		Document doc = Jsoup.connect(URL).get();	// URL�� html�� doc ��ü�� ����.
		Elements elem = doc.select("ul.type06");	// Element ��ü�� ���� doc�� ���� content�� ����. (type06�� ��� 10�� �����ϰ� �ִ� �ϴ� ����.)
		Elements elem2 = doc.select("ul.type06_headline");	// (type06_headline�� ��� 10�� �����ϰ� �ִ� ��� ����.)

		ArrayList<String> list = new ArrayList<>();
		
		String s = elem.html();
		String s2 = elem2.html();
		
		Matcher m = p.matcher(s);
		
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);	// <href => �� ������ http link�� ����.
			
			if (!list.contains(ss.replaceAll("&amp;", "&")))	// & ǥ�� ����.
				list.add(ss.replaceAll("&amp;", "&"));
		}
		
		m = p.matcher(s2);
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);
			if (!list.contains(ss.replaceAll("&amp;", "&")))
				list.add(ss.replaceAll("&amp;", "&"));
		}
		
		for (String pp : list) {
			System.out.println(pp);
		}
		
		String url_ = "https://news.naver.com/main/read.nhn?mode=LS2D&mid=shm&sid1=105&sid2=731&oid=015&aid=0004025705";	
		Document doc2 = Jsoup.connect(url_).get();
		Elements e = doc2.select("div#articleBodyContents");
		String tmp = e.text();
		System.out.println(tmp);
		
		System.out.println("Length " + list.size());
	}
}