package com.manzuraz.note1.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manzuraz.note1.models.Note;

@Repository
public interface NoteRepo extends CrudRepository<Note,Long>{
	List<Note> findAll();

}
