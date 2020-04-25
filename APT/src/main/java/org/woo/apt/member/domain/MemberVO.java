package org.woo.apt.member.domain;

public class MemberVO {
	private int mno = 0;
	private String userid = "";
	private String pw  = "";
	private String name  = "";
	private String email  = "";
	private int phone  = 0;
	private Integer auth = 0;
	private String sessionkey = "";
	private String sessionLimit = "";
	private String interlock_type = "";
	private String regdate = "";
	private String updatedate = "";

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Integer getAuth() {
		return auth;
	}

	public void setAuth(Integer auth) {
		this.auth = auth;
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
		return "MemberVO [mno=" + mno + ", userid=" + userid + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", auth=" + auth + ", sessionkey=" + sessionkey + ", sessionLimit="
				+ sessionLimit + ", interlock_type=" + interlock_type + ", regdate=" + regdate + ", updatedate="
				+ updatedate + "]";
	}

}
