package br.metodista.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.jboss.security.authorization.resources.WebResource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.security.ntlm.Client;

import br.metodista.modelo.Filme;

@ManagedBean
public class CinemaMB {
	public List<Filme> getFilmesEmCartaz() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/CinemaREST/servico/filmes");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Filme>>() {
		}.getType());
	}
}