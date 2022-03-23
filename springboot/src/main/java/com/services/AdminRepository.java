package com.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.UserInfo;

//public interface AdminRepository extends CrudRepository<UserInfo, Integer>
//{ }


@Repository
public interface AdminRepository extends JpaRepository<UserInfo, Integer>
{
	UserInfo findByEmail(String email);
	
	List<UserInfo> findByName(String name);
}
