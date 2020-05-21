package org.woo.apt.member.domain;

public class MemberVO {
	private String userid = "";
	private String pw  = "";
	private String name  = "";
	private String phone = "";
	
	private Integer auth = 0;
	
	private String apartment = "";
	private String roadnameCode = "";
	private String address = "";
	private String address_detail = "";

	private String sessionkey = "";
	private String sessionLimit = "";
	private String interlock_type = "";
	private String regdate = "";
	private String updatedate = "";
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAuth() {
		return auth;
	}
	public void setAuth(Integer auth) {
		this.auth = auth;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getRoadnameCode() {
		return roadnameCode;
	}
	public void setRoadnameCode(String roadnameCode) {
		this.roadnameCode = roadnameCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public String getSessionkey() {
		return sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}
	public String getSessionLimit() {
		return sessionLimit;
	}
	public void setSessionLimit(String sessionLimit) {
		this.sessionLimit = sessionLimit;
	}
	public String getInterlock_type() {
		return interlock_type;
	}
	public void setInterlock_type(String interlock_type) {
		this.interlock_type = interlock_type;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", auth=" + auth
				+ ", apartment=" + apartment + ", roadnameCode=" + roadnameCode + ", address=" + address
				+ ", address_detail=" + address_detail + ", sessionkey=" + sessionkey + ", sessionLimit=" + sessionLimit
				+ ", interlock_type=" + interlock_type + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	


	
}
