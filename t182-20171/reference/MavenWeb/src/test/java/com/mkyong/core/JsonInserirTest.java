package com.mkyong.core;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.unifor.arquitetura.entidades.Banda;
import br.unifor.arquitetura.entidades.BandaList;

public class JsonInserirTest {
	
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResourceJson = client
				.resource("http://localhost:8080/MavenWeb/rest/bandas");
		String inputJson = "{\"nome\": \"WS\",\"anoDeFormacao\": \"2010\"}";
		ClientResponse response = webResourceJson.type("application/json")
				.post(ClientResponse.class, inputJson);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		System.out.println("Output INSERIR from Server JSON .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
		

	}
}