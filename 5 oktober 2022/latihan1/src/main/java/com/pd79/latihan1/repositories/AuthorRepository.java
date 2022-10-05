package com.pd79.latihan1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pd79.latihan1.models.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

  List<Author> findByFirstName(String firstName);

  List<Author> findByLastName(String lastName);

  List<Author> findByGender(String gender);

  List<Author> findByCountry(String country);

  List<Author> findByRating(String rating);
}
