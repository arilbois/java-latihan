package com.pd79.latihan1.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pd79.latihan1.models.Customers;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

  List<Customers> findByCustomersName(String customersName);

  List<Customers> findByDateOfBirth(Date dateOfBirth);

  List<Customers> findByCountry(String country);

  List<Customers> findByAddress(String address);

  List<Customers> findByPhoneNumber(String phoneNumber);

  List<Customers> findByPostalCode(String postalCode);

  List<Customers> findByEmail(String email);
}
