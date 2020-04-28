package com.care.member_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.member_dao.MemberDAO;

public class JdbcSaveServiceImple implements MemberService {
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		MemberDAO dao = new MemberDAO();
		dao.save(id, name);
	}
}
