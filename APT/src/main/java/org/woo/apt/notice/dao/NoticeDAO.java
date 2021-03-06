package org.woo.apt.notice.dao;

import java.util.List;

import org.woo.apt.notice.domain.NoticeVO;
import org.woo.apt.util.Paging;

public interface NoticeDAO {
	public void insert(NoticeVO vo) throws Exception;
	public NoticeVO read(int nno) throws Exception;
	public void update(NoticeVO vo) throws Exception;
	public void delete(int nno) throws Exception;
	public List<NoticeVO>list(Paging paging)throws Exception;
	public int listCount()throws Exception;
	public List<NoticeVO>homeList()throws Exception;
}
