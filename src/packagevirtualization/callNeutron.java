package packagevirtualization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Path("/callneutron")
public class callNeutron {

	static String netid;
	static String routerid;
	static int routerCount=0;
	static String AUTH_TOKEN_URL="http://localhost:8080/AdminTokenAPI/admintoken/keystone/token";
	@Path("/getnetwid")
	@GET
	@Produces("text/html")
	public String getNetworkID() 
	{
		
		String xAuthToken=getAuthToken();
		try{
			
			Class1 c= new Class1(xAuthToken);
			final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
			ObjectReader objectReader = OBJECT_MAPPER.reader(Example.class);
			Example ex =
			    objectReader.readValue(Class1.result);
			String networkStr = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(ex);
			netid=ex.getNetwork().getId();
			if(routerCount==0)
			{
			   routerCount++;
			   routerid=c.createRouter("VRouter" + Integer.toString(routerCount));
			}
			c.createRouterInterface(routerid,c.createSubnet(netid));
			
			return netid;
			
			

				
			}catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	    }
	}
	private String getAuthToken() {
		try {
		Client client =  ClientBuilder.newClient();
		Response res = client.target(AUTH_TOKEN_URL).request("text/plain").get();
			
			String response = res.getEntity().toString();
			System.out.println("Response obtained from Keystone API - " + response);
			
			return response;
			
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occurred calling Auth Token API");
			return null;
		}		
	}
}
	

