package com.care.sc;

import java.util.Date;

import com.care.news_dao.NewsDAO;

public class MyScheduler {
	public void schedul() {
		Date date = new Date();
		NewsDAO dao = new NewsDAO();
		int totNum = dao.count();
		System.out.println("등록된 총 게시물 수: "+totNum+"개");
		System.out.println(date);
	}
}
