package com.theater.project;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.theater.util.Pager;
import com.theater.util.RowNum;
import com.theater.drama.DramaDTO;
import com.theater.drama.DramaService;

import com.theater.util.ListData;

@Controller
@RequestMapping(value="/drama/*")
public class DramaController {
	

	@Inject
	public DramaService dramaService;
	

	//selectList
	@RequestMapping(value="dramaList")
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = null;
		mv = dramaService.selectList(listData);
		mv.setViewName("drama/dramaList");
			
		return mv;
	}
	
	/*//selectOne
	@RequestMapping(value="dramaView")
	public String selectOne(Model model, int num) throws Exception {
		
		BoardDTO boardDTO = dramaService.selectOne(num);
		
		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "notice");
			
		return "board/boardView";
	}
	
	
	//insert -> form 이동
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("board", "notice");
		
		return "board/boardWrite";
	}
	
	//insert -> DB 처리
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String insert(NoticeDTO noticeDTO, Model model, HttpSession session) throws Exception {
		int result = 0;
		result = noticeService.insert(noticeDTO, session);
		
		String message = "Fail";
		if(result > 0) {
			message = "Success";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "../notice/noticeList");
		
		return "common/message";
	}
	
	
	//update -> form 이동
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(int num, Model model) throws Exception {
		BoardDTO boardDTO = null;
		boardDTO = noticeService.selectOne(num);
		
		model.addAttribute("board", "notice");
		model.addAttribute("view", boardDTO);
		
		return "board/boardUpdate";
	}
	
	//update -> DB 처리
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO, RedirectAttributes rd) throws Exception {
		int result = 0;
		result = noticeService.update(noticeDTO);
		
		String message = "Fail";
		if(result > 0) {
			message = "Success";
		}
		
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}

	//delete
	@RequestMapping(value="noticeDelete")
	public String delete(int num, RedirectAttributes rd) throws Exception {
		int result = 0;
		result = noticeService.delete(num);
		
		String message = "fail";
		if(result > 0) {
			message = "success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	*/
}
