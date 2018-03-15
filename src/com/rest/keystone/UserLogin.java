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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import java.sql.*;


@Path("/login")
public class UserLogin {
	
	@Path("{email}/{password}")
	@GET
	@Produces("text/plain")
	
	public void authenticateUser(@PathParam("email") String username, @PathParam("password") String password) throws SQLException
	{
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Virtualization", "root","sindhu");
		PreparedStatement statement = con.prepareStatement("select Password from User_Information where Username=?");
		statement.setString(1,username);
		ResultSet result = statement.executeQuery();
		result.next();
		if(password.equals(result.getString(1)))
	    {
			
			//String token= generateAdminToken.tokenGenerate();
			//System.out.println(token);
			
			
		}
				
		
	     }catch(Exception e)
	      {
		System.out.println(e);
	      }
		
		
	} 

}
