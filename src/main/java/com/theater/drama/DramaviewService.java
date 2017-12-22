package com.theater.drama;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.theater.member.CompanyDTO;

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
	public CompanyDTO ticket_sell(int company_num)throws Exception{
		
		CompanyDTO companyDTO = dramaDAO.ticket_sell(company_num);
		
		return companyDTO;
	}
}

