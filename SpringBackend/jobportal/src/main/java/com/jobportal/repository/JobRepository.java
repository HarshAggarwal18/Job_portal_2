package com.jobportal.repository;

import com.jobportal.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository <Job,Long> {
}
