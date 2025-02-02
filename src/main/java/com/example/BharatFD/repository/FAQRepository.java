package com.example.BharatFD.repository;

 

import com.example.BharatFD.model.FAQ;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends MongoRepository<FAQ, String> {
}
