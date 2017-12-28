package com.theater.drama;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.theater.review.ReviewDTO;

@Service
public class DramaviewService {

	
	@Inject
	DramaDAO dramaDAO;
	
	public DramaDTO selectOne(int drama_num)throws Exception{
		
		DramaDTO dramaDTO = dramaDAO.selectOne(drama_num);
		
		return dramaDTO;
		
	}
	public List<DramaListDTO> selectList(int drama_num)throws Exception{
		
		List<DramaListDTO> ar = dramaDAO.selectList(drama_num);
		
		return ar;
	}
	public int ticket_sell(int drama_num)throws Exception{
		
		int ticket = dramaDAO.ticket_sell(drama_num);
		
		return ticket;
	}
	public List<ReviewDTO> selectList_review(int drama_num)throws Exception{
		List<ReviewDTO> ar_review = dramaDAO.selectList_review(drama_num);
		
		return ar_review;
	}
	public ReviewDTO selectOne_review(int drama_num)throws Exception{
		ReviewDTO reviewDTO = dramaDAO.selectOne_review(drama_num);
		return reviewDTO;
	}
	public int totalcount(int drama_num)throws Exception{
		int totalcount = dramaDAO.totalcount(drama_num);
		return totalcount;
	}
	public int review_avg(int drama_num)throws Exception{
		int totalstar = dramaDAO.review_avg(drama_num);
		return totalstar;
	}
}

