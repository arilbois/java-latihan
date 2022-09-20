package repositories;

import java.util.*;

import childs.Analyst;
import childs.Employee;
import childs.Programmer;
import childs.ProjectLeader;
import parent.Person;

public class EmployeDataRepositories {
        public static List<Person> getAllEmployee() {

                Person employee1 = new Employee("Ima Holilatul", "Bandung Barat", 22, "EMP001", "HRD", "Jakarta");
                Person employee2 = new Employee("Sita Dwi", "Cimahi Utara", 21, "EMP22", "Admin", "Bandung");
                Person programmer1 = new Programmer("Bagas Indra", "Bandung Selatan", 25, "PRO001",
                                "Frond End Project RS 79",
                                "Bogor", "Php", 4);
                Person programmer2 = new Programmer("Andre Kurnia", "Purwakarta", 24, "PRO002",
                                "Back End Project Kampus juara 79",
                                "Bekasi", "Golang", 5);
                Person projectLeader1 = new ProjectLeader("Rizki Nur", "Ciamis", 28, "PRL001",
                                "Project Leader kampus juara 79",
                                "Bekasi", 8);
                Person projectLeader2 = new ProjectLeader("Murni salfa", "Bandung", 23, "PRL002",
                                "Project Leader RS 79",
                                "Garut",
                                2);
                Person analyst1 = new Analyst("Rizaldi", "Cianjur", 24, "ANA001", "Analist Project Kampus 79",
                                "Bekasi");

                List<Person> listEmployee = new ArrayList<>(Arrays.asList(
                                employee1, employee2, programmer1, programmer2, projectLeader1, projectLeader2,
                                analyst1));

                return listEmployee;
        }

        public static void getAllDataPerson(List<Person> allEmployee) {
        }
}
