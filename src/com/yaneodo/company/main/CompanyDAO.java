package com.yaneodo.company.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

import com.yaneodo.DBUtil;

public class CompanyDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CompanyDAO() {
		conn = DBUtil.open();
	}
	
	
	public void close() {
		
		try {
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//companyJoin servlet -> 아이디 중복검사 요청
	public int checkId(String email) {
		
		try {
			
			String sql = "select count(*) as cnt from tblCompanyMember where email = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, email);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	
	
	//company register servlet
	public int add(CompanyDTO dto) {
		
		try {
			
			String sql = "insert into tblCompany(companySeq, companyMemberSeq, name, country, region, address, regNum, sales, industry, employeeNum, introduction, establishment, email, webAddress, photo, state) values (companySeq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '0')";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getCompanyMemberSeq());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getCountry());
			pstat.setString(4, dto.getRegion());
			pstat.setString(5, dto.getAddress());
			pstat.setString(6, dto.getRegNum());
			pstat.setString(7, dto.getSales());
			pstat.setString(8, dto.getIndustry());
			pstat.setString(9, dto.getEmployeeNum());
			pstat.setString(10, dto.getIntroduction());
			pstat.setString(11, dto.getEstablishment());
			pstat.setString(12, dto.getEmail());
			pstat.setString(13, dto.getWebAddress());
			pstat.setString(14, dto.getPhoto());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	//registered servled -> 기업등록 & 미승인 회원의 기업정보 가져오기
	public CompanyDTO getCompany(String cmseq) {

		try {
			
			String sql = "select * from tblCompany where companyMemberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, cmseq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				CompanyDTO dto = new CompanyDTO();
				
				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setName(rs.getString("name"));
				dto.setCountry(rs.getString("country"));
				dto.setRegion(rs.getString("region"));
				dto.setAddress(rs.getString("address"));
				dto.setRegNum(rs.getString("regNum"));
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
