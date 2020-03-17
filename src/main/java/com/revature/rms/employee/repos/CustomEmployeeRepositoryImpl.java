package com.revature.rms.employee.repos;

import com.revature.rms.employee.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public CustomEmployeeRepositoryImpl(ReactiveMongoTemplate template) {
        this.mongoTemplate = template;
    }

    public Mono<Void> deactivateUserById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("metadata.active", false);
        return mongoTemplate.updateFirst(query, update, Employee.class).then();
    }

}
