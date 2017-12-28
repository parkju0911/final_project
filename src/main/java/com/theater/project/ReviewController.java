package com.theater.project;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.theater.drama.DramaviewService;
import com.theater.review.ReviewDTO;

@Controller
@RequestMapping(value="review/*")
public class ReviewController {

	@Inject
	private DramaviewService dramaviewService;
	
	
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
	
}
