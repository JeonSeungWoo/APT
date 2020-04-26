package org.woo.apt.file.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.woo.apt.file.dao.FreeFileDAO;
import org.woo.apt.file.dao.FreeFileFilesDAO;
import org.woo.apt.file.domain.FreeFileFilesVO;
import org.woo.apt.file.domain.FreeFileVO;
import org.woo.apt.util.Paging;
import org.woo.apt.util.UploadFileUtils;

@Service
public class FreeFileServiceImpl implements FreeFileService {

	@Inject
	private FreeFileDAO dao;
	
	@Inject
	private FreeFileFilesDAO fdao;

	@Transactional
	@Override
	public void insert(FreeFileVO vo, List<MultipartFile> file) throws Exception {

		dao.insert(vo);

		for (int i = 0; i < file.size(); i++) {
			String originalName = file.get(i).getOriginalFilename();
			byte[] fileData = file.get(i).getBytes();
			// 유틸시작
			String uploadedFileName = UploadFileUtils.saveFile("C:"+File.separator+"freeTemp", originalName, fileData);
			String path = "C:"+File.separator+"freeTemp" + uploadedFileName.substring(0, 12);
			String saveFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("/") + 1);
			String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
			//확장자 null 체크
			if (formatName == null || formatName.equals("")) {
			}else{
				FreeFileFilesVO fvo = new FreeFileFilesVO();
				fvo.setFilename(saveFileName);
				fvo.setPath(path);
				fdao.fileInsert(fvo);
			}
		}
		
	}

	@Override
	public FreeFileVO read(int ffno) throws Exception {
		return dao.read(ffno);
	}

	@Override
	public void update(FreeFileVO vo) throws Exception {
		dao.update(vo);
	}

	@Transactional
	@Override
	public void delete(int ffno) throws Exception {
		List<FreeFileFilesVO> list = fdao.fileList(ffno);
        String location = "";
		String fileName = "";	
		UploadFileUtils util =  new UploadFileUtils();
		//for문 스타트
		for (int i = 0; i < list.size(); i++) {
		location = list.get(i).getPath();
		fileName = list.get(i).getFilename();
		util.deleteFile(location, fileName);
		}
		fdao.fileDelete(ffno);
		dao.delete(ffno);
		
	}

	@Override
	public List<FreeFileVO> list(Paging paging) throws Exception {
		return dao.list(paging);
	}

	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}
	

}
