package ca.sheridancollege.lenguyen.springadvancejpa.database;

import ca.sheridancollege.lenguyen.springadvancejpa.beans.Email;
import ca.sheridancollege.lenguyen.springadvancejpa.beans.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setName("Donald Trump");
        Email email = new Email();
        email.setEmail("donald@gmail.com");
        List<Email> emails = new ArrayList<>();
        emails.add(email);
        employee.setEmails(emails);
        employeeRepository.save(employee);
        Long id = employee.getId();
        Employee employee1 = employeeRepository.findById(id).get();
        assertEquals("Donald Trump", employee1.getName());
    }
}