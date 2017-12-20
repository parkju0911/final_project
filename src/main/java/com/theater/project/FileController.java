package com.theater.project;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theater.file.FileDTO;
import com.theater.file.PhotoDTO;
import com.theater.file.PhotoService;

@Controller
@RequestMapping(value="/file/*")
public class FileController {
	
	@Inject
	private PhotoService photoService;

	//smartEditor image upload
	@RequestMapping(value="photoUpload")
	public String photoUpload(PhotoDTO photoDTO, HttpSession session){
		return photoService.photoUpload(photoDTO, session);
	}

	@RequestMapping(value="fileDown")
	public ModelAndView fileDown(FileDTO fileDTO, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		//저장될 실제 파일 이름
		File file = new File(filePath, fileDTO.getFileName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("down", file);
		modelAndView.addObject("oriName", fileDTO.getOriName());
		//viewName은 
		modelAndView.setViewName("filedown");
		return modelAndView;
	}
}
