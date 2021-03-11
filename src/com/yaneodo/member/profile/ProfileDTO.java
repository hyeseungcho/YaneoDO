package com.yaneodo.member.profile;

public class ProfileDTO {
	
	private String profileseq;
	private String resumeseq;
	private String jobtype; // subquery로 직무 type
	private String isworkseq;
	private String school;
	private String major;
	private String company;
	private String career;
	private String introduction;
	
	
	private String isdibs;
	private String isread;
	private String ismatch;
	
	
	
	
	
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	public String getIsmatch() {
		return ismatch;
	}
	public void setIsmatch(String ismatch) {
		this.ismatch = ismatch;
	}
	public String getIsdibs() {
		return isdibs;
	}
	public void setIsdibs(String isdibs) {
		this.isdibs = isdibs;
	}
	public String getProfileseq() {
		return profileseq;
	}
	public void setProfileseq(String profileseq) {
		this.profileseq = profileseq;
	}
	public String getResumeseq() {
		return resumeseq;
	}
	public void setResumeseq(String resumeseq) {
		this.resumeseq = resumeseq;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getIsworkseq() {
		return isworkseq;
	}
	public void setIsworkseq(String isworkseq) {
		this.isworkseq = isworkseq;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
}
