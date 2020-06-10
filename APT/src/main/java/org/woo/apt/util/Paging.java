package org.woo.apt.util;

public class Paging {
	private boolean prev; // �씠�쟾
	private boolean next; // �떎�쓬
	private int startPage; // �떆�옉 �럹�씠吏�
	private int endPage; // �걹 �럹�씠吏�
	private int totalPage; // �쟾泥� �럹�씠吏�
	private int page; // �럹�씠吏� 踰덊샇
	private int pageSize = 10; // �럹�씠吏� �겕湲�

	// 寃��깋湲곕뒫�쓣 �궗�슜�븷 �븣留�.
	private String keyword =""; // �궎�썙�뱶

	public Paging() {

	}

	// �럹�씠吏��� �쟾泥� �럹�씠吏�瑜� 媛��졇�삩�떎.
	public Paging(int page, int totalPage) {
		this.totalPage = totalPage;
		this.page = page;
		calcPage();
	}

	// �럹�씠吏� 泥섎━.
	private void calcPage() {
		// �럹�씠吏�媛� 留뚯빟 0蹂대떎 �옉�쓣�븣 �럹�씠吏��뒗 臾댁“嫄� 1�럹�씠吏��떎.
//		if (page <= 0) {
//			page = 1;
//		}
//		page = ( page - 1 ) * pageSize;

		int tempEnd = (int) (Math.ceil(page / 10.0) * 10);
		// �떆�옉�럹�씠吏�
		startPage = tempEnd - 9;

		prev = startPage == 1 ? false : true;
		if (tempEnd * pageSize >= totalPage) {
			endPage = (int) (Math.ceil(totalPage / pageSize) + 1);
			next = false;
		} else {
			endPage = tempEnd;
			next = true;
		}
	}

	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Paging [prev=" + prev + ", next=" + next + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", page=" + page + ", pageSize=" + pageSize + ", keyword=" + keyword
				+ "]";
	}


}
