package com.teno.repo;

import org.springframework.data.repository.CrudRepository;

import com.teno.model.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
