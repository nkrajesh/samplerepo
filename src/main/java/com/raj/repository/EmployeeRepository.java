package com.raj.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raj.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{
	Optional<Employee> findById(Integer Id);
	void deleteById(Integer Id);
}
