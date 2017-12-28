package com.theater.drama;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.theater.review.ReviewDTO;


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
	public int ticket_sell(int drama_num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"ticket_sell", drama_num);
	}
	public List<ReviewDTO> selectList_review(int drama_num)throws Exception{
		return sqlSession.selectList(NAMESPACE+"selectList_review", drama_num);
	}
	public ReviewDTO selectOne_review(int drama_num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne_review", drama_num);
	}
	public int totalcount(int drama_num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"totalcount", drama_num);
	}
	public int review_avg(int drama_num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"review_avg", drama_num);
	}
}
