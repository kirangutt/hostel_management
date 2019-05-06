package com.sakha.kiran.hostel.manage.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hostel/registration")
public class RegistrationController {
	//........Level-2.......//
	String name=null;
	String education=null;
	String userName=null;
	String passWord=null;
	String branch=null;
	String designation=null;
	String joiningDate=null;
	int roomNumber=0;
	String url="jdbc:mysql://localhost:3306/hostel_management";
    String uname="root";
    String pass="root";

	 
	Map<String, Object> finalrsponce=new HashMap<String,Object>();
	
	/*LEVEL-1
	 * @RequestMapping(value="/warden",method=RequestMethod.POST) 
	 * public String warden(HttpServletRequest request,HttpServletResponse
	 * response) {
	 * 
	 * 
	 * System.out.println("Registration of admin is sucessfful");
	 * System.out.println("Name:"+name+" "+"Education:"+education+" "+"userName:"+userName+" "+"passWord:"+passWord+" "+"designation:"+designation+" "+"joiningDate:"+joiningDate);
	 * 
	 *  return "Name:"+name+" "+"Education:"+education+" "+"userName:"+userName+" "+"passWord:"+passWord+" "+"designation:"+designation+" "+"joiningDate:"+joiningDate);;
	 */
	
	//..........Level-2.........//
	@RequestMapping(value="/warden",method=RequestMethod.POST)
	public Map<String,Object> warden(HttpServletRequest request,HttpServletResponse response) {
		  
	   name = request.getParameter("name");
	   education = request.getParameter("education");
	   userName = request.getParameter("userName");
	   passWord = request.getParameter("passWord");
	   designation = request.getParameter("designation");
	   joiningDate = request.getParameter("joiningDate");
	   
	   System.out.println("Registration is sucessfful");
	   System.out.println("Name:"+name+" "+"Education:"
	                      +education+" "+"userName:"
			              +userName+" "+"passWord:"
	                      +passWord+" "+"designation:"
			              +designation+" "+"joiningDate:"
	                      +joiningDate);
	   
	   finalrsponce.put("Name",name);
	   finalrsponce.put("Education",education);
	   finalrsponce.put("userName",userName);
	   finalrsponce.put("passWord",passWord);
	   finalrsponce.put("designation",designation);
	   finalrsponce.put("joiningDate",joiningDate);
	   
	 try {
		 
		 String query="INSERT INTO warden "
		 		+ "(name, education, "
		 		+ "userName, passWord, "
		 		+ "designation, joiningDate)"
		 		+ " VALUES(' " 
		 		+ name + "', '" + education + "', '" 
		 		+ userName + "', '" + passWord + "', '" 
		 		+ designation + "', '" + joiningDate + "');";

		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(url, uname, pass);
		   
		   Statement st=con.createStatement();          
		   st.executeUpdate(query);
		   
		   System.out.println("query = " + query);
		   
		   st.close();
		   con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.getStackTrace();
	}
	   
	    return finalrsponce;
	  }
	
	/*...Level-1....//
	 * @RequestMapping(value="/admin",method=RequestMethod.POST) public String
	 * admin(HttpServletRequest request,HttpServletResponse response) {
	 *
	 * System.out.println("Registration of admin is sucessfful");
	 * System.out.println("Name:"+name+" "+"Education:"+education+" "+"userName:"+
	 * userName+" "+"passWord:"+passWord+" "+"designation:"+designation+" "
	 * +"joiningDate:"+joiningDate);
	 */
	
