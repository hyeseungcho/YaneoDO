package com.yaneodo.admin.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.yaneodo.DBUtil;

import oracle.jdbc.OracleTypes;

public class CompanyDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public CompanyDAO() {
		
		//DB연결
		conn = DBUtil.open();
	}
	
	public void close() {
		
		try {
			
			conn.close();
			
		} catch (Exception e) {		
			System.out.println(e);			
		}
		
	}

	public ArrayList<CompanyDTO> list(HashMap<String, String> map) {
		
		try {

			String sql = String.format("select * from (select rownum as rnum, c.* from (select * from tblCompany) c) where rnum between %s and %s" 
					, map.get("begin")
					, map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<CompanyDTO> list = new ArrayList<CompanyDTO>();
			
			while (rs.next()) {
				
				CompanyDTO dto = new CompanyDTO();
				
				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setCompanyPhoto(rs.getString("photo"));
				dto.setCompanyName(rs.getString("name"));
				dto.setRegNum(rs.getString("regnum"));
				dto.setCompanyEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setState(rs.getString("state"));
				
				list.add(dto);
				
			}
			
			return list;

		} catch (Exception e) {
			System.out.println("CompanyDAO.list()");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	//MemberList 서블릿 > 멤버 리스트 개수 구하기
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql = "select count(*) as cnt from tblCustomer";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("CompanyDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		
		return 0;
		
	}

	public CompanyDTO company(String seq) {
		
		try {

			String sql = "{ call procCompany(?, ?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			ResultSet rs = (ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				
				CompanyDTO dto = new CompanyDTO();
				
				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setCompanyMemberSeq(rs.getString("companyMemberSeq"));
				dto.setCompanyName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setRegNum(rs.getString("regnum"));
				dto.setSales(rs.getString("sales"));
				dto.setIndustry(rs.getString("industry"));
				dto.setEmployeeNum(rs.getString("employeenum"));
				dto.setIntroduction(rs.getString("introduction"));
				dto.setEstablishment(rs.getString("establishment"));
				dto.setCompanyEmail(rs.getString("email"));
				dto.setWebAddress(rs.getString("webaddress"));
				dto.setCompanyPhoto(rs.getString("photo"));
				dto.setState(rs.getString("state"));
				dto.setManagerName(rs.getString("managername"));
				dto.setManagerPhone(rs.getString("managerphone"));
				dto.setManagerEmail(rs.getString("manageremail"));
				
				return dto;
				
			}

		} catch (Exception e) {
			System.out.println("CompanyDAO.company()");
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<CompanyDTO> jobOpening(String seq) {
		
		try {

			String sql = String.format("select * from tbljobOpening where companyseq = %s", seq);
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<CompanyDTO> jobOpeningList = new ArrayList<CompanyDTO>();
			
			while (rs.next()) {
				
				CompanyDTO dto = new CompanyDTO();
				
				dto.setTitle(rs.getString("title"));
				dto.setStartDate(rs.getString("startdate"));
				dto.setEndDate(rs.getString("enddate"));
				dto.setJob(rs.getString("job"));
				dto.setPlace(rs.getString("place"));
				dto.setDescription(rs.getString("description"));
				
				jobOpeningList.add(dto);
				
			}
			
			return jobOpeningList;

		} catch (Exception e) {
			System.out.println("CompanyDAO.resume()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int editState(CompanyDTO dto) {
		
		try {

			String sql = "update tblCompany set state = ? where companyseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getState());
			pstat.setString(2, dto.getCompanySeq());
			
			return pstat.executeUpdate(); //1 or 0

		} catch (Exception e) {
			System.out.println("CompanyDAO.editState()");
			e.printStackTrace();
		}
		
		return 0;
		
	}

}














