package com.yaneodo.company.volunteer;

public class VolunteerDTO {
	
	private String pseq; // 프로필 번호
	private String cmseq; // 기업회원 번호
	private String aseq; // 지원공고 번호
	
	private String name; // 회원 이름
	private String job; // 공고 직무
	private String isread; // 이력서 열람여부 1:열람 / 0:미열람
	private String isdibs; // 이력서 좋아요 여부 1:좋아요 / 0:안좋아요
	private String asseq; // 지원상태번호 1:? 2:? 3:? 4:? 5:?
	
	
	
	
	public String getAseq() {
		return aseq;
	}
	public void setAseq(String aseq) {
		this.aseq = aseq;
	}
	public String getAsseq() {
		return asseq;
	}
	public void setAsseq(String asseq) {
		this.asseq = asseq;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	public String getCmseq() {
		return cmseq;
	}
	public void setCmseq(String cmseq) {
		this.cmseq = cmseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	public String getIsdibs() {
		return isdibs;
	}
	public void setIsdibs(String isdibs) {
		this.isdibs = isdibs;
	}
	
	
	

}
