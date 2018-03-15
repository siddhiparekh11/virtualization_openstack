package com.sjsu;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/create-server")
public class CreateServer {
	
	
	private static String IMAGE_REF_ID = "5854ed58-2de0-492d-9ed3-a89215388e71";
	private static String FLAVOR_REF = "1";
	
	private static String AUTH_TOKEN_URL = "http://localhost:8080/OpenstackProject/admintoken/keystone/token";
	private static String NEUTRON_URL = "http://localhost:8080/OpenstackProject/neutron/callneutron/getnetwid";
	
	private static String NOVA_REST_API_HOST = "http://localhost:8774/v2.1";
	

	@GET
	public Response createServer(@QueryParam("servername") String serverName, @QueryParam("networkid") String networkId) {
		
		// Accept the parameters and print it
		System.out.println("Server Name passed via Get Query paramater - " + serverName);
		System.out.println("Network Id passed via Get Query parameter -" + networkId);
		
		// TODO Later - Call Auth Token API to get the X-Subject-Header or appropriate auth token
		// for now we have 
		String authToken = "";//"gAAAAABYPnGZsU7PfyzDYEHfdKlWQciOejczXod24DTv92tS-46keaDcg2OOAoXsBQN3ZdXIGsx2CPWcP2Yct46ELm6VEFdAz-12A2QFMJ5k3lhA8myRH8-5jlw2vPTaODv6yDjGnlB5VR-qSG9BEFHYipPnbvQSMrspTssMOeK2WVRLhsNYhqo";

		try {
			serverName = "Computer Instance";
			networkId = getNetworkId();
			authToken = getAuthToken();
			
			Client client = Client.create();
			
			WebResource webResource = client.resource(NOVA_REST_API_HOST + "/servers");
			
			JSONObject postBody = getPostBody(serverName, networkId);

			System.out.println("Calling Nova API at " + NOVA_REST_API_HOST + "/servers");
			System.out.println("Calling Nova Method with " + postBody.toString());
			
			ClientResponse novaResponse = webResource.header("X-Auth-Token", authToken)
					.header("Content-Type", "application/json")
					.post(ClientResponse.class, postBody.toString());
			
			return Response.status(novaResponse.getStatus()).entity(novaResponse.getEntity(String.class)).build();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server Error Occurred").build();
		}
		
	}
	
	
	private JSONObject getPostBody(String serverName, String networkId) {
		
		JSONObject instanceDetails = new JSONObject();
		instanceDetails.put("name", serverName);
				instanceDetails.put("imageRef", IMAGE_REF_ID);
		instanceDetails.put("flavorRef", FLAVOR_REF);
		instanceDetails.put("availability_zone", "nova");
		
		JSONObject networkUUId = new JSONObject();
		networkUUId.put("uuid", networkId);

		JSONObject securityGroup = new JSONObject();
		securityGroup.put("name", "default");
		
		JSONArray networkArray = new JSONArray();
		networkArray.put(networkUUId);
		instanceDetails.put("networks", networkArray);
		
		JSONArray securityGroupArray = new JSONArray();
		securityGroupArray.put(securityGroup);
		instanceDetails.put("security_groups", securityGroupArray);
		
		JSONObject postBody = new JSONObject();
		postBody.put("server", instanceDetails);	
		
		return postBody;
	}
	
	/**
	 * This method is used to get the token id from the Auth REST API we have implemented 
	 * @return
	 */
	private String getAuthToken() {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(AUTH_TOKEN_URL);
			System.out.println("Calling Keystone API at " + AUTH_TOKEN_URL);
			
			ClientResponse authTokenResponse = webResource.get(ClientResponse.class);
			
			System.out.println("Response Status obtained from Keystone API - " + authTokenResponse.getStatus());
			String response = authTokenResponse.getEntity(String.class);
			System.out.println("Response obtained from Keystone API - " + response);
			
			return response;
			
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occurred calling Auth Token API");
			return null;
		}		
	}
	
	/**
	 * This method is used to get the Network Id from the Neutron REST API which we have implemented
	 * @return
	 */
	private String getNetworkId() {
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(NEUTRON_URL);
			System.out.println("Calling Neutron API at " + NEUTRON_URL);
			
			ClientResponse authTokenResponse = webResource.get(ClientResponse.class);
			
			System.out.println("Response Status obtained from Neutron API - " + authTokenResponse.getStatus());
			String response = authTokenResponse.getEntity(String.class);
			System.out.println("Response obtained from Neutron API - " + response);
			
			return response;
			
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occurred calling Auth Token API");
			return null;
		}	
	}
	
	public static void main(String p[]) {
		
		JSONObject instanceDetails = new JSONObject();
		instanceDetails.put("name", "Anything");
		instanceDetails.put("imageRef", IMAGE_REF_ID);
		instanceDetails.put("flavorRef", "1");
		instanceDetails.put("availability_zone", "nova");
		
		JSONObject networkId = new JSONObject();
		networkId.put("uuid", "network-id");

		JSONObject securityGroup = new JSONObject();
		securityGroup.put("name", "default");
		
		JSONArray networkArray = new JSONArray();
		networkArray.put(networkId);
		instanceDetails.put("networks", networkArray);
		
		JSONArray securityGroupArray = new JSONArray();
		securityGroupArray.put(securityGroup);
		instanceDetails.put("security_groups", securityGroupArray);
		
		JSONObject postBody = new JSONObject();
		postBody.put("server", instanceDetails);
		
		System.out.println("JSON OBJECT CREATED = " + postBody);
		
		
		
	}
}
