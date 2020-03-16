package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {

    @Mock
    EmployeeServiceImpl employeeService;

    @InjectMocks
    EmployeeController sut;

    @Test
    void testGetAllEmployees() {

        EmployeeResource employee1 = new EmployeeResource(new Employee("abc1", "test-fn-1", "test-ln-1",
                "test-email-1", Title.TRAINER, Department.TRAINING, new ResourceMetadata()));

        EmployeeResource employee2 = new EmployeeResource(new Employee("abc2", "test-fn-2", "test-ln-2",
                "test-email-2", Title.SENIOR_TRAINER, Department.TRAINING, new ResourceMetadata()));

        EmployeeResource[] employees = new EmployeeResource[] {
            employee1, employee2
        };

        when(employeeService.getAllEmployees()).thenReturn(Flux.just(employees));

        StepVerifier.create(sut.getAllEmployees())
                    .assertNext(er1 -> {
                        assertEquals(er1.getId(), employee1.getId());
                        assertEquals(er1.getFirstName(), employee1.getFirstName());
                        assertEquals(er1.getLastName(), employee1.getLastName());
                        assertEquals(er1.getTitle(), employee1.getTitle());
                        assertEquals(er1.getDepartment(), employee1.getDepartment());
                        assertEquals(er1.getMetadata(), employee1.getMetadata());
                    })
                    .assertNext(er2 -> {
                        assertEquals(er2.getId(), employee2.getId());
                        assertEquals(er2.getFirstName(), employee2.getFirstName());
                        assertEquals(er2.getLastName(), employee2.getLastName());
                        assertEquals(er2.getTitle(), employee2.getTitle());
                        assertEquals(er2.getDepartment(), employee2.getDepartment());
                        assertEquals(er2.getMetadata(), employee2.getMetadata());
                    })
                    .expectComplete()
                    .verify();


        verify(employeeService, times(1)).getAllEmployees();

    }
}
