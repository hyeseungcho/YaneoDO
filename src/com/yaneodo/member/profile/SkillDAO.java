package com.yaneodo.member.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yaneodo.DBUtil;

public class SkillDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public SkillDAO() {
		//DB 연결
		conn = DBUtil.open();
	}
	
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Profile Edit서블릿 -> 스킬리스트 반환
	public ArrayList<SkillDTO> getlist() {
		
		try {
			
			String sql ="select * from tblSkill order by skillseq asc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			ArrayList<SkillDTO> list = new ArrayList<SkillDTO>();
			
			while(rs.next()) {
				SkillDTO dto = new SkillDTO();
				dto.setSkillSeq(rs.getString("skillSeq"));
				dto.setLanguageName(rs.getString("languageName"));
				
				list.add(dto);
			}
			
			return list;
		
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}


}
