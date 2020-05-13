package com.care.member_dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.care.member_dto.MemberDTO;
import com.care.template.Constant;

public class MemberDAO {
	private JdbcTemplate template;
	
	public MemberDAO() {this.template = Constant.template;}

	//목록보기
	public ArrayList<MemberDTO> list() {
		String sql = "select * from member02 order by id asc";
		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)template.query(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		
		return list;
	}
	
	//저장하기
	public int save(final String id, final String pw) {
		String sql = "insert into member02(id, pw) values(?,?)";

		try {				
			template.update(sql, new PreparedStatementSetter() {
				
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
				ps.setString(2, pw);
			}
		});
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	//로그인
	public int login(String id, String pw) {
		String sql = "select count(*) from member02 where id='"+id+"' and pw ='"+pw+"'";
		
		if(template.queryForObject(sql, Integer.class) == 0)  return 0;
		else return 1;
		//return template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	
	}	
	
	//목록 자세히
	public MemberDTO detailInfo(String id) {
		String sql = "select * from member02 where id='"+id+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	//수정하려는 id와 pw 가져오기
	public MemberDTO modify(String id) {
		String sql = "select * from member02 where id='"+id+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	//수정하기
	public void modifySave(String id, String pw) {
		String sql = "update member02 set pw='"+pw+"' where id='"+id+"'";
		template.update(sql);
	}
	
	//삭제하기
	public int delete(String id) {
		String sql = "delete from member02 where id='"+id+"'";
		try {
			template.update(sql);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	//등록된 게시글 총 갯수
	public int count() {
		String sql = "select count(*) from member02";//테이블 이름 찾아야
		return template.queryForObject(sql, Integer.class);
	}
	
	//로그인 시간
	public void inTime(String UserID, String inTime) {
		String sql = "update MEMBER02_TIME set in_time='"+inTime+"' where id='"+UserID+"'";
		template.update(sql);
	}
	
	//로그아웃 시간
	public void outTime(String UserID, String outTime) {
		String sql = "update MEMBER02_TIME set out_time='"+outTime+"' where id='"+UserID+"'";
		template.update(sql);
	}
	
	//사용시간 체크위한 메소드
	public String time(String UserID) {
		String sql = "select in_time  from member02_time where id='"+UserID+"'";
		return template.queryForObject(sql, String.class);
	}
	
	//사용시간
	public void usingTime(String UserID, String usingTime) {
		String sql = "update MEMBER02_TIME set using_Time='"+usingTime+"' where id='"+UserID+"'";
		template.update(sql);
	}
}
