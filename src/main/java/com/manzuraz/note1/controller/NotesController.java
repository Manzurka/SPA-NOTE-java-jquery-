package com.manzuraz.note1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manzuraz.note1.service.NoteService;

@Controller
public class NotesController {
	private final NoteService ns;
	
	public NotesController(NoteService ns) {
		this.ns=ns;
	}
	
	@RequestMapping("/")
		public String home() {
			return "index.jsp";
		}
}
