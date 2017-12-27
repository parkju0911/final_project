package com.theater.drama;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> drama

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD

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
=======
import com.theater.util.RowNum;

@Repository
public class DramaDAO  {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="dramaMapper.";


	public List<DramaDTO> selectList(RowNum rowNum) throws Exception {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("startRow", rowNum.getStartRow());
		map.put("lastRow", rowNum.getLastRow());
		map.put("kind", rowNum.getKind());
		map.put("search", rowNum.getSearch());
		
		return sqlSession.selectList(namespace+ "selectList", map);
	}
	
	public int totalCount(RowNum rowNum) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", "title");
		map.put("search", "%title%");
		
		return sqlSession.selectOne(namespace+"totalCount", map);
	}

	/*@Override
	public BoardDTO selectOne(int num) throws Exception {
		return sqlSession.selectOne(namespace+"selectOne", num); // 파라미터 갯수는 한개!
	}
	*/


	
	
	
	public int insert(DramaDTO dramaDTO) throws Exception {
		System.out.println("Before: "+dramaDTO.getDrama_num());
		int result = sqlSession.insert(namespace+"insert", dramaDTO);
		System.out.println("After: "+dramaDTO.getDrama_num());
		return result;
	}

	/*@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace+ "update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return sqlSession.delete(namespace+ "delete", num);
	}

	

	@Override
	public int hitUpdate(int num) throws Exception {
		return sqlSession.update(namespace+"hitUpdate", num);
	}

	@Override
	public int getNum() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}*/

>>>>>>> drama
}
