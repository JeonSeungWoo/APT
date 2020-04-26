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
import org.woo.apt.file.domain.FreeFileFilesVO;
import org.woo.apt.file.service.FreeFileFilesService;
import org.woo.apt.util.UploadFileUtils;

@RequestMapping("/freeUpload/*")
@Controller
public class FreeUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FreeUploadController.class);

	@Inject
	private FreeFileFilesService fservice;
	
	// Resource = core.io;
	//ResponseEntity 타입은 byte로 대채 가능하지만 ResponseEntity좀더 간편하다.
	@ResponseBody
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Resource> file(@RequestHeader("User-Agent")String userAgent,
			@RequestParam("ffno") int ffno, @RequestParam("filename") String filename)
			throws Exception {
		UploadFileUtils upload = new UploadFileUtils();
		FreeFileFilesVO vo = new FreeFileFilesVO();
		vo.setFfno(ffno);
		vo.setFilename(filename);
		String path = fservice.fileShow(vo).getPath();
		filename = fservice.fileShow(vo).getFilename();
		ResponseEntity<Resource> result = upload.fileShow(userAgent, path, filename);
		return result;
	}

	@RequestMapping(value = "/fileDelete")
	public String imgDelete(@RequestParam("ffno")int ffno,  @RequestParam("filename")String filename) throws Exception {
		FreeFileFilesVO vo = new FreeFileFilesVO();
		UploadFileUtils upload = new UploadFileUtils();
		vo.setFfno(ffno);
		vo.setFilename(filename);
		String location = fservice.fileShow(vo).getPath();
		upload.deleteFile(location, filename);
		fservice.fileDeleteOne(vo);
		return "redirect:/freeFile/read?ffno=" + ffno;
	}
	
	// insertImage
		@RequestMapping(value = "/insertFile" , method = RequestMethod.POST)
		public String insertImage(int ffno, @RequestParam("file")List<MultipartFile> file) throws Exception {
			FreeFileFilesVO fvo = new FreeFileFilesVO();
			fvo.setFfno(ffno);
			System.out.println(fvo);

			for (int i = 0; i < file.size(); i++) {
				String originalName = file.get(i).getOriginalFilename();
				byte[] fileData = file.get(i).getBytes();
				// 유틸시작
				String uploadedFileName = UploadFileUtils.saveFile("C:\\freeTemp", originalName, fileData);
				String path = "C:\\freeTemp" + uploadedFileName.substring(0, 12);
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
			return "redirect:/freeFile/read?page=1&ffno=" + ffno;

		}

	
}
