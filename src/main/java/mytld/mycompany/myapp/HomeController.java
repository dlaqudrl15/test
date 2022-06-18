package mytld.mycompany.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import kr.co.dw.utils.DWUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private String uploadPath = "C:"+File.separator+"upload";

	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String uploadedFilename) {
		ResponseEntity<String> entity = null;
		
		try {
			DWUtils.deleteFile(uploadPath, uploadedFilename);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/displayfile" , method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename) {
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			in = new FileInputStream(new File(uploadPath, filename));
			
			MediaType mType = DWUtils.getMediaType(filename);
			
			HttpHeaders headers = new HttpHeaders();
			
			if(mType != null) {//파일업로드하고 이미지파일의 썸네일을 보여줄 때
				               // jsp파일에서 이미지 파일의 썸네일을 클릭했을 때 원본파일 보여줄 때
				headers.setContentType(mType);
			}else {
				// 파일을 다운로드하게 하는 마임타입
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				// 오리지널 네임을 추출하게 위해 오리지널 네임의 첫 글자 인덱스 획득
				int idx = filename.indexOf("_") + 1;
				//오리지널 네임 추출
				String oriName = filename.substring(idx);
				// 브라우저에서 파일명이 깨지지 않게 하기 위해서 브라우저에서 요구한 인코딩으로 변경
				oriName = new String(oriName.getBytes("UTF-8"),"ISO-8859-1");
				//헤더에 새로운 이름으로 파일명 지정
				// \"는 문자열 안에 "(큰 따옴표)를 넣기 위해서 \를 추가했음.
				// 큰따옴표는 이스케이프문자라 문자열에 표기할 때 단독으로 표기 불가능함.
				headers.add("Content-Disposition", "attachment;filename=\""+oriName+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return entity;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "redirect:/item/main";
	}
	
}
