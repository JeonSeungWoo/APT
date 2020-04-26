package org.woo.apt.file.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.file.domain.FreeFileVO;
import org.woo.apt.file.domain.PayFileVO;
import org.woo.apt.util.Paging;

@Repository
public class FreeFileDAOImpl implements FreeFileDAO{

	@Inject
	private SqlSession session;
	
	private String name = "freeFile.";

	@Override
	public void insert(FreeFileVO vo) throws Exception {
		session.insert(name+"insert",vo);
	}

	@Override
	public FreeFileVO read(int ffno) throws Exception {
		return session.selectOne(name+"read",ffno);
	}

	@Override
	public void update(FreeFileVO vo) throws Exception {
		session.update(name+"update",vo);
	}

	@Override
	public void delete(int ffno) throws Exception {
		session.delete(name+"delete",ffno);
	}

	@Override
	public List<FreeFileVO> list(Paging paging) throws Exception {
		return session.selectList(name + "list",paging);
	}

	@Override
	public int listCount() throws Exception {
		return session.selectOne(name+"listCount");
	}	
	
	
}
