package com.example.demo1;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1.entity.Employee;
import com.example.demo1.repository.EmployeeRepository;

@SpringBootTest
public class DemoCrudOperationsTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void saveRecord() {
		Employee emp = new Employee();
		emp.setFirstName("krish");
		emp.setLastName("reddy");
		emp.setEmailId("kaaru13@gmail.com");
		emp.setMobile("7760214629");
		employeeRepository.save(emp);
	}

	@Test
	void getRecordById() {
		Optional<Employee> opEmp = employeeRepository.findById(3L);
		if (opEmp.isPresent()) {
			Employee emp = opEmp.get();
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getEmailId());
			System.out.println(emp.getMobile());
		} else {
			System.out.println("no records found");
		}
	}

	@Test
	void getAllRecords() {
		Iterable<Employee> itrEmp = employeeRepository.findAll();
		for (Employee emp : itrEmp) {
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getEmailId());
			System.out.println(emp.getMobile());
		}
	}

	@Test
	void updateRecord() {
		Employee emp = new Employee();
		emp.setId(3);
		emp.setFirstName("kaaru");
		emp.setLastName("karthik");
		emp.setEmailId("kaaru13@gmail.com");
		emp.setMobile("9148448437");
		employeeRepository.save(emp);
	}

	@Test
	void deleteRecordById() {
		employeeRepository.deleteById(3L);
	}

	@Test
	void deleteAllRecords() {
		employeeRepository.deleteAll();

	}

	@Test
	void countRecords() {
		long recordCount = employeeRepository.count();
		System.out.println(recordCount);
	}

	@Test
	void findByFirstName() {
		Optional<Employee> opEmp = employeeRepository.findByFirstName("kaaru");
		if (opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getEmailId());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("no records found");
		}
	}

	@Test
	void findByEmailId() {
		Optional<Employee> opEmp = employeeRepository.findByEmailId("kaaru1@gmail.com");
		if (opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getEmailId());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("no records found");
		}
	}

	@Test
	void findByMobile() {
		Optional<Employee> opEmp = employeeRepository.findByMobile("914844837");
		if (opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getEmailId());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("no records found");
		}
	}

	@Test
	void existsByFirstName() {
		boolean result = employeeRepository.existsByFirstName("kaaru");
		System.out.println(result ? "record found" : "no record found");

	}

	@Test
	void existsByEmailId() {
		boolean result = employeeRepository.existsByEmailId("kaaru134@gmail.com");
		System.out.println(result ? "record found" : "no record found");

	}

	@Test
	void existsByMobile() {
		boolean result = employeeRepository.existsByMobile("9148448437");
		System.out.println(result ? "record found" : "no record found");

	}

	@Test
	void countByfirstName() {
		long count = employeeRepository.countByFirstName("kaar");
		System.out.println(count);
	}

	@Test
	void findByEmailIdContaining() {
		List<Employee> emp = employeeRepository.findByEmailIdContaining("134");
		for (Employee e : emp) {
			System.out.println(e.getEmailId());
		}
	}

	@Test
	void findByEmailIdStartingWith() {
		List<Employee> emp = employeeRepository.findByEmailIdStartingWith("kaaru13");
		for (Employee e : emp) {
			System.out.println(e.getEmailId());
		}
	}

	@Test
	void findByEmailIdEndingWith() {
		List<Employee> emp = employeeRepository.findByEmailIdEndingWith("3@gmail.com");
		for (Employee e : emp) {
			System.out.println(e.getEmailId());
		}
	}

	@Test
	void findByEmailIdAndMobile() {
		Optional<Employee> opEmp = employeeRepository.findByEmailIdAndMobile("kaaru13@gmail.com", "9148448438");
		if (opEmp.isPresent()) {
			Employee emp = opEmp.get();
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getEmailId());
			System.out.println(emp.getMobile());

		} else {
			System.out.println("no record found");
		}
	}

	@Test
	void findByEmailIdOrMobile	() {
		List<Employee> emp = employeeRepository.findByEmailIdOrMobile("kaaru1345@gmail.com","9148448439");
		for (Employee e : emp) {
			System.out.println(e.getEmailId());
		}
	}
	
	@Test
	void searchByEmailJPQL() {
		Optional<Employee> opEmp=employeeRepository.searchByEmailJPQL("kaaru135@gmail.com");
		if(opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getFirstName());
		}else {
			System.out.println("no record found");
		}
	}
	
	@Test
	void searchByMobileJPQL() {
		Optional<Employee> opEmp = employeeRepository.searchByMobileJPQL("9148448438");
		if(opEmp.isPresent()) {
			Employee emp = opEmp.get();
			System.out.println(emp.getFirstName());
		}else {
			System.out.println("no record found");
		}
	}
	
	@Test
	void searchByEmailAndMobileJPQL() {
		Optional<Employee> opEmp = employeeRepository.searchByEmailAndMobileJPQL("kaaru13@gmail.com","9148448437");
		if(opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getFirstName());
		}else {
			System.out.println("no record found");
		}
	}
	
	@Test
	void searchByEmailOrMobileJPQL() {
		List<Employee> emp = employeeRepository.searchByEmailOrMobileJPQL("kaaru13@gmail.com", "9148448438");
		for(Employee e:emp) {
			System.out.println(e.getEmailId());
		}
	}
	
	@Test
	void getByEmailSQL() {
		Optional<Employee> opEmp = employeeRepository.getByEmailSQL("kaaru134@gmail.com");
		if(opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getFirstName());
		}else {
			System.out.println("no record found");
		}
	}
	
	@Test
	void getByMobileSQL() {
		Optional<Employee> opEmp = employeeRepository.getByMobileSQL("9148448438");
		if(opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getFirstName());
		}else {
			System.out.println("no record found");
		}
	}
	
	@Test
	void getByMobileAndEmailSQL() {
		Optional<Employee> opEmp = employeeRepository.getByMobileAndEmailSQL("9148448438","kaaru134@gmail.com");
		if(opEmp.isPresent()) {
			Employee employee = opEmp.get();
			System.out.println(employee.getFirstName());
		}else {
			System.out.println("no record found");
		}
	}
	
	@Test
	void getByEmailOrMobileSQL() {
		List<Employee> emp = employeeRepository.getByEmailOrMobileSQL("kaaru134@gmail.com", "7760214629");
		for(Employee e:emp) {
			System.out.println(e.getEmailId());
		}
	}

}
