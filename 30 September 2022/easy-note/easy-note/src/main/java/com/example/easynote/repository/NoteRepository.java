package com.example.easynote.repository;

import com.example.easynote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}