package com.yaneodo.jobnotice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yaneodo.DBUtil;
import com.yaneodo.member.MemberDTO;

public class ApplyDAO {
	
	
	
	private Connection conn;
	private Statement stat; 
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ApplyDAO() {

		conn = DBUtil.open();
	}


	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}



	//지원테이블에 (상태: 지원중)으로 추가
	public int add(ApplyDTO dto) {
		
		try {
			
			String sql = "insert into tblApply (applySeq, jobOpeningSeq, applyStatusSeq, customerSeq, applyDate)" + 
					"	values (applySeq.nextVal, ?, 1, ?, default)"; // applyStatuseSeq = 1 : 지원중
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getJobOpeningSeq());
			pstat.setString(2, dto.getCustomerSeq());
		
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		
		return 0;
	}
	
	
	

}
