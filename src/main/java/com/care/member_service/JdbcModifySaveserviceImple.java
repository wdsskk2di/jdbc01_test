package com.care.member_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.member_dao.MemberDAO;

public class JdbcModifySaveserviceImple implements MemberService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//model.asMap() == model을 map형태로 변환
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//map형태를 request로 변환
		String id = request.getParameter("id");	//id 파람 값 가져옴
		String name = request.getParameter("name");	//name 파람 값 가져옴
		
		MemberDAO dao = new MemberDAO();
		dao.modifySave(id, name); //DB연결해서 modifySave 메소드 실행
	}

}
