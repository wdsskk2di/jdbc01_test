package com.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member_service.MemberContentServiceImple;
import com.care.member_service.MemberDeleteserviceImple;
import com.care.member_service.MemberDetailServiceImple;
import com.care.member_service.MemberLoginImple;
import com.care.member_service.MemberModifySaveserviceImple;
import com.care.member_service.MemberModifyserviceImple;
import com.care.member_service.MemberSaveServiceImple;
import com.care.member_service.MemberService;
import com.care.news_service.NewsService;
import com.care.news_service.detailNews;
import com.care.news_service.showNews;
import com.care.template.Constant;

@Controller
public class MemberController {
	
	private MemberService jdbc;
	private NewsService ns;
	
	public MemberController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}	
	
	@RequestMapping("index")
	public String index() {
		return "default/main";
	}
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("loginChk")
	public String loginChk(HttpServletRequest request, Model model) {		
		model.addAttribute("request", request);
		jdbc = new MemberLoginImple();
		jdbc.execute(model);
		
		return "member/successLogin";
	}
	
	@RequestMapping("successLoginFinal")
	public String successLoginFinal() {
		return "successLoginFinal";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("세션 삭제");
		return "redirect:login";
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo(HttpSession session, Model model) {
		if(session.getAttribute("loginSuccess") != null) {
			jdbc = new MemberContentServiceImple();
			jdbc.execute(model);
			
			return "member/memberInfo";
		}else {
			return "redirect:login";	// member/login라고 쓰면 주소창이 Http://localhost:8088/memberInfo 
		}								// redirect:login라고 쓰면 주소창이 Http://localhost:8088/login
	}	
	
	@RequestMapping("memDetailInfo")
	public String memberDetailInfo(HttpSession session, HttpServletRequest request, Model model) {
		if(session.getAttribute("loginSuccess") != null) {
			
			model.addAttribute("request", request);
			jdbc = new MemberDetailServiceImple();
			jdbc.execute(model);
			
			return "member/memDetailInfo";
		}else {
			return "redirect:login";
		}
	}
	
	
	@RequestMapping("register")
	public String register() {
		return "member/register";
	}
	
	
	@PostMapping("save")
	public String save(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		jdbc = new MemberSaveServiceImple();
		jdbc.execute(model);
		
		return "member/registerChk";
	}
	
	//수정화면
	@RequestMapping("modify")
	public String modify(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new MemberModifyserviceImple();
		jdbc.execute(model);
		
		return "member/modify";
	}
	
		//DB연결 수정 메소드
	@RequestMapping("modifySave")
	public String modifySave(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new MemberModifySaveserviceImple();
		jdbc.execute(model);
		
		return "redirect:memberInfo";
	}
	
	//삭제
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		jdbc = new MemberDeleteserviceImple();
		jdbc.execute(model);

		return "member/delete";
	}
	
	//게시판
	@RequestMapping("news")
	public String news(Model model) {
		ns = new showNews();
		ns.execute(model);
		return "news/news";
	}
	
	//게시판 자세히
	@RequestMapping("content_view")
	public String content_view(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		ns = new detailNews();
		ns.execute(model);
		return "news/content_view";
	}

}
