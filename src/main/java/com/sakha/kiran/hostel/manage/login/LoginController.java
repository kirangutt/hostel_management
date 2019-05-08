package com.sakha.kiran.hostel.manage.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sakha.kiran.hostel.manage.util.DBConnection;

@RestController
@RequestMapping("/hostel/login")
public class LoginController {

	String userName = null;
	String passWord = null;

	DBConnection dbconn = new DBConnection();

	Map<String, Object> finalresponce = new HashMap<String, Object>();

	@RequestMapping(value = "/warden", method = RequestMethod.PUT)
	public Map<String, Object> warden(HttpServletRequest request, HttpServletResponse response) {
		userName = request.getParameter("userName");
		passWord = request.getParameter("passWord");

		Map<String, Object> error = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> detailsWarden = new HashMap<String, Object>();
        List<Map<String, Object>> admins = new ArrayList<Map<String, Object>>();
		
		String query = "SELECT * FROM warden WHERE userName='" + userName + "';";
        String query1 = "SELECT * FROM admin";
        String query2 = "SELECT * FROM student";
		try {
			
			Connection con = dbconn.getDBConnection();
			//....for warden.....//
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("ResultSet:" + rs);

			if (rs.next()) {
				
				String dbPassword = rs.getObject("passWord").toString();
				
				if (dbPassword.equals(passWord)) {

					data.put("message", "Login is Successfull");

					String dbname = rs.getObject("name").toString();
					String dbeducation = rs.getObject("education").toString();
					String dbuserName = rs.getObject("userName").toString();
					String dbdesignation = rs.getObject("designation").toString();
					String dbjoiningDate = rs.getObject("joiningDate").toString();

					detailsWarden.put("name", dbname);
					detailsWarden.put("education", dbeducation);
					detailsWarden.put("userName", dbuserName);
					detailsWarden.put("designation", dbeducation);
					detailsWarden.put("joiningDate", dbjoiningDate);

					//....for admins.....//
					Statement st1 = con.createStatement();
					ResultSet rs1 = st.executeQuery(query1);

					while (rs1.next()) {
	                    
						Map<String, Object> admin =new HashMap<String, Object>();
						
						String dbname1 = rs1.getObject("name").toString();
						String dbeducation1 = rs1.getObject("education").toString();
						String dbuserName1 = rs1.getObject("userName").toString();
						String dbdesignation1 = rs1.getObject("designation").toString();
						String dbjoiningDate1 = rs1.getObject("joiningDate").toString();
						
						admin.put("name", dbname1);
						admin.put("education", dbeducation1);
						admin.put("userName", dbuserName1);
						admin.put("designation", dbdesignation1);
						admin.put("joiningDate", dbjoiningDate1);
						
						admins.add(admin);
					}

					st1.close();

				} else {
					data.put("message", "Password is Invalid");
				}
				
			} 
			
			//Statement st2 = con.createStatement();
			//ResultSet rs2 = st.executeQuery(query2);
				
			st.close();
			con.close();
			//st2.close();			

		} catch (SQLException e) {
			error.put("code", e.getErrorCode());
			error.put("error", e.getMessage());
			e.printStackTrace();
		} catch (Exception e1) {
			error.put("code", "400");
			error.put("error", e1.getMessage());
			e1.printStackTrace();
		}

		data.put("yourDetails", detailsWarden);
		data.put("adminsDetails", admins);

		finalresponce.put("data", data);
		finalresponce.put("error", error);
		System.out.println("Wellcome to warden");
		return finalresponce;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.PUT)
	public Map<String, Object> admin(HttpServletRequest request, HttpServletResponse response) {
		userName = request.getParameter("userName");
		passWord = request.getParameter("passWord");

		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> error = new HashMap<String, Object>();
		Map<String, Object> detailsAdmin = new HashMap<String, Object>();
		// Map<String, Map<String,Object>> detailsStudent = new HashMap<>();
		List<Map<String, Object>> students = new ArrayList<Map<String, Object>>();

		String query = "SELECT * FROM admin WHERE userName='" + userName + "'";
		String query1 = "SELECT * FROM student";
		try {

			// ......for admin.....//
			Connection con = dbconn.getDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			// ....for student....//
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);

			if (rs.next()) {
				String dbpss = rs.getString("passWord");
				if (dbpss.equals(passWord)) {
					data.put("message", "Login is successfull");

					String dbname = rs.getObject("name").toString();
					String dbeducation = rs.getObject("education").toString();
					String dbuserName = rs.getObject("userName").toString();
					String dbdesignation = rs.getObject("designation").toString();
					String dbjoiningDate = rs.getObject("joiningDate").toString();

					detailsAdmin.put("name", dbname);
					detailsAdmin.put("education", dbeducation);
					detailsAdmin.put("userName", dbuserName);
					detailsAdmin.put("designation", dbdesignation);
					detailsAdmin.put("joiningDate", dbjoiningDate);
					
					while (rs1.next()) {

						Map<String, Object> student = new HashMap<>();

						String dbname1 = rs1.getObject("name").toString();
						String dbeducation1 = rs1.getObject("education").toString();
						String dbbranch1 = rs1.getObject("branch").toString();
						String dbuserName1 = rs1.getObject("userName").toString();
						String dbdesignation1 = rs1.getObject("designation").toString();
						String dbjoiningDate1 = rs1.getObject("joiningDate").toString();
						String dbroomNumber1 = rs1.getObject("roomNumber").toString();

						student.put("name", dbname1);
						student.put("education", dbeducation1);
						student.put("branch", dbbranch1);
						student.put("userName", dbuserName1);
						student.put("designation", dbdesignation1);
						student.put("joiningDate", dbjoiningDate1);
						student.put("roomNumber", dbroomNumber1);
						
						students.add(student);

					}

				}

			} else {

				data.put("message", "passWord is invalid");
			}
			st.close();
			con.close();
			st1.close();
			
			

		} catch (SQLException e) {
			error.put("code", e.getErrorCode());
			error.put("error", e.getMessage());
			e.printStackTrace();
		} catch (Exception e1) {
			error.put("code", "400");
			error.put("error", e1.getMessage());
			e1.printStackTrace();
		}

