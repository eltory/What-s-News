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
		// URL은 "https://news.naver.com/" 로 네이버 뉴스 기본 home으로 세팅.
		// <body-wrap-header-lnb_inner-lnb_menu-li>를 통해 정치~IT의 href read.
		// 현재는 news-IT 가 url로 세팅.(위의 과정 skip되어 있는 것.)
		final String URL = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=731";
		// Hash의 Major sid 를 첫-끝 loop 돌기. (각 major 당 thread 생성.)
		// Thread에서 sub sid 의 첫-끝 loop 돌면서 각 sid의 head->body (20개) 기사 읽고
		// 기사 text를 text processing method call 하고 가공된 text를 news 객체로 저장.
		// 이 객체를 DB에 저장.
		// 이게 IT(major)의 모바일(sub)의 기사 한개의 read-process-store 과정.
		
		Pattern p = Pattern.compile("href=\"(.*?)\"");	// href의 링크를 가져오기 위한 RE.

		Document doc = Jsoup.connect(URL).get();	// URL의 html을 doc 객체에 저장.
		Elements elem = doc.select("ul.type06");	// Element 객체를 통해 doc의 내부 content에 접근. (type06이 기사 10개 저장하고 있는 하단 섹션.)
		Elements elem2 = doc.select("ul.type06_headline");	// (type06_headline이 기사 10개 저장하고 있는 상단 섹션.)

		ArrayList<String> list = new ArrayList<>();
		
		String s = elem.html();
		String s2 = elem2.html();
		
		Matcher m = p.matcher(s);
		
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);	// <href => 을 제외한 http link만 추출.
			
			if (!list.contains(ss.replaceAll("&amp;", "&")))	// & 표시 제거.
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