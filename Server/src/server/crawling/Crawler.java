package server.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import server.controller.message.News;
import server.crawling.section.Economy;
import server.crawling.section.IT;
import server.crawling.section.Living;
import server.crawling.section.Politics;
import server.crawling.section.Society;
import server.crawling.section.World;

public class Crawler {
	public static final String root = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm";
	public News n2 = new News();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IT it = new IT();
		System.out.println("IT 객체 : ");
		//Living liv = new Living();
	    //Politics pol = new Politics();
	    //Society soc = new Society();
	    //World wor = new World();
	    //Economy eco = new Economy();

	}

	public void article_read(String major_sub) throws IOException {
		Document doc = Jsoup.connect(major_sub).get();
		
		// Search type06 and type06_headline. 
		boolean exist = false;
		
		Elements elem = doc.select("ul.type06");	// exist 가 false.
		//Elements elem2 = doc.select("ul.type06_headline");
		
		String s = elem.html();		// type06의 전체 html.ul을 가져오고
		
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		Matcher m = p.matcher(s);	// 이것을 RE를 통해 기사 리스트 (href)만 추출.
		
		ArrayList<String> list = new ArrayList<>();
		int i = 0;
		
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);	// <href => 을 제외한 http link만 추출.
			
			if (!list.contains(ss.replaceAll("&amp;", "&"))) {	// & 표시 제거.
				list.add(ss.replaceAll("&amp;", "&"));
				System.out.println(ss);
				
				script_process(list.get(i++));
			}
		}
		//return 을 array list로 할지? string으로 할지?
	}
	
	// String parameter는 article_read에서 읽은 url.
	public void script_process(String href_url) throws IOException {
		Document doc2 = Jsoup.connect(href_url).get();
		String id = doc2.select("script").html().substring(545, 555); // 뉴스 아이디
	    String head = doc2.select("h3#articleTitle").text(); // 뉴스 타이틀
	    String time = doc2.select("span.t11").text(); // 뉴스 시간
	    String body = doc2.select("div#articleBodyContents").text(); // 뉴스 본문

//		Elements e = doc2.select("div#articleBodyContents");
//		String tmp = e.text();
//		System.out.println(tmp);
		
	    set_news(id, head, time, body);
		// script 불필요 내용 제거.
		
	}
	
	 public void set_news(String id, String head, String time, String body) {
	      News news = new News();
	      news.setId(id);
	      news.setHead_line(head);
	      news.setTimes(time);
	      news.setData(body);
	      System.out.println("id: " + news.getId());
	      System.out.println("title: " + news.getHead_line());
	      System.out.println("time: " + news.getTimes());
	      n2.setId(id);
	      n2.setHead_line(head);
	      n2.setTimes(time);
	      n2.setData(body);
	      
	   }
	
	 public News get_news() {
		 //Gson g = new Gson();
		 
		 //System.out.println("JSON 나오니? " +g.toJson(n2));
	//	 if(n2 != null)
		//	 return new Gson().toJson(n2);
		// else
			// return "NULL이래";
		 return n2;
	 }
	 
	public void duplicate_process() {
		
	}
}
