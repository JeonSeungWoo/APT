package org.woo.apt.file.domain;

public class PaymentVO {
	private int pno;
	private int pfno;
	private int mno;
	private int price;
	private int regdate;

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getPfno() {
		return pfno;
	}

	public void setPfno(int pfno) {
		this.pfno = pfno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRegdate() {
		return regdate;
	}

	public void setRegdate(int regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "PaymentVO [pno=" + pno + ", pfno=" + pfno + ", mno=" + mno + ", price=" + price + ", regdate=" + regdate
				+ "]";
	}

}
