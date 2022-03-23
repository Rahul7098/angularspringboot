package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.UserInfo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminDBrepositoryobj;
	
	public List<UserInfo> fetchalluserdetails()
	{
		System.out.println("INSIDE fetchalluserdetails METHOD in SERVICE CLASS \n");
		
		List<UserInfo> alluserdetails = new ArrayList<UserInfo>();
		
		adminDBrepositoryobj.findAll().forEach(alluserdetails::add);
		return alluserdetails;
	 }
	
	public boolean deleteUserByRollNo(int roll) 
	{
		boolean recorddeleted = false;
		try
		{
			System.out.println("INSIDE deleteUser METHOD in SERVICE CLASS");
			System.out.println("ROLL NO  "+ roll +"\n");
		
			adminDBrepositoryobj.deleteById(roll);
			
			recorddeleted = true;
		
		}catch(Exception e) 
		 {
			System.out.println("INVALID ROLL NO");
		 }
		
		return recorddeleted;
	}
	
	
	public UserInfo searchUserbyemail(String uemail) 
	{
		UserInfo uobj = adminDBrepositoryobj.findByEmail(uemail);
		
		if (uobj != null)
			return uobj;
		else
			return null;
	}
	
	public List<UserInfo> searchMultipleUserByName(String uname) 
	{
		List<UserInfo> listuserobj = adminDBrepositoryobj.findByName(uname);
		
		if (listuserobj.size() > 0)
			return listuserobj;
		else
			return null;
	}
	
	

}
