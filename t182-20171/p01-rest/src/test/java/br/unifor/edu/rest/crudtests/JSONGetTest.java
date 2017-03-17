package br.unifor.edu.rest.crudtests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JSONGetTest {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResourceJson = client.resource("http://localhost:8080/p01-rest/rest/funcionarios/" + 1);
		ClientResponse response = webResourceJson.type("application/json").get(ClientResponse.class);

		if (response.getStatus() < 200 || response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("GET result:");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}

}
