package com.theater.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.theater.util.FileSaver;

@Service
public class PhotoService {
	
<<<<<<< HEAD
	public String photoUpload(PhotoDTO photoDTO, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		//filePath=filePath+"resources/upload";
=======
	//smartEditor image upload
	public String photoUpload(PhotoDTO photoDTO, HttpSession session){
		//service?��기는 코드
		String filePath = session.getServletContext().getRealPath("/");
		filePath = filePath + "resources" + File.separator + "upload";
>>>>>>> notice
		File file = new File(filePath);
		System.out.println(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		FileSaver fs = new FileSaver();
<<<<<<< HEAD
		String fileName="";
		//String result="";
		StringBuffer stringBuffer = new StringBuffer();
		try {
			fileName=fs.fileSave(photoDTO.getFiledata(), session, "upload");
			//result="&bNewLine=true&sFileName="+photoDTO.getFiledata().getOriginalFilename()+"&sFileURL="+session.getServletContext().getContextPath()+File.separator+"upload"+File.separator+fileName;
=======
		String fileName = "";
		//String result="";
		StringBuffer stringBuffer = new StringBuffer();
		try {
			fileName = fs.fileSave(photoDTO.getFiledata(), session, "upload");
			//result = "&bNewLine=true&sFileName="+photoDTO.getFiledata().getOriginalFilename()+"&sFileURL="+session.getServletContext().getContextPath()+File.separator+"upload"+File.separator;
>>>>>>> notice
			stringBuffer.append("&bNewLine=true&sFileName=");
			stringBuffer.append(photoDTO.getFiledata().getOriginalFilename());
			stringBuffer.append("&sFileURL=");
			stringBuffer.append(session.getServletContext().getContextPath());
			stringBuffer.append("/resources/");
			stringBuffer.append("upload");
			stringBuffer.append("/");
			stringBuffer.append(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
<<<<<<< HEAD
			
		}
		
		System.out.println(photoDTO.getCallback()+photoDTO.getCallback_func()+stringBuffer.toString());
		return "redirect:"+photoDTO.getCallback()+photoDTO.getCallback_func()+stringBuffer.toString();
	}

=======
			e.printStackTrace();
		}
		System.out.println(photoDTO.getCallback()+photoDTO.getCallback_func()+stringBuffer.toString());
		return "redirect:"+photoDTO.getCallback()+photoDTO.getCallback_func()+stringBuffer.toString();
	}
>>>>>>> notice
}
