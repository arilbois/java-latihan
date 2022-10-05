package com.pd79.latihan1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd79.latihan1.models.Author;
import com.pd79.latihan1.repositories.AuthorRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AuthorController {

  @Autowired
  AuthorRepository authorRepository;

  // Get All Auhtor
  @GetMapping("/readAllAuthor")
  public ResponseEntity<Object> getAllAuthor() {
    Map<String, Object> result = new HashMap<String, Object>();
    List<Author> listAllAuthor = authorRepository.findAll();

    if (listAllAuthor.isEmpty()) {
      result.put("status", "404");
      result.put("message", "No DATA");
      result.put("data", listAllAuthor);
      result.put("total", listAllAuthor.size());

      HttpStatus status = HttpStatus.NOT_FOUND;

      return new ResponseEntity<Object>(result, status);
    } else {
      result.put("status", "200");
      result.put("message", "Read All data Author Success.");
      result.put("data", listAllAuthor);
      result.put("total", listAllAuthor.size());

      HttpStatus status = HttpStatus.OK;

      return new ResponseEntity<Object>(result, status);
    }

  }

  // get Author By Id
  @GetMapping("/readAuthorbyid/{id}")
  public ResponseEntity<Object> getAuthorByIdResponseEntity(@PathVariable("id") long id) {
    Map<String, Object> result = new HashMap<String, Object>();
    try {
      if (!(authorRepository.findById(id).isPresent())) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        result.put("status", "404");
        result.put("message", "Read Auhtor By Id failed, Id " + id + " not found.");

        return ResponseEntity.status(status).body(result);
      } else {
        Author author = authorRepository.findById(id).get();
        HttpStatus status = HttpStatus.OK;
        result.put("status", "200");
        result.put("message", "Read All data Auhtor By Id.");
        result.put("data", author);

        return ResponseEntity.status(status).body(result);
      }
    } catch (Exception e) {
      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
      result.put("status", "400");
      result.put("message", "ERROR");
      result.put("error", e);

      return ResponseEntity.status(status).body(result);
    }

  }

  // Create Author
  @PostMapping("/createAuthor")
  public ResponseEntity<Author> createTutorial(@RequestBody Author author) {
    try {
      Author _author = authorRepository
          .save(new Author(author.getFirstName(), author.getLastName(), author.getGender(), author.getAge(),
              author.getCountry(), author.getRating()));
      return new ResponseEntity<>(_author, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // edit author
  @PutMapping("/updateAuthor/{id}")
  public ResponseEntity<Author> updateTutorial(@PathVariable("id") long id, @RequestBody Author author) {
    Optional<Author> authorData = authorRepository.findById(id);

    if (authorData.isPresent()) {
      Author _author = authorData.get();
      _author.setFirstName(author.getFirstName());
      _author.setLastName(author.getLastName());
      _author.setGender(author.getGender());
      _author.setAge(author.getAge());
      _author.setCountry(author.getCountry());
      _author.setRating(author.getRating());

      return new ResponseEntity<>(authorRepository.save(_author), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/deleteAuthor/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      authorRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}