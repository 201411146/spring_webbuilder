package com.company.people.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.company.people.memberdto.PeopleMemberDTO;
import com.company.people.noteboxdto.PeopleNoteboxDTO;
import com.company.people.noteboxservice.PeopleNoteboxService;

@Controller
public class PeopleNoteboxController {

	@Inject
	PeopleNoteboxService service;

	// 지원하기 get
	@RequestMapping(value = "/{sitename}/apply", method = RequestMethod.GET)
	public String getapply(@PathVariable("sitename") String sitename, HttpServletRequest req, Model model,
			@RequestParam("boardid") int boardid, @RequestParam("touserid") String touserid) throws Exception {

		model.addAttribute("boardid", boardid);
		model.addAttribute("touserid", touserid);
		return "people/notebox/apply";
	}

	// 지원하기 post
	@RequestMapping(value = "/{sitename}/apply", method = RequestMethod.POST)
	public String postapply(@PathVariable("sitename") String sitename, PeopleNoteboxDTO dto, MultipartFile file)
			throws Exception {

		service.apply(sitename, dto);

		return "people/notebox/applycomplete";
	}
	// 받은쪽지함
	@RequestMapping(value = "/{sitename}/notebox", method = RequestMethod.GET)
	public String receivenotebox(@PathVariable("sitename") String sitename, HttpServletRequest req, Model model) throws Exception {

		HttpSession session = req.getSession();
		PeopleMemberDTO m = (PeopleMemberDTO) session.getAttribute("peoplemember");
		List<PeopleNoteboxDTO> dto = service.receive(sitename, m.getUserid());
		
		model.addAttribute("dto", dto);
		return "people/notebox/receivenotebox";
	}

}
