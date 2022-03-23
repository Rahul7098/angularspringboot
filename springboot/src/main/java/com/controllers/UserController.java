package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.UserInfo;
import com.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userviceobj;
	
	@PostMapping("/adduserrecord")
	public UserInfo addUserRecord(@RequestBody UserInfo userobj)
	{
		//System.out.println(userobj.getRollno() +"  "+ userobj.getName() + " "+userobj.getEmail()+ "   "+userobj.getPassword());
		
		userviceobj.addUserService(userobj);
				
		return(userobj);
	}
	
	@PostMapping("/userlogincheck")
	public UserInfo userLoginCheck(@RequestBody UserInfo userobj)
	{
		UserInfo uobj = userviceobj.userLoginCheck(userobj);
		
		if(uobj != null)
		{
			return uobj;
		}
		else
		{
			return null;
		}
	}
	
	@PutMapping("/userprofileupdatebyrollno")
	public UserInfo userProfileUpdateByRollNo(@RequestBody UserInfo userobj)
	{
		System.out.println("INSIDE updateUserDetails Method IN CONTROLLER CLASS");
		System.out.println("UPDATED INFORMATION  "+userobj.getName());
			
		return userviceobj.userProfileUpdateByRollNo(userobj);
	}
	
}
