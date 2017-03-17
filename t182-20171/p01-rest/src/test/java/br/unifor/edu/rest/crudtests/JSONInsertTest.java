package br.unifor.edu.rest.crudtests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JSONInsertTest {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResourceJson = client.resource("http://localhost:8080/p01-rest/rest/funcionarios");
		String inputJson = "{\"nome\": \"inserido da silva\"}";
		ClientResponse response = webResourceJson.type("application/json").post(ClientResponse.class, inputJson);

		if (response.getStatus() < 200 || response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("INSERT result: ");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}

}
