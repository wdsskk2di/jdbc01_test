package com.care.news_dto;

public class NewsDTO {
	private int num;
	private String title;
	private String content;
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}	
	
}


/*
create table news(num number, title varchar(30), content varchar(50));

insert into news VALUES(2, '두번째 공지', '두번째 공지의 내용');
 */