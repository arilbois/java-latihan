package parent;

import childs.Employee;
import interfaces.*;

public abstract class Person implements Salary, FindUmk, Allowance {
  private String name, address;
  private Integer age;

  public Person() {
  }

  public Person(String name, String address, Integer age) {
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void addPerson(Employee employee) {
  }

}
