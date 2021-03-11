package com.yaneodo.member.resume;

/**
 * 이력서 상세보기에서 사용하는 뷰를 담기위함 profile + customer 정보
 * @author YSPark
 *
 */
public class ResumeDetailDTO {

	private String profileseq;
	private String resumeseq;
	private String jobtype; // subquery로 직무 type
	private String isworkseq;
	private String school;
	private String major;
	private String company;
	private String career;
	private String introduction;
	
	private String name;
	private String email;
	private String phone;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
