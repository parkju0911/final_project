package com.theater.project;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.theater.drama.DramaDTO;
import com.theater.drama.DramaListDTO;
import com.theater.drama.DramaviewService;
import com.theater.member.CompanyDTO;

@Controller
@RequestMapping(value="drama/*")
public class DramaViewController {
	
	@Inject
	private DramaviewService dramaviewService;
	
	
	@RequestMapping(value="dramaview")
	public ModelAndView selectOne(int drama_num ,ModelAndView mv, RedirectAttributes rd)throws Exception{
		DramaDTO dramaDTO = null;
		dramaDTO = dramaviewService.selectOne(drama_num);
		
		if(dramaDTO !=null){
			mv.addObject("view", dramaDTO);
			mv.setViewName("drama/dramaview");
			
		}else{
			rd.addFlashAttribute("message", "관람일이 지났습니다.");
			mv.setViewName("drama/dramalist");
		}
		return mv;
	}
	@RequestMapping(value="DramaListDTO")
	public ModelAndView selectList(int drama_num ,ModelAndView model , RedirectAttributes rd)throws Exception{
		List<DramaListDTO> ar = dramaviewService.selectList(drama_num);
		
		if(ar !=null){
			model.addObject("list", ar);
			model.setViewName("drama/dramaview");
			
		}else{
			rd.addFlashAttribute("message", "관람일이 지났습니다.");
			model.setViewName("drama/dramalist");
		}
		
		return model;
		
	}
	@RequestMapping(value="CompanyDTO")
	public ModelAndView ticket_sell(int company_num , ModelAndView mv , RedirectAttributes rd)throws Exception{
		CompanyDTO companyDTO = null;
		companyDTO = dramaviewService.ticket_sell(company_num);
		
		if(companyDTO !=null){
			mv.addObject("tickey", companyDTO);
			mv.setViewName("drama/dramaview");
			
		}else{
			mv.addObject("message", "관람일이 지났습니다.");
			mv.setViewName("drama/dramalist");
		}
		
		
		return mv;
	}
}
