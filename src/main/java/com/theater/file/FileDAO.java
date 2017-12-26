package com.theater.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.theater.notice.NoticeDTO;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NAMESPACE="fileMapper.";
	
	public List<FileDTO> selectList(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE+"selectList", num);
	}
	
	public FileDTO insert(FileDTO fileDTO) throws Exception {
		sqlSession.insert(NAMESPACE+"insert", fileDTO);
		return fileDTO;
	}
	/*public int insert(FileDTO fileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"insert", fileDTO);
	}*/
}
