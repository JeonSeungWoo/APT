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
	//ResponseEntity ���엯�� byte濡� ��梨� 媛��뒫�븯吏�留� ResponseEntity醫��뜑 媛꾪렪�븯�떎.
	@ResponseBody
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Resource> file(@RequestHeader("User-Agent")String userAgent,
			@RequestParam("ffno") int ffno)
			throws Exception {
		UploadFileUtils upload = new UploadFileUtils();
		FreeFileFilesVO vo = new FreeFileFilesVO();
		
		vo.setFfno(ffno);
		String path = fservice.fileList(ffno).get(0).getPath();
		String filename = fservice.fileList(ffno).get(0).getFilename();
		ResponseEntity<Resource> result = upload.fileShow(userAgent, path, filename);
		return result;
	}

	@RequestMapping(value = "/fileDelete")
	public String imgDelete(int page,@RequestParam("ffno")int ffno,  @RequestParam("filename")String filename) throws Exception {
		FreeFileFilesVO vo = new FreeFileFilesVO();
		UploadFileUtils upload = new UploadFileUtils();
		vo.setFfno(ffno);
		vo.setFilename(filename);
		String location = fservice.fileShow(vo).getPath();
		upload.deleteFile(location, filename);
		fservice.fileDeleteOne(vo);
		return "redirect:/freeFile/updatePage?page="+page+"&ffno=" + ffno;
	}
	
	// insertImage
		@RequestMapping(value = "/insertFile" , method = RequestMethod.POST)
		public String insertImage(int page,int ffno, @RequestParam("file")List<MultipartFile> file) throws Exception {
			FreeFileFilesVO fvo = new FreeFileFilesVO();
			fvo.setFfno(ffno);

			for (int i = 0; i < file.size(); i++) {
				String originalName = file.get(i).getOriginalFilename();
				byte[] fileData = file.get(i).getBytes();
				String uploadedFileName = UploadFileUtils.saveFile("D:\\freeTemp", originalName, fileData);
				String path = "D:\\freeTemp" + uploadedFileName.substring(0, 12);
				String saveFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("/") + 1);
				String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
				if (formatName == null || formatName.equals("")) {
				}else{
				fvo.setFilename(saveFileName);
					fvo.setPath(path);
					fservice.fileInsertOne(fvo);
				}
			}
			return "redirect:/freeFile/updatePage?page="+page+"&ffno=" + ffno;

		}

	
}
