package org.woo.apt.notice.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.notice.domain.NoticeVO;
import org.woo.apt.util.Paging;

@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Inject
	private SqlSession session;
	
	private String name = "notice.";
	
	@Override
	public void insert(NoticeVO vo) throws Exception {
		session.insert(name+"insert",vo);
	}

	@Override
	public NoticeVO read(int nno) throws Exception {
		return session.selectOne(name+"read",nno);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		session.update(name+"update",vo);
	}

	@Override
	public void delete(int nno) throws Exception {
		session.delete(name+"delete",nno);
	}

	@Override
	public List<NoticeVO> list(Paging paging) throws Exception {
		return session.selectList(name + "list",paging);
	}

	@Override
	public int listCount() throws Exception {
		return session.selectOne(name+"listCount");
	}


}
