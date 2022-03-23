package com.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.UserInfo;

//public interface UserRepository extends CrudRepository<UserInfo, Integer> 
//{}
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> 
{
	UserInfo findByEmail(String email);	
}
