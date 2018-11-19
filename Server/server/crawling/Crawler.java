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
		System.out.println("IT ��ü : ");
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
		
		Elements elem = doc.select("ul.type06");	// exist �� false.
		//Elements elem2 = doc.select("ul.type06_headline");
		
		String s = elem.html();		// type06�� ��ü html.ul�� ��������
		
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		Matcher m = p.matcher(s);	// �̰��� RE�� ���� ��� ����Ʈ (href)�� ����.
		
		ArrayList<String> list = new ArrayList<>();
		int i = 0;
		
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);	// <href => �� ������ http link�� ����.
			
			if (!list.contains(ss.replaceAll("&amp;", "&"))) {	// & ǥ�� ����.
				list.add(ss.replaceAll("&amp;", "&"));
				System.out.println(ss);
				
				script_process(list.get(i++));
			}
		}
		//return �� array list�� ����? string���� ����?
	}
	
	// String parameter�� article_read���� ���� url.
	public void script_process(String href_url) throws IOException {
		Document doc2 = Jsoup.connect(href_url).get();
		String id = doc2.select("script").html().substring(545, 555); // ���� ���̵�
	    String head = doc2.select("h3#articleTitle").text(); // ���� Ÿ��Ʋ
	    String time = doc2.select("span.t11").text(); // ���� �ð�
	    String body = doc2.select("div#articleBodyContents").text(); // ���� ����

//		Elements e = doc2.select("div#articleBodyContents");
//		String tmp = e.text();
//		System.out.println(tmp);
		
	    set_news(id, head, time, body);
		// script ���ʿ� ���� ����.
		
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
		 
		 //System.out.println("JSON ������? " +g.toJson(n2));
	//	 if(n2 != null)
		//	 return new Gson().toJson(n2);
		// else
			// return "NULL�̷�";
		 return n2;
	 }
	 
	public void duplicate_process() {
		
	}
}
