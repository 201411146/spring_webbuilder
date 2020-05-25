package com.company.people.noteboxservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.people.noteboxdao.PeopleNoteboxDAO;
import com.company.people.noteboxdto.PeopleNoteboxDTO;

@Service
public class PeopleNoteboxServiceImpl implements PeopleNoteboxService {

	@Inject
	PeopleNoteboxDAO dao;

	// 지원하기
	@Override
	public void apply(String sitename, PeopleNoteboxDTO dto) {
		// TODO Auto-generated method stub
		
		dao.apply(sitename, dto);
	}

	//받은쪽지함
	@Override
	public List<PeopleNoteboxDTO> receive(String sitename, String userid) {
		// TODO Auto-generated method stub
		return dao.receive(sitename, userid);
	}
}
