package com.theater.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSaver {
	
	public String fileSave(MultipartFile multipartFile, HttpSession session, String path) throws Exception{
		//1. realPath
		String filePath = session.getServletContext().getRealPath("resources/"+path);
		System.out.println(filePath);
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();  //�뤃�뜑諛묒뿉 �뤃�뜑諛묒뿉 �뤃�뜑
		}
		//2. file_name
		String file_name = multipartFile.getOriginalFilename();
		file_name = file_name.substring(file_name.lastIndexOf("."));
		file_name = UUID.randomUUID().toString()+file_name;
		
		file = new File(filePath, file_name);
		
		multipartFile.transferTo(file);
		
		return file_name;
	}

}
