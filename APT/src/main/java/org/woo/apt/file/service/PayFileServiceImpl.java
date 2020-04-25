package org.woo.apt.file.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.woo.apt.file.dao.PayFileDAO;
import org.woo.apt.file.dao.PayFileFilesDAO;
import org.woo.apt.file.domain.PayFileFilesVO;
import org.woo.apt.file.domain.PayFileVO;
import org.woo.apt.util.Paging;
import org.woo.apt.util.UploadFileUtils;

@Service
public class PayFileServiceImpl implements PayFileService {

	@Inject
	private PayFileDAO dao;
	
	@Inject
	private PayFileFilesDAO fdao;
//
//	@Resource(name = "uploadPath")
//	String uploadPath;
	
	@Transactional
	@Override
	public void insert(PayFileVO vo, List<MultipartFile> file) throws Exception {
		// 이미지를 추가.

		dao.insert(vo);

		for (int i = 0; i < file.size(); i++) {
			String originalName = file.get(i).getOriginalFilename();
			byte[] fileData = file.get(i).getBytes();
			// 유틸시작
			String uploadedFileName = UploadFileUtils.saveFile("C:"+File.separator+"Temp", originalName, fileData);
			String path = "C:"+File.separator+"Temp" + uploadedFileName.substring(0, 12);
			String saveFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("/") + 1);
			String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
			//확장자 null 체크
			if (formatName == null || formatName.equals("")) {
			}else{
				PayFileFilesVO fvo = new PayFileFilesVO();
				fvo.setFilename(saveFileName);
				fvo.setPath(path);
				fdao.fileInsert(fvo);
			}
		}
	}

	@Override
	public PayFileVO read(int pfno) throws Exception {
		return dao.read(pfno);
	}

	@Override
	public void update(PayFileVO vo) throws Exception {
		dao.update(vo);
	}

	@Transactional
	@Override
	public void delete(int pfno) throws Exception {
		List<PayFileFilesVO> list = fdao.fileList(pfno);
        String location = "";
		String fileName = "";	
		UploadFileUtils util =  new UploadFileUtils();
		//for문 스타트
		for (int i = 0; i < list.size(); i++) {
		location = list.get(i).getPath();
		fileName = list.get(i).getFilename();
		util.deleteFile(location, fileName);
		}
		fdao.fileDelete(pfno);
		dao.delete(pfno);
	}

	@Override
	public List<PayFileVO> list(Paging paging) throws Exception {
		return dao.list(paging);
	}

	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}

}
