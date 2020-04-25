package org.woo.apt.file.dao;

import java.util.List;

import org.woo.apt.file.domain.PayFileFilesVO;

public interface PayFileFilesDAO {
	public void fileInsert(PayFileFilesVO vo)throws Exception;
	//전체 이미지 보기
	public List<PayFileFilesVO> fileList(int pfno)throws Exception;
	
	public void fileDelete(int pfno)throws Exception;
	//수정 처리.(수정은 삭제후 인설트)
	public void fileInsertOne(PayFileFilesVO vo)throws Exception;
	public void fileDeleteOne(PayFileFilesVO vo)throws Exception;
	//이미지를 보여주는 쿼리
	public PayFileFilesVO fileShow(PayFileFilesVO vo)throws Exception;
}
