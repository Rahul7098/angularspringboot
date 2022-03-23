package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.UserInfo;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userdbhandleobj;
	
	public UserInfo addUserService(UserInfo userobj) 
	{
		System.out.println("INSIDE addUserService METHOD in SERVICE CLASS");
		System.out.println("Name "+userobj.getName());
		System.out.println("Email  "+userobj.getEmail());
			
		//After save it return the object which it saved
		userobj =userdbhandleobj.save(userobj);
		
		return userobj;
	}
	
	public UserInfo userLoginCheck(UserInfo userobj) 
	{
		System.out.println("INSIDE userLoginCheck METHOD in SERVICE CLASS");
				
		UserInfo uobj = userdbhandleobj.findByEmail(userobj.getEmail());
		
		if (uobj != null)
		{
			if(uobj.getPassword().equals(userobj.getPassword()))
			{
				return uobj;
			}
		}
		
		return null;
	}
	
	public UserInfo userProfileUpdateByRollNo(UserInfo userobj) 
	{
		System.out.println("INSIDE userProfileUpdateByRollNo METHOD in SERVICE CLASS");
				
		//IF ID EXIST UPDATE IT, IF NOT EXIST THEN INSERT IT
		userobj = userdbhandleobj.save(userobj);
		
		return userobj;
	}
	
	

}
