package org.woo.apt.file.domain;

public class PayFileVO {
 private int pfno;
 private String title;
 private String content;
 private int pay;
 private String userid;
 private String regdate;
 private String updatedate;
public int getPfno() {
	return pfno;
}
public void setPfno(int pfno) {
	this.pfno = pfno;
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
public int getPay() {
	return pay;
}
public void setPay(int pay) {
	this.pay = pay;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
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
	return "PayFileVO [pfno=" + pfno + ", title=" + title + ", content=" + content + ", pay=" + pay + ", userid="
			+ userid + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
}

 
 
}
