package com.care.news_service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.news_dao.NewsDAO;
import com.care.news_dto.NewsDTO;

public class showNews implements NewsService {

	@Override
	public void execute(Model model) {
		NewsDAO dao = new NewsDAO();
		ArrayList<NewsDTO> list = dao.list();	//list라는 변수에 = dao의 list메소드 실행 결과 저장
		model.addAttribute("list", list);
	}

}
