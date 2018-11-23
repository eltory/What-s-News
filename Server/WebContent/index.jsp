<%@ page import="server.crawling.Crawler"
	import="server.controller.message.News" import="com.google.gson.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		final Crawler c = new Crawler();
		c.main(null);
		request.setCharacterEncoding("UTF-8");
		String exec = request.getParameter("exec");
		if (exec != null && exec.equals("run")) {

			//String type = request.getParameter("type");
			String msg = request.getParameter("msg");
			News news = c.n2;

			//Main main = new Main();
			//main.main(null);
			//OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
			//System.out.println("요청메세지" + msg + "Client : " + request.getParameter("client"));
			response.getWriter().write("NEWS " + new Gson().toJson(news));
			//out.println("서버의 응답");
		} else if (exec != null && exec.equals("no")) {
			System.out.println("요청을 하지 않았음" + "Client : " + request.getParameter("client"));
		}
	%>
</body>