	//........level-2...//
	@RequestMapping(value="/admin",method=RequestMethod.POST)
	public Map<String, Object> admin(HttpServletRequest request,HttpServletResponse response) {
		
		
		name = request.getParameter("name");
		education = request.getParameter("education");
		userName = request.getParameter("userName");
	    passWord = request.getParameter("passWord");
	    branch=request.getParameter("branch");
		designation = request.getParameter("designation");
		joiningDate = request.getParameter("joiningDate");
		
		finalrsponce.put("Name",name);
		   finalrsponce.put("Education",education);
		   finalrsponce.put("userName",userName);
		   finalrsponce.put("passWord",passWord);
		   finalrsponce.put("branch", branch);
		   finalrsponce.put("designation",designation);
		   finalrsponce.put("joiningDate",joiningDate);
		   
		   
		   System.out.println("Registration is sucessfful");
		   System.out.println("Name:"+name+" "+"Education:"
		                      +education+" "+"userName:"
				              +userName+" "+"passWord:"
		                      +passWord+" "+"designation:"
				              +designation+" "+"joiningDate:"
		                      +joiningDate);
		   
		try {
				 
	        String query="INSERT INTO admin "
		    + "(name, education, "
		    + "userName, passWord, "
			+ "designation, joiningDate)"
			+ " VALUES(' " 
			+ name + "', '" + education + "', '" 
			+ userName + "', '" + passWord + "', '" 
		    + designation + "', '" + joiningDate + "');";
	        
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(url, uname, pass);
		   
		   Statement st=con.createStatement();          
		   st.executeUpdate(query);
		   
		   System.out.println("query = " + query);
		   
		   st.close();
		   con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.getStackTrace();
	}
	   
		   return finalrsponce;
	}
	
	
	/*
	 * ........Level-1...
	 * 
	 * @RequestMapping(value = "/student", method = RequestMethod.POST) public
	 * String student(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * System.out.println("Registration of student is sucessfful");
	 * System.out.println("Name:"+name+" "+"Education:"+education+" "+"userName:"+
	 * userName+" "+"passWord:"+passWord+" "+"designation:"+designation+" "
	 * +"joiningDate:"+joiningDate);
	 * 
	 * return "Name:"+name+" "+"Education:"+education+" "+"userName:"+ userName+" "+"passWord:"+passWord+" "+"designation:"+designation+" ""joiningDate:"+joiningDate;
	 */

	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Map<String, Object> student(HttpServletRequest request,HttpServletResponse response) {
		
		name = request.getParameter("name");
		education = request.getParameter("education");
		branch=request.getParameter("branch");
		userName = request.getParameter("userName");
	    passWord = request.getParameter("passWord");
		designation = request.getParameter("designation");
		joiningDate = request.getParameter("joiningDate");
		roomNumber=Integer.parseInt(request.getParameter("roomNumber"));

		finalrsponce.put("Name",name);
		finalrsponce.put("Education",education);
		finalrsponce.put("branch", branch);
		finalrsponce.put("userName",userName);
		finalrsponce.put("passWord",passWord);
		finalrsponce.put("designation",designation);
	    finalrsponce.put("joiningDate",joiningDate);
	    finalrsponce.put("roomNumber", roomNumber);
	    
	    
	    System.out.println("Registration is sucessfful");
		   System.out.println("Name:"+name+" "
	                    +"Education:"+education+" "
				        +"branch:"+branch+" "
	                    +"userName:"+userName+" "
				        +"passWord:"+passWord+" "
	                    +"designation:"+designation+" "
				        +"joiningDate:"+joiningDate+" "
				        +"roomNumber:"+roomNumber);
		   
		   System.out.println("Registration is sucessfful");
		   System.out.println("Name:"+name+" "
		                     +"Education:"+education+" "
		                     +"branch:"+branch+" "
				             +"userName:"+userName+" "
		                     +"passWord:"+passWord+" "
				             +"designation:"+designation+" "
		                     +"joiningDate:"+joiningDate+" "
		                     +"roomNumber:"+roomNumber);
		  
		   try {
			 
	        String query="INSERT INTO student "
		    + "(name, education, branch "
		    + "userName, passWord, "
			+ "designation, joiningDate , roomNumber)"
			+ " VALUES(' " 
			+ name + "', '" + education + "', '" + branch + "','" 
			+ userName + "', '" + passWord + "', '" 
		    + designation + "', '" + joiningDate + "','" + roomNumber + "');";
	        
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(url, uname, pass);
		   
		   Statement st=con.createStatement();          
		   st.executeUpdate(query);
		   
		   System.out.println("query = " + query);
		   
		   st.close();
		   con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.getStackTrace();
	}
	   
		return finalrsponce;
	}

}
