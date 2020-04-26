package org.woo.apt.file.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.file.domain.FreeFileFilesVO;
import org.woo.apt.file.domain.PayFileFilesVO;

@Repository
public class FreeFileFilesDAOImpl implements FreeFileFilesDAO {

	@Inject
	private SqlSession session;

	@Override
	public void fileInsert(FreeFileFilesVO vo) throws Exception {
		session.insert("freeFile.fileInsert", vo);
	}

	@Override
	public List<FreeFileFilesVO> fileList(int ffno) throws Exception {
		return session.selectList("freeFile.fileList", ffno);

	}

	@Override
	public void fileDelete(int ffno) throws Exception {
		session.delete("freeFile.fileDelete", ffno);

	}

	@Override
	public void fileInsertOne(FreeFileFilesVO vo) throws Exception {
		session.insert("freeFile.fileInsertOne", vo);

	}

	@Override
	public void fileDeleteOne(FreeFileFilesVO vo) throws Exception {
		session.delete("freeFile.fileDeleteOne", vo);

	}

	@Override
	public FreeFileFilesVO fileShow(FreeFileFilesVO vo) throws Exception {
		
		return session.selectOne("freeFile.fileShow", vo);
	}

}
