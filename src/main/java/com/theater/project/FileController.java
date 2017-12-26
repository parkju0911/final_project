package com.theater.project;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
}
