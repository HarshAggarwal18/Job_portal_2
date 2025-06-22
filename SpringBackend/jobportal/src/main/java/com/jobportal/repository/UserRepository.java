package com.jobportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobportal.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}
