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

import com.pd79.latihan1.models.Customers;
import com.pd79.latihan1.repositories.CustomersRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomersController {

  @Autowired
  CustomersRepository customersRepository;

  // Get All Customerss
  @GetMapping("/readAllCustomers")
  public ResponseEntity<Object> getAllCustomers() {
    Map<String, Object> result = new HashMap<String, Object>();
    List<Customers> listAllCustomers = customersRepository.findAll();

    if (listAllCustomers.isEmpty()) {
      result.put("status", "404");
      result.put("message", "No DATA");
      result.put("data", listAllCustomers);
      result.put("total", listAllCustomers.size());

      HttpStatus status = HttpStatus.NOT_FOUND;

      return new ResponseEntity<Object>(result, status);
    } else {
      result.put("status", "200");
      result.put("message", "Read All data Customerss Success.");
      result.put("data", listAllCustomers);
      result.put("total", listAllCustomers.size());

      HttpStatus status = HttpStatus.OK;

      return new ResponseEntity<Object>(result, status);
    }

  }

  // get Customers By Id
  @GetMapping("/readCustomersById/{id}")
  public ResponseEntity<Object> getCustomersByIdResponseEntity(@PathVariable("id") long id) {
    Map<String, Object> result = new HashMap<String, Object>();
    try {
      if (!(customersRepository.findById(id).isPresent())) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        result.put("status", "404");
        result.put("message", "Read Customers By Id failed, Id " + id + " not found.");

        return ResponseEntity.status(status).body(result);
      } else {
        Customers customers = customersRepository.findById(id).get();
        HttpStatus status = HttpStatus.OK;
        result.put("status", "200");
        result.put("message", "Read All data Customerss By Id.");
        result.put("data", customers);

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

  // Create Customers
  @PostMapping("/createCustomers")
  public ResponseEntity<Customers> createTutorial(@RequestBody Customers customers) {
    try {
      Customers _customers = customersRepository
          .save(new Customers(customers.getCustomersName(), customers.getDateOfBirth(), customers.getCountry(),
              customers.getAddress(), customers.getPhoneNumber(), customers.getPostalCode(), customers.getEmail()));
      return new ResponseEntity<>(_customers, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // edit Customers
  @PutMapping("/updateCustomers/{id}")
  public ResponseEntity<Customers> updateTutorial(@PathVariable("id") long id, @RequestBody Customers customers) {
    Optional<Customers> customersData = customersRepository.findById(id);

    if (customersData.isPresent()) {
      Customers _customers = customersData.get();
      _customers.setCustomersName(customers.getCustomersName());
      _customers.setDateOfBirth(customers.getDateOfBirth());
      _customers.setCountry(customers.getCountry());
      _customers.setAddress(customers.getAddress());
      _customers.setPhoneNumber(customers.getPhoneNumber());
      _customers.setPostalCode(customers.getPostalCode());
      _customers.setEmail(customers.getEmail());

      return new ResponseEntity<>(customersRepository.save(_customers), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/deleteCustomers/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      customersRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}