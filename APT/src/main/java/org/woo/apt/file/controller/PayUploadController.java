package org.woo.apt.file.controller;

import java.io.File;
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
	
	@ResponseBody
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Resource> file(@RequestHeader("User-Agent")String userAgent,
			@RequestParam("pfno") int pfno)
			throws Exception {
		UploadFileUtils upload = new UploadFileUtils();
		PayFileFilesVO vo = new PayFileFilesVO();
		vo.setPfno(pfno);
		String path = fservice.fileList(pfno).get(0).getPath();
		String filename = fservice.fileList(pfno).get(0).getFilename();
		ResponseEntity<Resource> result = upload.fileShow(userAgent, path, filename);
		return result;
	}

	@RequestMapping(value = "/fileDelete")
	public String imgDelete(int page,@RequestParam("pfno")int pfno,  @RequestParam("filename")String filename) throws Exception {
		PayFileFilesVO vo = new PayFileFilesVO();
		UploadFileUtils upload = new UploadFileUtils();
		vo.setPfno(pfno);
		vo.setFilename(filename);
		String location = fservice.fileShow(vo).getPath();
		upload.deleteFile(location, filename);
		fservice.fileDeleteOne(vo);
		return "redirect:/payFile/updatePage?page="+page+"&pfno=" + pfno;
	}
	
	// insertImage
		@RequestMapping(value = "/insertFile", method = RequestMethod.POST)
		public String insertImage(int page,int pfno, @RequestParam("file")List<MultipartFile> file) throws Exception {
			PayFileFilesVO fvo = new PayFileFilesVO();
			
			fvo.setPfno(pfno);
			System.out.println(fvo);

			for (int i = 0; i < file.size(); i++) {
				String originalName = file.get(i).getOriginalFilename();
				byte[] fileData = file.get(i).getBytes();
				String uploadedFileName = UploadFileUtils.saveFile("C:\\payTemp", originalName, fileData);
				String path = "C:\\payTemp" + uploadedFileName.substring(0, 12);
				String saveFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("/") + 1);
				String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
				//�솗�옣�옄 null 泥댄겕
				System.out.println(formatName);
				if (formatName == null || formatName.equals("")) {
				}else{
				fvo.setFilename(saveFileName);
					fvo.setPath(path);
					fservice.fileInsertOne(fvo);
				}
			}
			return "redirect:/payFile/updatePage?page="+page+"&pfno=" + pfno;

		}

	
}
