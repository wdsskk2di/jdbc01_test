package com.care.news_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.news_dao.NewsDAO;
import com.care.news_dto.NewsDTO;

public class detailNews implements NewsService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String num = request.getParameter("num");
		
		NewsDAO dao = new NewsDAO();
		NewsDTO list = dao.detailInfo(num);
		model.addAttribute("list", list);
	}

}
