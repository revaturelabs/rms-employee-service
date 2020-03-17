package com.revature.rms.employee.repos;

import reactor.core.publisher.Mono;

public interface CustomEmployeeRepository {
    Mono<Void> deactivateUserById(String id);
}
