package com.juanbailke.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juanbailke.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
