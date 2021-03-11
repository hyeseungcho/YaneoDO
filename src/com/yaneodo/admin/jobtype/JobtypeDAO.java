package com.yaneodo.admin.jobtype;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yaneodo.DBUtil;



public class JobtypeDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public JobtypeDAO() {
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




	
	//Jobtype 서블릿 -> 직무 종류를 주세요
	public ArrayList<JobtypeDTO> getlist() {
		
		try {
			
			String sql ="select jobseq, type from tbljob order by jobseq asc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			ArrayList<JobtypeDTO> list = new ArrayList<JobtypeDTO>();
			
			while(rs.next()) {
				JobtypeDTO dto = new JobtypeDTO();
				dto.setJobtype(rs.getString("type"));
				dto.setSeq(rs.getString("jobseq"));
				
				list.add(dto);
			}
			
			return list;
		
					
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	//jobtypeupdate 서블릿 -> 리스트 삭제하고 다시 올리기
	public int newlist(String title, String jobseq, String add) {
		
		try {
			
			int count = 0;
			
			if( add.equals("add") ) {  
				
				
				
				String sql = "INSERT INTO tblJob (jobSeq, type) VALUES (jobSeq.nextVal,?)";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, title);
				
				
				System.out.println(pstat.executeUpdate());
				
			} else {
				
				String sql = "update tbljob set type = ? where jobseq = ?";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, title);
				pstat.setString(2, jobseq);
				
				pstat.executeUpdate();
				
				
			}
			
			return count;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}


	
}
