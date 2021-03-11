package com.yaneodo.community.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.yaneodo.DBUtil;


public class QnADAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public QnADAO() {
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
	
	


	
	//qna게시판 목록조회
	public ArrayList<QnADTO> list(HashMap<String, String> map) {
		
		
		try {

			String where = "";

//			if (map.get("search") != null) {
//
//				// 검색 중..
//				where = String.format("where name like '%%%s%%' or subject like '%%%s%%' or content like '%%%s%%'",
//						map.get("search"), map.get("search"), map.get("search"));
//
//			}

			// String sql = String.format("select * from vwQnA %s order by seq desc",
			// where);

			String sql = String.format("select * from vwQnA");

			System.out.println(sql);

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			//ResultSet -> ArrayList<DTO>
			ArrayList<QnADTO> list = new ArrayList<QnADTO>();

			while (rs.next()) {
				// 레코드 1줄 -> DTO 1개
				QnADTO dto = new QnADTO();

				dto.setQnaSeq(rs.getString("qnaseq"));
				dto.setCustomerSeq(rs.getString("customerseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writedate"));
				
//				System.out.println(dto.getQnASeq());
			
			
				list.add(dto); // ***

			}

			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}

}
