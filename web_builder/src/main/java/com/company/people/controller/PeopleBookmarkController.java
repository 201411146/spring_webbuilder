package com.company.people.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.people.boarddto.PeopleBoardDTO;
import com.company.people.bookmarkdto.PeopleBookmarkDTO;
import com.company.people.bookmarkservice.PeoplBookmarkService;
import com.company.people.memberdto.PeopleMemberDTO;

@Controller
public class PeopleBookmarkController {
	@Inject
	PeoplBookmarkService service;
	
	// 즐겨찾기 목록
		@RequestMapping(value = "/{sitename}/bookmark", method = RequestMethod.GET)
		public String list(@PathVariable("sitename") String sitename, Model model, HttpServletRequest req) throws Exception {
			HttpSession session = req.getSession();
			PeopleMemberDTO m = (PeopleMemberDTO) session.getAttribute("peoplemember");
			
			List<PeopleBookmarkDTO> bookmarkdto = service.getbookmark(sitename,m.getUserid());
			List<PeopleBoardDTO> dto = new ArrayList();
			for(PeopleBookmarkDTO i: bookmarkdto) {
				dto.add(service.list(sitename, i.getBoardid()));
			}
			model.addAttribute("bookmarkdto", bookmarkdto);
			model.addAttribute("sitename", sitename);
			model.addAttribute("dtos", dto);

			return "people/bookmark/list";
		}
		
	// 즐겨찾기 삭제
		@RequestMapping(value = "/{sitename}/deletebookmark", method = RequestMethod.GET)
		public String getDelete(@PathVariable("sitename") String sitename, @RequestParam("boardid") int boardid ) throws Exception {

			service.delete(sitename, boardid);

			return "redirect:/{sitename}/bookmark";
		}
}
