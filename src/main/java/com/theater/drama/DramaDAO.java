package com.theater.drama;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

	public int insertMemo(Map<String, Object> map) throws Exception {
		return sqlSession.insert(namespace+"memoInsert", map);
	}
	
	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		System.out.println("Before: "+boardDTO.getNum());
		int result = sqlSession.insert(namespace+"insert", boardDTO);
		System.out.println("After: "+boardDTO.getNum());
		return result;
	}

	@Override
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
	}
*/
}
