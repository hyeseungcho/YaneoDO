package com.yaneodo.community.board;

public class BoardDTO {
	
	private String boardSeq;
	private String customerSeq;
	private String title;
	private String content;
	private String writeDate;
	
	//작성회원이름
	private String name; 
	
	
	public String getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getCustomerSeq() {
		return customerSeq;
	}
	public void setCustomerSeq(String customerSeq) {
		this.customerSeq = customerSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
