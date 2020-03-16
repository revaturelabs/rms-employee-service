package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.GetEmployeeByFieldRequest;
import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {

    @Mock
    EmployeeServiceImpl employeeService;

    @InjectMocks
    EmployeeController sut;

    EmployeeResource[] employees;

    @AfterEach
    public void tearDown() {
        employees = null;
    }

    @Test
    void testGetAllEmployees() {

        EmployeeResource employee1 = new EmployeeResource(new Employee("abc1", "test-fn-1", "test-ln-1",
                "test-email-1", Title.TRAINER, Department.TRAINING, new ResourceMetadata()));

        EmployeeResource employee2 = new EmployeeResource(new Employee("abc2", "test-fn-2", "test-ln-2",
                "test-email-2", Title.SENIOR_TRAINER, Department.TRAINING, new ResourceMetadata()));

        employees = new EmployeeResource[] {
                employee1, employee2
        };

        when(employeeService.getAllEmployees()).thenReturn(Flux.just(employees));

        StepVerifier.create(sut.getAllEmployees())
                    .assertNext(er1 -> {
                        assertEquals(er1.getId(), employees[0].getId());
                        assertEquals(er1.getFirstName(), employees[0].getFirstName());
                        assertEquals(er1.getLastName(), employees[0].getLastName());
                        assertEquals(er1.getTitle(), employees[0].getTitle());
                        assertEquals(er1.getDepartment(), employees[0].getDepartment());
                        assertEquals(er1.getMetadata(), employees[0].getMetadata());
                    })
                    .assertNext(er2 -> {
                        assertEquals(er2.getId(), employees[1].getId());
                        assertEquals(er2.getFirstName(), employees[1].getFirstName());
                        assertEquals(er2.getLastName(), employees[1].getLastName());
                        assertEquals(er2.getTitle(), employees[1].getTitle());
                        assertEquals(er2.getDepartment(), employees[1].getDepartment());
                        assertEquals(er2.getMetadata(), employees[1].getMetadata());
                    })
                    .expectComplete()
                    .verify();


        verify(employeeService, times(1)).getAllEmployees();

    }

    @Test
    void testGetEmployeeById() {

        EmployeeResource employee1 = new EmployeeResource(new Employee("abc1", "test-fn-1", "test-ln-1",
                "test-email-1", Title.TRAINER, Department.TRAINING, new ResourceMetadata()));

        employees = new EmployeeResource[] {
                employee1
        };

        GetEmployeeByFieldRequest req = new GetEmployeeByFieldRequest("id", new String[] {"abc1"});

        when(employeeService.getEmployeesByField(req.getField(), req.getValues())).thenReturn(Flux.just(employees));

        StepVerifier.create(sut.getEmployeesByField(req))
                .assertNext(er1 -> {
                    assertEquals(er1.getId(), employees[0].getId());
                    assertEquals(er1.getFirstName(), employees[0].getFirstName());
                    assertEquals(er1.getLastName(), employees[0].getLastName());
                    assertEquals(er1.getTitle(), employees[0].getTitle());
                    assertEquals(er1.getDepartment(), employees[0].getDepartment());
                    assertEquals(er1.getMetadata(), employees[0].getMetadata());
                })
                .expectComplete()
                .verify();


        verify(employeeService, times(1)).getEmployeesByField(req.getField(), req.getValues());

    }
}
