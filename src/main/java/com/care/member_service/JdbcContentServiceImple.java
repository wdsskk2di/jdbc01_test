package com.care.member_service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.member_dao.MemberDAO;
import com.care.member_dto.MemberDTO;

public class JdbcContentServiceImple implements MemberService {

	@Override
	public void execute(Model model) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.list();	//list라는 변수에 = dao의 list메소드 실행 결과 저장
		model.addAttribute("list", list);	//list라는 Attribute에 list변수 값 저장
		
		//추가
		model.addAttribute("count", dao.count());
	}

}
