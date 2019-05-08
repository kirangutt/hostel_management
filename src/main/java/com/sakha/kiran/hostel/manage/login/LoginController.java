package com.sakha.kiran.hostel.manage.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
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

		String query = "SELECT * FROM warden WHERE userName='" + userName + "';";

		try {
			Connection con = dbconn.getDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("ResultSet:" + rs);

			while (rs.next()) {

				String dbPassword = rs.getObject("passWord").toString();

				if (dbPassword.equals(passWord)) {
					data.put("message", "Login is Successfull");

				} else {
					data.put("message", "Password is Invalid");
				}
			}

		} catch (SQLException e) {
			error.put("code", e.getErrorCode());
			error.put("error", e.getMessage());
			e.printStackTrace();
		} catch (Exception e1) {
			error.put("code", "400");
			error.put("error", e1.getMessage());
			e1.printStackTrace();
		}

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

		String query = "SELECT * FROM admin WHERE userName='" + userName + "'";

		try {

			Connection con = dbconn.getDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				String dbpss = rs.getObject("passWord").toString();

				if (dbpss.equals(passWord)) {

					data.put("message", "Login is successfull");

				} else {

					data.put("message", "passWord is invalid");
				}

			}

		} catch (SQLException e) {
			error.put("code", e.getErrorCode());
			error.put("error", e.getMessage());
			e.printStackTrace();
		} catch (Exception e1) {
			error.put("code", "400");
			error.put("error", e1.getMessage());
			e1.printStackTrace();
		}

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

		String query = "SELECT * FROM student WHERE userName='" + userName + "';";

		try {
			Connection con = dbconn.getDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String dbconn = rs.getObject("passWord").toString();

				if (dbconn.equals(passWord)) {

					data.put("message", "Login is successfull");

				} else {

					data.put("message", "paaWord is invalid");
				}

			}

		} catch (SQLException e) {
			
			error.put("code", e.getErrorCode());
			error.put("error", error);
			e.printStackTrace();
		
		}catch (Exception e) {
			
			error.put("code", "400");
			error.put("error", error);
			
		}
		
		finalresponce.put("data", data);
		finalresponce.put("error", error);

		System.out.println("Wellcome to student");
		return finalresponce;
	}
}
