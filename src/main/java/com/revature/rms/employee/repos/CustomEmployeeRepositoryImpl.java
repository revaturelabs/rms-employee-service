package com.revature.rms.employee.repos;

import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public CustomEmployeeRepositoryImpl(ReactiveMongoTemplate template) {
        this.mongoTemplate = template;
    }

    public Mono<Employee> deactivateUserById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
//        Update update = new Update().set("metadata.isActive", false);

        LocalDateTime now = LocalDateTime.now();
        ResourceMetadata metadata = new ResourceMetadata(1, now, 1, now, 1, false);
        Employee trainer1 = new Employee("5e70e8e8d798ce32e0ce9b57", "Robert", "Connell", "robert.connell@revature.com", "5e70e8e8d798ce32e0ce9b54", Title.TRAINER, Department.TRAINING, metadata);
        return mongoTemplate.findAndReplace(query, trainer1);
    }

}
