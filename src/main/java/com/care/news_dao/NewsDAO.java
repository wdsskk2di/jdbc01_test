package com.care.news_dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.news_dto.NewsDTO;
import com.care.template.Constant;

public class NewsDAO {
	private JdbcTemplate template;
	
	public NewsDAO() {this.template = Constant.template;}

	//목록보기
	public ArrayList<NewsDTO> list() {
		String sql = "select num, title from news order by num asc";
		ArrayList<NewsDTO> list = (ArrayList<NewsDTO>)template.query(sql, new BeanPropertyRowMapper<NewsDTO>(NewsDTO.class));
		
		return list;
	}
		
	//목록 자세히
	public NewsDTO detailInfo(String num) {
		String sql = "select * from news where num='"+num+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<NewsDTO>(NewsDTO.class));
	}
	
	//등록된 게시글 총 갯수
	public int count() {
		String sql = "select count(*) from news";//테이블 이름 찾아야
		return template.queryForObject(sql, Integer.class);
	}
	
}
