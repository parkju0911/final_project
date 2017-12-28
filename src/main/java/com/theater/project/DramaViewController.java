package com.theater.project;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.theater.drama.DramaDTO;
import com.theater.drama.DramaListDTO;
import com.theater.drama.DramaviewService;
import com.theater.review.ReviewDTO;

@Controller
@RequestMapping(value="drama/*")
public class DramaViewController {
	
	@Inject
	private DramaviewService dramaviewService;
	
	
	@RequestMapping(value="dramaview")
	public ModelAndView selectOne(int drama_num ,  ModelAndView mv, RedirectAttributes rd)throws Exception{
		DramaDTO dramaDTO = null;
		dramaDTO = dramaviewService.selectOne(drama_num); //drama list에서 받아온 번호
		
		List<DramaListDTO> ar = dramaviewService.selectList(drama_num); //극 상영일 , 상영시간 선택
		
		int ticket = dramaviewService.ticket_sell(drama_num); //매수 구매 설정
		
		List<ReviewDTO> ar_review = dramaviewService.selectList_review(drama_num);
		
		int totalcount = dramaviewService.totalcount(drama_num); //연극 리뷰 총 인원
		
		int review_avg = dramaviewService.review_avg(drama_num);
	/*	ReviewDTO reviewDTO = dramaviewService.selectOne_review(drama_num);*/
		if(dramaDTO !=null){
			mv.addObject("view", dramaDTO); //drama 정보 (제목,설명,가격)
			mv.addObject("list", ar);   //극 상영일  선택
			mv.addObject("list2", ar); //극 상영 시간 선택
			mv.addObject("ticket", ticket); //매수 구매 설정
			mv.addObject("review", ar_review);
			mv.addObject("total", totalcount);
			mv.addObject("avg", review_avg);
			/*		mv.addObject("select_review", reviewDTO);*/
			
			mv.setViewName("drama/dramaview");
			
		}else{
			rd.addFlashAttribute("message", "관람일이 지났습니다.");
			mv.setViewName("drama/dramalist");
		}
		return mv;
	}
	@RequestMapping(value="reviewlist")
	public ModelAndView selectList(int drama_num ,ModelAndView model , RedirectAttributes rd)throws Exception{
		List<ReviewDTO> ar_review = dramaviewService.selectList_review(drama_num);
		
		int totalcount = dramaviewService.totalcount(drama_num); //연극 리뷰 총 인원
		
		int review_avg = dramaviewService.review_avg(drama_num);
		if(ar_review !=null){
			model.addObject("review", ar_review);
			model.addObject("total", totalcount);
			model.addObject("avg", review_avg);
			model.setViewName("/review/reviewlist");
			
		}else{
			rd.addFlashAttribute("message", "관람일이 지났습니다.");
			model.setViewName("drama/dramalist");
		}
		
		return model;
	}
	@RequestMapping(value="refundlist")
	public String refundlist()throws Exception{
		
		return "drama/refundlist";
	}
}

/*	@RequestMapping(value="CompanyDTO")
	public ModelAndView ticket_sell(int drama_num , ModelAndView mv , RedirectAttributes rd)throws Exception{
		CompanyDTO companyDTO = null;
		companyDTO = dramaviewService.ticket_sell(drama_num);
		
		if(companyDTO !=null){
			mv.addObject("ticket", companyDTO);
			mv.setViewName("drama/dramaview");
			
		}else{
			mv.addObject("message", "관람일이 지났습니다.");
			mv.setViewName("drama/dramalist");
		}
		
		
		return mv;

}*/