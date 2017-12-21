package com.theater.drama;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.theater.file.FileDTO;
import com.theater.notice.NoticeDTO;
import com.theater.util.FileSaver;
import com.theater.util.ListData;
import com.theater.util.Pager;
import com.theater.util.RowNum;

@Service 
//@Transactional
public class DramaService {

	@Inject
	private DramaDAO dramaDAO;
	/*@Inject
	private FileSaver fileSaver;*/
/*	@Inject
	private FileDAO fileDAO;*/
	
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(dramaDAO.totalCount(rowNum));
		List<DramaDTO> ar = dramaDAO.selectList(rowNum);
		
		mv.addObject("list", ar).addObject("pager", pager).addObject("board", "drama");
		
		return mv;
	}

/*	@Override
	public BoardDTO selectOne(int num) throws Exception {
		noticeDAO.hitUpdate(num);
		BoardDTO boardDTO = noticeDAO.selectOne(num);
		//((NoticeDTO)boardDTO).setFileNames(fileDAO.selectList(num));
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		int result = noticeDAO.insert(boardDTO);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", 462);
		map.put("title", boardDTO.getTitle());
		map.put("contents", boardDTO.getContents());
		
		result = noticeDAO.insertMemo(map);
		
		MultipartFile[] files = ((NoticeDTO)boardDTO).getFiles();
		
		System.out.println("NUM: "+ boardDTO.getNum());
		
		//저장 1. 저장경로 - realpath
		//List<FileDTO> names = new ArrayList<FileDTO>();
		for (MultipartFile multipartFile : files) {
			String name = fileSaver.fileSave(multipartFile, session, "upload");
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum()); // 먼저 noticeDAO.insert(boardDTO); 했긴 때문에 가능
			fileDTO.setFilename(name);
			fileDTO.setOriname(multipartFile.getOriginalFilename());
			//names.add(fileDTO);
			fileDAO.insert(fileDTO);
		}
		//((NoticeDTO)boardDTO).setFileNames(names);
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return noticeDAO.delete(num);
	}
*/
}
