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
	public void save(final String id, final String name) {
		String sql = "insert into member02(id, name) values(?,?)";

		template.update(sql, new PreparedStatementSetter() {
				
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
				ps.setString(2, name);
			}
		});
	}
	
	//수정하기 전 수정하려는 id가 있는지 확인
	public MemberDTO modify(String id) {

		String sql = "select * from member02 where id="+id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	//수정하기
	public void modifySave(String id, String name) {
		String sql = "update member02 set name='"+name+"' where id="+id;
		template.update(sql);
	}
	
	//삭제하기
	public void delete(String id) {
		String sql = "delete from member02 where id="+id;
		template.update(sql);
	}
	
	//등록된 총 갯수
	public int count() {
		String sql = "select count(*) from member02";
		return template.queryForObject(sql, Integer.class);
	}
}
