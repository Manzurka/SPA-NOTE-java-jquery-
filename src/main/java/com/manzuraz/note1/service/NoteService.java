package com.manzuraz.note1.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.manzuraz.note1.models.Note;
import com.manzuraz.note1.repo.NoteRepo;

@Service
public class NoteService {
	private final NoteRepo nr;
	
	public NoteService(NoteRepo nr) {
		this.nr=nr;
	}
	public List<Note> all_notes(){
		return nr.findAll();
	}
	
	public Note saveNote(Note note) {
		return nr.save(note);
	}
	
	public Note findById(Long id) {
		return nr.findById(id).get();
	}
	
	public void delete(Note n) {
		nr.delete(n);
	}
}
