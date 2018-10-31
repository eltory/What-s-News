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
		
		// Hash set을 여기서 하는게 맞는지 모르겠음.
		//setSid();
	}
	
	public void setSid() {      
	      /* 
	       * 네이버 뉴스
	       * sid1 -> major: 대분류
	       * sid2 -> sub: 소분류
	       */
	      sid_major.put("정치", "100"); 
	      sid_sub.put("청와대", "264");
	      sid_sub.put("국회/정당", "265");
	      sid_sub.put("북한", "268");
	      sid_sub.put("행정", "266");
	      sid_sub.put("국방/외교", "267");
	      sid_sub.put("정치일반", "269");
	      
	      sid_major.put("경제", "101");
	      sid_sub.put("금융", "259");
	      sid_sub.put("증권", "258");
	      sid_sub.put("산업/재계", "261");
	      sid_sub.put("중기/벤처", "771");
	      sid_sub.put("부동산", "260");
	      sid_sub.put("글로벌 경제", "262");
	      sid_sub.put("생활경제", "310");
	      sid_sub.put("경제 일반", "263");
	      
	      sid_major.put("사회", "102");
	      sid_sub.put("사건사고", "249");
	      sid_sub.put("교육", "250");
	      sid_sub.put("노동", "251");
	      sid_sub.put("언론", "254");
	      sid_sub.put("환경", "252");
	      sid_sub.put("인권/복지", "59b");
	      sid_sub.put("식품/의료", "255");
	      sid_sub.put("지역", "256");
	      sid_sub.put("인물", "276");
	      sid_sub.put("사회 일반", "257");
	      
	      sid_major.put("생활/문화", "103");
	      sid_sub.put("건강정보", "241");
	      sid_sub.put("자동차/시승기", "239");
	      sid_sub.put("도로/교통", "240");
	      sid_sub.put("여행/레저", "237");
	      sid_sub.put("음식/맛집", "238");
	      sid_sub.put("패션/뷰티", "376");
	      sid_sub.put("공연/전시", "242");
	      sid_sub.put("책", "243");
	      sid_sub.put("종교", "244");
	      sid_sub.put("날씨", "248");
	      sid_sub.put("생활문화 일반", "245");
	      
	      sid_major.put("세계", "104");
	      sid_sub.put("아시아/호주", "231");
	      sid_sub.put("미국/중남미", "232");
	      sid_sub.put("유럽", "233");
	      sid_sub.put("중동/아프리카", "234");
	      sid_sub.put("세계 일반", "322");
	      
	      sid_major.put("IT/과학", "105");
	      sid_sub.put("모바일", "731");
	      sid_sub.put("인터넷/SNS", "226");
	      sid_sub.put("통신/뉴미디어", "227");
	      sid_sub.put("IT 일반", "230");
	      sid_sub.put("보안/해킹", "732");
	      sid_sub.put("컴퓨터", "283");
	      sid_sub.put("게임/리뷰", "229");
	      sid_sub.put("과학 일반", "228");      
	   }
	
	// Hash set을 통해 server_main에서 major, sub의 sid를 알 수 있다.
	
	// Stirng parameter는 major + sub sid가 입력된 url.
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
		while (m.find()) {
			String ss = m.group().substring(6, m.group().length() - 1);	// <href => 을 제외한 http link만 추출.
			
			if (!list.contains(ss.replaceAll("&amp;", "&"))) {	// & 표시 제거.
				list.add(ss.replaceAll("&amp;", "&"));
				System.out.println(ss);
			}
		}
		//return 을 array list로 할지? string으로 할지?
	}
	
	// String parameter는 article_read에서 읽은 url.
	public void script_process(String href_url) throws IOException {
		Document doc2 = Jsoup.connect(href_url).get();
		Elements e = doc2.select("div#articleBodyContents");
		String tmp = e.text();
		System.out.println(tmp);
		
		// script 불필요 내용 제거.
		
		// return News 객체로 하면 될듯? server_main에서 받아서 DB_store() 불러서 저장시키게.
	}
	
	public void duplicate_process() {}
	
	
}