		data.put("yourDetails", detailsAdmin);
		data.put("studentsDetails", students);

		finalresponce.put("data", data);
		finalresponce.put("error", error);

		System.out.println("Wellcome to admin");
		return finalresponce;
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public Map<String, Object> student(HttpServletRequest request, HttpServletResponse response) {

		userName = request.getParameter("userName");
		passWord = request.getParameter("passWord");

		Map<String, Object> error = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> detailsStudents =new HashMap<String, Object>();

		String query = "SELECT * FROM student WHERE userName='" + userName + "';";

		try {
			Connection con = dbconn.getDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String dbpass = rs.getObject("passWord").toString();
				String dbName = rs.getObject("Name").toString();
				String dbEducation = rs.getObject("Education").toString();
				String dbbranch = rs.getObject("branch").toString();
				String dbuserName = rs.getObject("userName").toString();
				String dbdesignation= rs.getObject("designation").toString();
				String dbjoiningDate = rs.getObject("joiningDate").toString();
				String dbroomNumber = rs.getObject("roomNumber").toString();
				 

				if (dbpass.equals(passWord)) {

					detailsStudents.put("message", "Login is successfull");
					detailsStudents.put("Name", dbName);
					detailsStudents.put("Education", dbEducation);
					detailsStudents.put("branch", dbbranch);
					detailsStudents.put("userName", dbuserName);
					detailsStudents.put("designation", dbdesignation);
					detailsStudents.put("joiningDate", dbjoiningDate);
					detailsStudents.put("roomNumber", dbroomNumber);
					

				} else {

					data.put("message", "paaWord is invalid");
				}

			}
			st.close();
			con.close();

		} catch (SQLException e) {

			error.put("code", e.getErrorCode());
			error.put("error", error);
			e.printStackTrace();

		} catch (Exception e) {

			error.put("code", "400");
			error.put("error", error);

		}
		
        data.put("studentDetails", detailsStudents);
		finalresponce.put("data", data);
		finalresponce.put("error", error);

		System.out.println("Wellcome to student");
		return finalresponce;
	}
}
