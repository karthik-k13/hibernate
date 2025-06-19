package com.example.demo1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo1.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	Optional<Employee> findByFirstName(String firstName);
	 Optional<Employee> findByEmailId(String email);
	 Optional<Employee> findByMobile(String mobile);
	 boolean existsByFirstName(String firstName);
	 boolean existsByEmailId(String email);
	 boolean existsByMobile(String mobile);
	 long countByFirstName(String firstName);
	 List<Employee> findByEmailIdContaining(String keyword);
	 List<Employee> findByEmailIdStartingWith(String prefix);
	 List<Employee> findByEmailIdEndingWith(String suffix);
	 Optional<Employee> findByEmailIdAndMobile(String email,String mobile);
	 List<Employee> findByEmailIdOrMobile(String email,String mobile);
	 
	 //JPQL Queries
	 @Query(value = "select e from Employee e where e.emailId=:x")
	 Optional<Employee> searchByEmailJPQL(@Param("x") String email);
	 
	 @Query(value = "select e from Employee e where e.mobile=:m")
	Optional<Employee> searchByMobileJPQL(@Param("m") String mobile);
	 
	 @Query(value = "select e from Employee e where e.emailId=:x and e.mobile=:m")
	 Optional<Employee> searchByEmailAndMobileJPQL(@Param("x") String email,@Param("m") String mobile);
	 
	 @Query(value="select e from Employee e where e.emailId=:x or e.mobile=:m")
	List<Employee> searchByEmailOrMobileJPQL(@Param("x") String email,@Param("m") String mobile);
	 
	 
	 // native SQL queries
	 
	 @Query(value = "select * from employee where email_id=?1 ",nativeQuery =true)
	 Optional<Employee> getByEmailSQL(String email);
	 
	 @Query(value = "select * from employee where mobile=?1",nativeQuery = true)
	Optional<Employee> getByMobileSQL(String mobile);
	 
	 @Query(value = "select * from employee where email_id=?2 and mobile=?1",nativeQuery = true )
	 Optional<Employee> getByMobileAndEmailSQL(String mobile,String email);
	 
	 @Query(value="select * from employee where email_id=?1 or mobile=?2",nativeQuery = true)
	 List<Employee> getByEmailOrMobileSQL(String email,String mobile);
}
