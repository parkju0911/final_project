package com.theater.project;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< HEAD
=======
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
>>>>>>> notice

import com.theater.file.FileDTO;
import com.theater.file.PhotoDTO;
import com.theater.file.PhotoService;

@Controller
@RequestMapping(value="/file/*")
public class FileController {
<<<<<<< HEAD

	@Inject
	private PhotoService photoService;
	
	//smartEdiotr image upload
=======
	
	@Inject
	private PhotoService photoService;

	//smartEditor image upload
>>>>>>> notice
	@RequestMapping(value="photoUpload")
	public String photoUpload(PhotoDTO photoDTO, HttpSession session){
		return photoService.photoUpload(photoDTO, session);
	}
	
<<<<<<< HEAD
	@RequestMapping(value="fileDown")
	public ModelAndView fileDown(FileDTO fileDTO, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		//저장될 실제 파일 이름
		File file = new File(filePath, fileDTO.getFileName());
		ModelAndView mv = new ModelAndView();
		mv.addObject("down", file);
		mv.addObject("oriname", fileDTO.getFileName());
		//viewName은 
		mv.setViewName("filedown");
		
		return mv;
	}
	
=======
	//delete
	/*	@RequestMapping(value="fileDelete")
		public String delete(int num, RedirectAttributes rd) throws Exception{
			int result=0;
			result = noticeService.delete(num);
			String message="FAIL";
			if(result>0){
				message="SUCCESS";
			}
			rd.addFlashAttribute("message", message);
			return "redirect:./noticeList";
		}
*/

	@RequestMapping(value="fileDown")
	public ModelAndView fileDown(FileDTO fileDTO, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		//???��?�� ?��?�� ?��?�� ?���?
		File file = new File(filePath, fileDTO.getFile_name());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("down", file);
		modelAndView.addObject("file_route", fileDTO.getFile_route());
		//viewName?? 
		modelAndView.setViewName("filedown");
		return modelAndView;
	}
>>>>>>> notice
}
