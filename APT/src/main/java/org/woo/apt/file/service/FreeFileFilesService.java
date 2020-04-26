package org.woo.apt.file.service;

import java.util.List;

import org.woo.apt.file.domain.FreeFileFilesVO;

public interface FreeFileFilesService {
	public void fileInsert(FreeFileFilesVO vo)throws Exception;
	//전체 이미지 보기
	public List<FreeFileFilesVO> fileList(int ffno)throws Exception;
	
	public void fileDelete(int ffno)throws Exception;
	//수정 처리.(수정은 삭제후 인설트)
	public void fileInsertOne(FreeFileFilesVO vo)throws Exception;
	public void fileDeleteOne(FreeFileFilesVO vo)throws Exception;
	//이미지를 보여주는 쿼리
	public FreeFileFilesVO fileShow(FreeFileFilesVO vo)throws Exception;
}
