package com.manzuraz.note1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manzuraz.note1.message.Response;
import com.manzuraz.note1.models.Note;
import com.manzuraz.note1.service.NoteService;

@RestController
public class NotesAPI {
	private final NoteService ns;
		
	public NotesAPI(NoteService ns) {
		this.ns=ns;
	}
	
	@RequestMapping("/notes") //display all notes
		public List<Note> index(){
			return ns.all_notes();
		}
	
	@PostMapping("/notes/create") //create a new note
		public Note create(@RequestParam("title") String title, @RequestParam("description") String desc, HttpServletResponse response) {
			Note note = new Note();
			note.setTitle(title);
			note.setDescription(desc);
			return ns.saveNote(note);
	}
	

	@PostMapping("/notes/{id}/update") //create a new note
		public void update(@RequestParam("description") String desc,@PathVariable("id") Long id, HttpServletResponse response) {
			Note note = ns.findById(id);
			note.setDescription(desc);
			ns.saveNote(note);
//			Response res= new Response("Done", note);
//			return res;
			try {
				response.sendRedirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@PostMapping("/notes/{id}/delete") 
		public void delete(@PathVariable("id") Long id, HttpServletResponse response) {
		Note note = ns.findById(id);
		ns.delete(note);
//		Response res= new Response("Done", note);
//		return res;
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
