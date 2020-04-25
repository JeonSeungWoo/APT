package org.woo.apt.file.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.woo.apt.file.domain.PayFileFilesVO;
import org.woo.apt.file.service.PayFileFilesService;
import org.woo.apt.util.UploadFileUtils;

@RequestMapping("/payUpload/*")
@Controller
public class PayUploadController {

	private static final Logger logger = LoggerFactory.getLogger(PayUploadController.class);

	@Inject
	private PayFileFilesService fservice;
	
	// 대표이미지 보여주기
	@ResponseBody
	@RequestMapping(value = "/show")
	public ResponseEntity<Resource> show(
			@RequestHeader("User-Agent")String userAgent,@RequestParam("pfno") int pfno) throws Exception {
		String path = "";
		String fileName = "";
		UploadFileUtils upload = new UploadFileUtils();
		fileName = fservice.fileList(pfno).get(0).getFilename();
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("fileName : " + fileName);
		if (UploadFileUtils.getMediaType(formatName) != null) {
			path = fservice.fileList(pfno).get(0).getPath();
			fileName = fservice.fileList(pfno).get(0).getFilename();
		}else{
			path ="C:\\Temp\\";
			fileName = "a.png";
		}
		
		ResponseEntity<Resource> result = upload.fileShow(userAgent, path, fileName);
		return result;
	}

	// Resource = core.io;
	//ResponseEntity 타입은 byte로 대채 가능하지만 ResponseEntity좀더 간편하다.
	@ResponseBody
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Resource> file(@RequestHeader("User-Agent")String userAgent,
			@RequestParam("pfno") int pfno, @RequestParam("filename") String filename)
			throws Exception {
		UploadFileUtils upload = new UploadFileUtils();
		PayFileFilesVO vo = new PayFileFilesVO();
		vo.setPfno(pfno);
		vo.setFilename(filename);
//		String path = "";
		String path = fservice.fileShow(vo).getPath();
		filename = fservice.fileShow(vo).getFilename();
//		String formatName = filename.substring(filename.lastIndexOf(".") + 1);
//		System.out.println(formatName);
//		if (UploadFileUtils.getMediaType(formatName) != null) {
//			path = fservice.fileShow(vo).getPath();
//			filename = fservice.fileShow(vo).getFilename();
//		}else{
//		}
		System.out.println(filename);
		ResponseEntity<Resource> result = upload.fileShow(userAgent, path, filename);
        System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/fileDelete")
	public String imgDelete(@RequestParam("pfno")int pfno,  @RequestParam("filename")String filename) throws Exception {
		PayFileFilesVO vo = new PayFileFilesVO();
		UploadFileUtils upload = new UploadFileUtils();
		vo.setPfno(pfno);
		vo.setFilename(filename);
		String location = fservice.fileShow(vo).getPath();
		upload.deleteFile(location, filename);
		fservice.fileDeleteOne(vo);
		return "redirect:/payFile/read?pfno=" + pfno;
	}
	
	// insertImage
		@RequestMapping(value = "/insertFile")
		public String insertImage(int pfno, @RequestParam("file")List<MultipartFile> file) throws Exception {
			PayFileFilesVO fvo = new PayFileFilesVO();
			fvo.setPfno(pfno);
			System.out.println(fvo);

			for (int i = 0; i < file.size(); i++) {
				String originalName = file.get(i).getOriginalFilename();
				byte[] fileData = file.get(i).getBytes();
				// 유틸시작
				String uploadedFileName = UploadFileUtils.saveFile("C:\\Temp", originalName, fileData);
				String path = "C:\\Temp" + uploadedFileName.substring(0, 12);
				String saveFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("/") + 1);
				String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
				//확장자 null 체크
				System.out.println(formatName);
				if (formatName == null || formatName.equals("")) {
				}else{
				fvo.setFilename(saveFileName);
					fvo.setPath(path);
					fservice.fileInsertOne(fvo);
				}
			}
			return "redirect:/payFile/read?page=1&pfno=" + pfno;

		}

	
}
