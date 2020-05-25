package com.company.people.noteboxservice;

import java.util.List;

import com.company.people.noteboxdto.PeopleNoteboxDTO;

public interface PeopleNoteboxService {

	public void apply(final String sitename, final PeopleNoteboxDTO dto);
	public List<PeopleNoteboxDTO> receive(final String sitename, final String userid);
}
