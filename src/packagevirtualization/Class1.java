package packagevirtualization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;



public class Class1 {
	
	static String payload;
	static String requestUrl;
	static int count=0;
	static String token;
	
   static String result;
    
    public Class1(String token)
    {
    	count=count+1;
    	payload="{\"network\":{\"name\":\"network" + Integer.toString(count) + "\",\"admin_state_up\":\"true\"}}";
    	requestUrl="http://127.0.0.1:9696/v2.0/networks.json";
    	this.token=token;
    	result=createNetwork(requestUrl, payload);
    	
    }
	
	public static String createNetwork(String requesturi, String payLoad)
	{
		try {
	        URL url = new URL(requesturi);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        connection.setRequestProperty("X-Auth-Token", token);
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write(payLoad);
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuffer jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	        return jsonString.toString();
	    } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	    }
		
		
	}
	
	public static String createSubnet(String networkid)
	{
		String subnetid=null;
		String cdr=null;
		
		if(count==1)
		{
		    cdr="10.10.10.0/24";	
		}
		else if(count>1)
		{
			cdr="20.20.20.0/24";
		}
		
		try {
	        URL url = new URL("http://127.0.0.1:9696/v2.0/subnets.json");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        connection.setRequestProperty("X-Auth-Token", token);
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write("{\"subnet\":{\"network_id\":\"" + networkid + "\",\"ip_version\":\"4\",\"cidr\":\"" + cdr +"\"}}");
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuffer jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	        final ObjectMapper OBJECT_MAPPER1 = new ObjectMapper();
			ObjectReader objectReader = OBJECT_MAPPER1.reader(Example1.class);
			Example1 ex1 =
			    objectReader.readValue(jsonString.toString());
	       subnetid=ex1.getSubnet().getId();
	        return subnetid;
	    } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	    }
		
		
	}
	public static String createRouter(String routerName)
	{
		String routerid=null;
		try {
	        URL url = new URL("http://127.0.0.1:9696/v2.0/routers.json");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        connection.setRequestProperty("X-Auth-Token", token);
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write("{\"router\":{\"name\":\"" + routerName + "\",\"admin_state_up\":\"true\"}}");
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuffer jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	        final ObjectMapper OBJECT_MAPPER2 = new ObjectMapper();
			ObjectReader objectReader = OBJECT_MAPPER2.reader(Example2.class);
			Example2 ex2 =
			    objectReader.readValue(jsonString.toString());
			routerid=ex2.getRouter().getId();
	       // return jsonString.toString(); parsing logic is still left to code
	        return routerid;
	    } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	    }
		
	}
	public static void createRouterInterface(String routerId,String subnetId)
	{
		try {
	        URL url = new URL("http://127.0.0.1:9696/v2.0/routers/" + routerId + "/add_router_interface.json");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("PUT");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        connection.setRequestProperty("X-Auth-Token", token);
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write("{\"subnet_id\": \""+ subnetId + "\"}");
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuffer jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	        final ObjectMapper OBJECT_MAPPER3 = new ObjectMapper();
			ObjectReader objectReader = OBJECT_MAPPER3.reader(Example3.class);
			Example3 ex3 =
			    objectReader.readValue(jsonString.toString());
			
	       // return jsonString.toString(); parsing logic is still left to code
	       
	    } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	    }
		
		
	}
	

}
