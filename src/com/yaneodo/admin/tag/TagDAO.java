package com.yaneodo.admin.tag;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yaneodo.DBUtil;



public class TagDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public TagDAO() {
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




	
	//tagcategory 서블릿 -> 태그카테고리 종류를 주세요
	public ArrayList<TagDTO> getlist() {
		
		try {
			
			String sql ="select * from tbltagcategory order by tagCategorySeq";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			ArrayList<TagDTO> list = new ArrayList<TagDTO>();
			
			while(rs.next()) {
				TagDTO dto = new TagDTO();
				dto.setSeq(rs.getString("tagCategorySeq"));
				dto.setTitle(rs.getString("tagCategoryName"));
				
				list.add(dto);
			}
			
			return list;
		
					
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	//tagcategoryupdate 서블릿 -> 확인해서 추가 / 수정하기
	public int newlist(String title, String tagseq, String add) {
		
		try {
			
			int count = 0;
			
			if( add.equals("add") ) {  // 추가하기
				
				
				
				String sql = "INSERT INTO tblTagCategory (tagCategorySeq, tagCategoryName) VALUES (tagCategorySeq.nextVal,?)";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, title);
				
				
				pstat.executeUpdate();
				
			} else { //수정하기
				
				String sql = "update tblTagCategory set tagCategoryName = ? where tagCategorySeq = ?";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, title);
				pstat.setString(2, tagseq);
				
				pstat.executeUpdate();
				
			}
			
			return count;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	//tag 서블릿 -> 태그 종류를 주세요
	public ArrayList<TagDTO> gettaglist() {
			
		try {
			
			String sql ="select t.tagseq as cseq, (select tagCategoryName from tbltagcategory tc where tc.tagCategorySeq = t.tagCategorySeq)as cname, t.tagname as tname from tbltag t order by cname";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			ArrayList<TagDTO> list = new ArrayList<TagDTO>();
			
			while(rs.next()) {
				TagDTO dto = new TagDTO();
				dto.setTitle(rs.getString("cname")); //카테고리이름
				dto.setTtitle(rs.getString("tname")); //태그이름
				dto.setSeq(rs.getString("cseq")); //태그번호
				
				list.add(dto);
			}
			
			return list;
		
					
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
			
		
	}


	public int getnewtaglist(String ttitle, String ctitle, String add) {
		
		//ttitle : 태그이름
		//ctitle : 태그카테고리번호
		
		try {
			
			int count = 0;
			
			if( add.equals("add") ) {  // 추가하기
				
				
				
				String sql = "INSERT INTO tblTag (tagSeq, tagCategorySeq, tagName) VALUES (tagSeq.nextVal, ?, ?)";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, ctitle);
				pstat.setString(2, ttitle);
				
				
				pstat.executeUpdate();
				
			} else { //수정하기
				
				String sql = "update tbltag set tagname = ? where tagseq = ?";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, ttitle);//이름
				pstat.setString(2, ctitle);//번호
				
				pstat.executeUpdate();
				
			}
			
			return count;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}


	
}
