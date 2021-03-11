package com.yaneodo.admin.codingtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yaneodo.DBUtil;

public class CodingtestDAO {
	
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CodingtestDAO() {
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

	public ArrayList<CodingtestDTO> getlist() {
		
		try {
			
			String sql = "select * from tbltest order by testseq";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			

			ArrayList<CodingtestDTO> list = new ArrayList<CodingtestDTO>();
			
			while(rs.next()) {
				CodingtestDTO dto = new CodingtestDTO();
				dto.setName(rs.getString("title"));
				dto.setSeq(rs.getString("testseq"));

				
				list.add(dto);
			}
			
				return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
