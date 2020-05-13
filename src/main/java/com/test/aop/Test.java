package com.test.aop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.care.member_dao.MemberDAO;

@Aspect
public class Test {
	
	Date date;
	DateFormat df = new SimpleDateFormat("YYYYMMddhhmm");
	
	MemberDAO dao;
	
	@After("execution(* com.care.controller.MemberController.successLoginFinal())")
	public void loginTime(JoinPoint joinpoint) {
		
		try {
			System.out.println("로그인 되었습니다");
			//세션의 아이디값		
			HttpSession session = 
					((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();		
			String UserID = (String)session.getAttribute("UserID");
			System.out.println("아이디 값: "+UserID);
			
			//로그인 시간값
			date = new Date();
			String inTime = df.format(date);
			System.out.println("로그인 시간: "+inTime);
			
			//DB저장
			dao = new MemberDAO();
			dao.inTime(UserID, inTime);
			
		} catch (Throwable e) {
			System.out.println("오류");
		}

	}
	
	@Before("execution(* com.care.controller.MemberController.logout(*))")
	public void logoutTime(JoinPoint joinpoint) {
		
		try {
			System.out.println("로그아웃 되었습니다");
			//세션의 아이디값
			HttpSession session = 
					((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();		
			String UserID = (String)session.getAttribute("UserID");
			System.out.println("아이디 값: "+UserID);
			
			//로그아웃 시간값
			date = new Date();
			String outTime = df.format(date);
			System.out.println("로그아웃 시간: "+outTime);
			
			//DB저장
			dao = new MemberDAO();
			dao.outTime(UserID, outTime);
			
			//시간
			String time = dao.time(UserID);	

			long useTime = Long.parseLong(outTime) - Long.parseLong(time);
			String usingTime = Long.toString(useTime);
			System.out.println("총사용 시간: "+useTime/60000+"분");
			dao.usingTime(UserID, usingTime);
			
		} catch (Throwable e) {
			System.out.println("오류");
		}

	}
}
/*
 create table member02_time(id varchar2(20), in_Time VARCHAR2(20), out_Time varchar2(20), using_time varchar2(20));
insert into MEMBER02_TIME values(2,null,null,null);
 */
