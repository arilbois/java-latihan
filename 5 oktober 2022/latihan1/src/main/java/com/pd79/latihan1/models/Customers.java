package com.pd79.latihan1.models;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customers")
public class Customers {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long customersId;

  @Column(name = "customers_name", nullable = false)
  private String customersName;

  @Column(name = "date_of_birth", nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateOfBirth;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "postal_code", nullable = false)
  private String postalCode;

  @Column(name = "email", nullable = false)
  private String email;

  public Customers() {

  }

  public Customers(String customersName, Date dateOfBirth, String country, String address,
      String phoneNumber, String postalCode, String email) {
    this.customersName = customersName;
    this.dateOfBirth = dateOfBirth;
    this.country = country;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.postalCode = postalCode;
    this.email = email;

  }

  public Long getCustomersId() {
    return customersId;
  }

  public String getCustomersName() {
    return customersName;
  }

  public void setCustomersName(String customersName) {
    this.customersName = customersName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}