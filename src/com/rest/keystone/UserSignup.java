package com.rest.keystone;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import java.sql.*;

@Path("/signup")
public class UserSignup {
	
	 @Path("/signup/{first}/{last}/{email}/{password}")
	 @GET
	 @Produces("text/plain")
	public void createUser(@PathParam ("first") String firstname, @PathParam("last") String lastname, @PathParam("email") String username, @PathParam("password") String password) throws SQLException
	{
		try{
		System.out.println("Entered function");	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Virtualization", "root","sindhu");
		PreparedStatement statement = con.prepareStatement("INSERT INTO User_Information VALUES (?,?,?,?)");
		statement.setString(1,firstname);
		statement.setString(2, lastname);
		statement.setString(3,username);
		statement.setString(4, password);
		int result = statement.executeUpdate();
		
		System.out.println("Entered to databse and user created");	
	     }catch(Exception e)
	      {
		System.out.println(e);
	      }

	}
}
