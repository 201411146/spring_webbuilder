package com.company.people.bookmarkdao;

import java.util.List;

import com.company.people.boarddto.PeopleBoardDTO;
import com.company.people.bookmarkdto.PeopleBookmarkDTO;

public interface PeopleBookmarkDAO {
	public List<PeopleBookmarkDTO> getbookmark(final String sitename, final String userid);
	public PeopleBoardDTO list(final String sitename, final int boardid);
	public void delete(final String sitename, final int boardid);
}
