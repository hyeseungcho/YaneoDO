package com.yaneodo.company.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yaneodo.DBUtil;

public class CmemberDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CmemberDAO() {
		conn = DBUtil.open();
	}
	
	
	public void close() {

		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//LoginOk Servlet -> 기업회원 로그인 요청
	public int login(CmemberDTO dto) {
		
		try {
			
			String sql = "select count(*) as cnt from tblCompanyMember where email = ? and password = ?"; 
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getEmail());
			pstat.setString(2, dto.getPassword());
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
	
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}	

		return 0;
	}
	

	//LoginOk Servlet -> 기업회원 정보 가져오기
	public CmemberDTO getMember(String email) {
		
		System.out.println(email);
		
		try {
			
			//기업회원 번호, 승인여부
			String sql = "select c.companyMemberSeq as companyMemberSeq, (select state from tblCompany where companyMemberSeq = c.companyMemberSeq) as state from tblCompanyMember c where email = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, email);
			rs = pstat.executeQuery();
			

			if (rs.next()) {
				
				CmemberDTO dto = new CmemberDTO();
				
				dto.setCompanyMemberSeq(rs.getString("companyMemberSeq"));
				dto.setState(rs.getString("state"));
				
				return dto;
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		
			return null;
		}

	
	//Join servlet -> 기업회원 회원가입
	public int join(CmemberDTO dto) {
		
		try {
			
			String sql = "insert into tblCompanyMember (companyMemberSeq, managerName, managerPhone, email, password, pass) "
						+ "values (companyMemberSeq.nextVal, ?, ?, ?, ?, 0)";	
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getManagerName());
			pstat.setString(2, dto.getManagerPhone());
			pstat.setString(3, dto.getEmail());
			pstat.setString(4, dto.getPassword());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}


	
	

	
	
	
	
	
	
	
	
	

}
