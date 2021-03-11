package com.yaneodo.jobnotice.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yaneodo.DBUtil;

public class CompanyDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public CompanyDAO() {
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

	public CompanyDTO get(String seq) {

		try {
			
			String sql = "select * from tblCompany where companySeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				
				CompanyDTO dto = new CompanyDTO();
				
				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setCompanyMemberSeq(rs.getString("companyMemberSeq"));
				dto.setName(rs.getString("name"));
				dto.setCountry(rs.getString("country"));
				dto.setRegion(rs.getString("region"));
				dto.setAddress(rs.getString("address"));
				dto.setRegNum(rs.getString("regnum"));
				dto.setSales(rs.getString("sales"));
				dto.setIndustry(rs.getString("industry"));
				dto.setEmployeeNum(rs.getString("employeeNum"));
				dto.setIntroduction(rs.getString("introduction"));
				dto.setEstablishment(rs.getString("establishment"));
				dto.setEmail(rs.getString("email"));
				dto.setWebAddress(rs.getString("webAddress"));
				dto.setPhoto(rs.getString("photo"));
				dto.setState(rs.getString("state"));
	
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	

}
