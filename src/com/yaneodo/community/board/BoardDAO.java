package com.yaneodo.community.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.yaneodo.DBUtil;

public class BoardDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardDAO() {
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
	
	
	
	//List 서블릿 -> 게시판 글목록 조회
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

//			if (map.get("search") != null) {
//
//				// 검색 중..
//				where = String.format("where name like '%%%s%%' or subject like '%%%s%%' or content like '%%%s%%'",
//						map.get("search"), map.get("search"), map.get("search"));
//
//			}

			// String sql = String.format("select * from vwBoard %s order by seq desc",
			// where);

			String sql = String.format("select * from vwBoard");

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			//ResultSet -> ArrayList<DTO>
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

			while (rs.next()) {
				// 레코드 1줄 -> DTO 1개
				BoardDTO dto = new BoardDTO();

				dto.setBoardSeq(rs.getString("boardseq"));
				dto.setCustomerSeq(rs.getString("customerseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writedate"));
				dto.setName(rs.getString("name"));
			
				list.add(dto); // ***

			}

			return list;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	
	//View 서블릿 -> 글1개 내용확인 
	public BoardDTO get(String seq) {

		try {
			
			String sql = "select * from vwBoard where boardseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setBoardSeq(rs.getString("boardSeq"));
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setName(rs.getString("name"));
			
				
				return dto;				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

}
