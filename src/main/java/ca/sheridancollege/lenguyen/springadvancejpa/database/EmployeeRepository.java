package ca.sheridancollege.lenguyen.springadvancejpa.database;

import ca.sheridancollege.lenguyen.springadvancejpa.beans.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
