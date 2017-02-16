package test.com.Test3;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class TestClient {

	private static String serverUri = "http://localhost:8080/Test3Project1/rest/Storage";
	
	public static void main(String[] args){
		testCreateLUN();
		testremoveLUN();
		testgetStorageInfo();
	}
	
	private static void testCreateLUN(){
		ClientConfig config = new DefaultClientConfig(); 
		Client client = Client.create(config);
		WebResource service = client.resource(serverUri).path("createLUN");
		ClientResponse response = service.get(ClientResponse.class);
		if (response.getStatus() != 200) {
	        throw new RuntimeException("testCreateLUN Failed, HTTP error code is: " + response.getStatus());
	    }
		
		String output = response.getEntity(String.class);
		System.out.println("Output from server is:  " + output);
	}
	
    private static void testremoveLUN(){
    	ClientConfig config = new DefaultClientConfig(); 
		Client client = Client.create(config);
		String LUNNumber = "3";
		WebResource service = client.resource(serverUri).path("removeLUN/" + LUNNumber);
		ClientResponse response = service.get(ClientResponse.class);
		if (response.getStatus() != 200) {
	        throw new RuntimeException("testremoveLUN Failed, HTTP error code is: " + response.getStatus());
	    }
		
		String output = response.getEntity(String.class);
		System.out.println("Output from server is:  " + output);
	}

    private static void testgetStorageInfo(){
    	ClientConfig config = new DefaultClientConfig(); 
		Client client = Client.create(config);
		WebResource service = client.resource(serverUri).path("getStorageInfo");
		ClientResponse response = service.get(ClientResponse.class);
		if (response.getStatus() != 200) {
	        throw new RuntimeException("testgetStorageInfo Failed, HTTP error code is: " + response.getStatus());
	    }
		
		String output = response.getEntity(String.class);
		System.out.println("Output from server is:  " + output);
    }
	
    
}
