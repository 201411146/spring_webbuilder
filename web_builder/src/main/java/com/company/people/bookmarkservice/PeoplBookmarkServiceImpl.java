package com.company.people.bookmarkservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.people.boarddto.PeopleBoardDTO;
import com.company.people.bookmarkdao.PeopleBookmarkDAO;
import com.company.people.bookmarkdto.PeopleBookmarkDTO;

@Service
public class PeoplBookmarkServiceImpl implements PeoplBookmarkService {
	@Inject
	private PeopleBookmarkDAO dao;

	//즐겨찾기 정보 가져오기
	@Override
	public List<PeopleBookmarkDTO> getbookmark(String sitename, String userid) {
		// TODO Auto-generated method stub
		 return dao.getbookmark(sitename, userid);
	}

	// 즐겨찾기 게시물 가져오기
	@Override
	public PeopleBoardDTO list(String sitename, int boardid) {
		// TODO Auto-generated method stub
		return dao.list(sitename, boardid);
	}

	//즐겨찾기 삭제
	@Override
	public void delete(String sitename, int boardid) {
		// TODO Auto-generated method stub
		dao.delete(sitename, boardid);
	}
}
