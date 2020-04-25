package org.woo.apt.file.domain;

public class PayFileFilesVO {
	private int pffno;
	private int pfno;
	private String path;
	private String filename;
	private String regdate;
	private String updatedate;
	public int getPffno() {
		return pffno;
	}
	public void setPffno(int pffno) {
		this.pffno = pffno;
	}
	public int getPfno() {
		return pfno;
	}
	public void setPfno(int pfno) {
		this.pfno = pfno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
		return "PayFileFilesVO [pffno=" + pffno + ", pfno=" + pfno + ", path=" + path + ", filename=" + filename
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}

	
}
