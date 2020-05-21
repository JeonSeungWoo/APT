package org.woo.apt.file.service;

import java.util.List;

import org.woo.apt.file.domain.PayFileFilesVO;

public interface PayFileFilesService {
	public void fileInsert(PayFileFilesVO vo)throws Exception;
	//�쟾泥� �씠誘몄� 蹂닿린
	public List<PayFileFilesVO> fileList(int pfno)throws Exception;
	
	public void fileDelete(int pfno)throws Exception;
	//�닔�젙 泥섎━.(�닔�젙�� �궘�젣�썑 �씤�꽕�듃)
	public void fileInsertOne(PayFileFilesVO vo)throws Exception;
	public void fileDeleteOne(PayFileFilesVO vo)throws Exception;
	//�씠誘몄�瑜� 蹂댁뿬二쇰뒗 荑쇰━
	public PayFileFilesVO fileShow(PayFileFilesVO vo)throws Exception;
}
