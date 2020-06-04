package org.woo.apt.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;


public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	// byte type show
//	public @ResponseBody byte[] show(String path, String fileName) throws Exception {
//		InputStream in;
//		in = new FileInputStream(path + fileName);
//		// IO �뒪�듃由� 議곗옉 �쑀�떥.(toByteArray�뒗 in�쓣 �씤肄붾뵫.)
//		byte[] result = IOUtils.toByteArray(in);
//		in.close();
//		return result;
//	}

	// ResponseEntity show 
	public ResponseEntity<Resource> fileShow(String reqHeader, String path, String fileName) throws Exception {
		Resource resource = new FileSystemResource(path + fileName);
		if (resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.OK);
		}
		String resorceName = resource.getFilename();
		String resorceOriName = resorceName.substring(resorceName.indexOf("_") + 1);
		
		HttpHeaders headers = new HttpHeaders();
		// �뿉�쇅 泥섎━
		try {
			String downloadName = null;
			//user-Agent�쓽 �젙蹂대�� �뙆�씪誘명꽣濡� 諛쏆븘 釉뚮씪�슦��蹂� 泥섎━
			if(reqHeader.contains("Trident")) {	//IE 釉뚮씪�슦�� �뿏吏� �씠由�
				
				downloadName = URLEncoder.encode(resorceOriName, "UTF-8").replaceAll("\\+", "%20");;
			}else if(reqHeader.contains("Edge")) {
			
				downloadName = URLEncoder.encode(resorceOriName, "UTF-8");
			}else{	//�겕濡�
				
				downloadName = URLEncoder.encode(resorceOriName, "UTF-8");
			}
			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

	
	
	//�뙆�씪 ���옣.
	public static String saveFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);

		// byte[] input, File output (�옄�룞 close;)
		FileCopyUtils.copy(fileData, target);
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;

		// �씠誘몄��씠硫�
		if (getMediaType(formatName) != null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			// �씠誘몄�媛� �븘�땶 �뙆�씪�씠 �뱾�뼱 �솕�쓣 �떆
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
	}

	// �뙆�씪泥섎━
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	// �뜽�꽕�씪 泥섎━
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	// �궇吏� 泥섎━
	public static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}

	// �릟�뜑 留뚮뱾湲�
	private static void makeDir(String uploadPath, String... paths) {
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

	// Img type check
	public static MediaType getMediaType(String type) {

		Map<String, MediaType> mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);

		return mediaMap.get(type.toUpperCase());
	}

	// �궘�젣 泥섎━
	public void deleteFile(String location, String fileName) {
		File file = new File(location + fileName);
		if (file.exists()) {
			if (file.delete()) {
				logger.info("�뙆�씪�궘�젣 �꽦怨�");
			} else {
				logger.info("�뙆�씠�궘�젣 �떎�뙣");
			}
		} else {
			logger.info("�뙆�씪�씠 議댁옱�븯吏� �븡�뒿�땲�떎.");
		}
	}
}
