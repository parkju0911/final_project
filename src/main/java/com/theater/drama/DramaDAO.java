package com.theater.drama;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.theater.member.CompanyDTO;


@Repository
public class DramaDAO {

	
	@Inject
	private SqlSession sqlSession;
	private  static final String NAMESPACE = "dramaviewMapper.";
	
	public DramaDTO selectOne(int drama_num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne" , drama_num);
		
	}
	public List<DramaListDTO> selectList(int drama_num)throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"selectList", drama_num);
	}
	public CompanyDTO ticket_sell(int company_num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"ticket_sell", company_num);
	}
}
