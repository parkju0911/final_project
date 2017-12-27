package com.theater.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD

=======
>>>>>>> notice
import com.theater.notice.NoticeDTO;

@Repository
public class FileDAO {
<<<<<<< HEAD

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="fileMapper.";
	
	public NoticeDTO test3() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"selectTest3");
	}
	
	
	
	public FileDTO test() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"selectTest", 1);
	}
	
	public int insert(FileDTO fileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"insert", fileDTO);
	}
	
	public List<FileDTO> selectList(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE+"selectList", num);
	}
=======
	
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
>>>>>>> notice
}
