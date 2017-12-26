package com.theater.drama;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
}

