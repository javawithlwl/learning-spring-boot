package com.careerit.springdata.repo;

import com.careerit.springdata.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepo extends BaseEntityCurdRepository<Employee, UUID> {

      Optional<Employee> findByMobile(String mobile);
      List<Employee> findBySalaryBetween(double from,double to);

      @Query("select e from Employee e where e.email=:email and e.deleted=false")
      Optional<Employee> getByEmpEmail(@Param("email") String email);


}
