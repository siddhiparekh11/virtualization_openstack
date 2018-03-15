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

@Path("/keystone")
public class generateAdminToken {
	String admin_token;
	
	
	 @Path("/signin/{first}/{last}/{email}/{password}")
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
		System.out.println("Entered to databse");	
	     }catch(Exception e)
	      {
		System.out.println(e);
	      }
		
		
	}
	
	@Path("/login/{email}/{password}")
	@GET
	@Produces("text/plain")
	
	public String authenticateUser(@PathParam("email") String username, @PathParam("password") String password) throws SQLException
	{
		String token=null;
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Virtualization", "root","sindhu");
		PreparedStatement statement = con.prepareStatement("select Password from User_Information where Email_id=?");
		statement.setString(1,username);
		ResultSet result = statement.executeQuery();
		result.next();
		if(password.equals(result.getString(1)))
	    {
			token= tokenGenerate();
			
		}
				
		
	     }catch(Exception e)
	      {
		System.out.println(e);
	      }
		
		return token;
	} 
	
	
	@GET
	@Path("/token")
	@Produces("text/plain")
	public String tokenGenerate() throws Exception
	{
		String token=null;
		String Url="http://localhost:5000/v3/auth/tokens";
		HttpPost post = new HttpPost(Url);
		
		post.setHeader("accept", "application/json");
		post.setHeader("Content-Type","application/json");
		
		System.out.println("Control is at tokenGenerate");;
		
		try
		{
			 String requestBody= "{\"auth\": {\"identity\": {\"methods\": [\"password\"],\"password\": {\"user\": {\"domain\": {\"name\": \"default\"},\"name\": \"proj1\",\"password\": \"proj1\"}}}}}";//,\"scope\": {\"project\": {\"domain\": {\"name\": \"default\"},\"name\": \"admin\"}}}}";
				HttpClient httpClient1 = new DefaultHttpClient();
				StringEntity Entity = new StringEntity(requestBody);
				post.setEntity(Entity);
				HttpResponse response = httpClient1.execute(post);
				
				if(response.getStatusLine().getStatusCode()!=201) {
					throw new RuntimeException("Failed: HTTP error code :" 
				     + response.getStatusLine().getStatusCode());
				}

				 BufferedReader br1 = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
				 
				Header[] headers= response.getAllHeaders();
				
				/*for(Header header:headers)
				{
					System.out.println("Key:" + header.getName());
					System.out.println("Value:" + header.getValue());
				}*/
				
				
			for(Header header:headers)
				{
					if(header.getName().equals("X-Subject-Token"))
					{
						token=header.getValue();
					}
				}
				
				System.out.println(token);
				 String output1;
				   //System.out.println("\n Unformatted Output from the Server \n");
				   while ((output1 = br1.readLine()) != null) {
					//System.out.println(output1);
				   }
				   
				   httpClient1.getConnectionManager().shutdown();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//String result= String.format("Admin Token: %s", token);
		//return result;
		return token;
		
	}

	
	
	
}
