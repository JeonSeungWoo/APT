package org.woo.apt.advice.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.advice.domain.AdviceVO;
import org.woo.apt.util.Paging;

@Repository
public class AdviceDAOImpl implements AdviceDAO{

	@Inject
	private SqlSession session;
	
	private String name = "advice.";
	
	@Override
	public void insert(AdviceVO vo) throws Exception {
		session.insert(name+"insert",vo);
	}

	@Override
	public AdviceVO read(int lno) throws Exception {
		return session.selectOne(name+"read",lno);
	}

	@Override
	public void update(AdviceVO vo) throws Exception {
		session.update(name+"update",vo);
	}

	@Override
	public void delete(int lno) throws Exception {
		session.delete(name+"delete",lno);
	}

	@Override
	public List<AdviceVO> list(Paging paging) throws Exception {
		return session.selectList(name + "list",paging);
	}

	@Override
	public int listCount() throws Exception {
		return session.selectOne(name+"listCount");
	}

	@Override
	public void answerUpdate(AdviceVO vo) throws Exception {
		session.update(name+"answerUpdate",vo);
		
	}

	@Override
	public List<AdviceVO> homeList() throws Exception {
		return session.selectList(name + "homeList");
	}

}
