package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.models.UserInfo;
import com.services.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminService adminserviceobj;
	
	@GetMapping("/fetchalluserdetails")
	public List<UserInfo> getAllUserDetails()
	{
		System.out.println("INSIDE getAllUserDetails Method IN CONTROLLER CLASS");
		
		return adminserviceobj.fetchalluserdetails();
	}
	
	@DeleteMapping("/deleterecordbyrollno/{rollno}")
	public UserInfo deleteRecordByRollNo(@PathVariable String rollno)
	{
		System.out.println("INSIDE deleteUser Method IN CONTROLLER CLASS");
		System.out.println("RECEIVED FROM URL IN CONTROLLER "+rollno);
		
		int rno = Integer.parseInt(rollno);
		boolean recorddeletedstatus = adminserviceobj.deleteUserByRollNo(rno);
		
		if(recorddeletedstatus)
		    return new UserInfo();
		else
			return null;
	}
	
	@GetMapping("/searchuserbyemail/{email}")
	public UserInfo searchStudentByRoll(@PathVariable String email)
	{
		return adminserviceobj.searchUserbyemail(email);
	}
	
	@GetMapping("/searchmultipleuserbyname/{name}")
	public List<UserInfo> searchmultipleuserbyname(@PathVariable String name)
	{
		return adminserviceobj.searchMultipleUserByName(name);
	}

}
