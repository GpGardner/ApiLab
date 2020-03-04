package com.GG.ApiDesignLab.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GG.ApiDesignLab.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	
	List<User> findAllByState(String state);
}
