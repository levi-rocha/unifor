package br.unifor.edu.rest.resource;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.unifor.edu.rest.model.Funcionario;
import br.unifor.edu.rest.model.FuncionarioList;

@Path("/funcionarios")
public class FuncionariosResource {

	static private Map<Integer, Funcionario> funcionariosMap;

	static {
		funcionariosMap = new HashMap<Integer, Funcionario>();
		File file = new File("data.xml");
		if (!file.exists()) {
			// inicializar data.xml
			FuncionarioList list = new FuncionarioList();
			Funcionario f1 = new Funcionario();
			f1.setCdFuncionario(1);
			f1.setNome("joao funcionario");
			funcionariosMap.put(f1.getCdFuncionario(), f1);
			list.setFuncionarios(new ArrayList<Funcionario>());
			list.getFuncionarios().add(f1);
			Funcionario f2 = new Funcionario();
			f2.setCdFuncionario(2);
			f2.setNome("maria trabalhadora");
			funcionariosMap.put(f2.getCdFuncionario(), f2);
			list.getFuncionarios().add(f2);
			try {
				JAXBContext context = JAXBContext.newInstance(FuncionarioList.class, Funcionario.class);
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(list, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				JAXBContext context = JAXBContext.newInstance(FuncionarioList.class, Funcionario.class);
				Unmarshaller unmarshallher = context.createUnmarshaller();
				FuncionarioList data = (FuncionarioList) unmarshallher.unmarshal(file);
				List<Funcionario> funcionarios = data.getFuncionarios();
				for (Funcionario f : funcionarios) {
					funcionariosMap.put(f.getCdFuncionario(), f);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*
		 * funcionariosMap = new HashMap<Integer, Funcionario>(); Funcionario f1
		 * = new Funcionario(); f1.setCdFuncionario(1); f1.setNome("joao");
		 * funcionariosMap.put(f1.getCdFuncionario(), f1); Funcionario f2 = new
		 * Funcionario(); f2.setCdFuncionario(2); f2.setNome("jose");
		 * funcionariosMap.put(f2.getCdFuncionario(), f2);
		 */
	}

	@GET
	@Produces("text/xml")
	public List<Funcionario> getFuncionarios() {
		return new ArrayList<Funcionario>(funcionariosMap.values());
	}

	@Path("{id}")
	@GET
	@Produces("text/xml")
	public Funcionario findById(@PathParam("id") Integer cd) {
		return funcionariosMap.get(cd);
	}
	
	@Path("nome={id}")
	@GET
	@Produces("text/xml")
	public Funcionario findByNome(@PathParam("id") String cd) {
		Collection<Funcionario> values = funcionariosMap.values();
		Funcionario funcionarioRetorno = null;
		for (Funcionario funcionario : values) {
			if (funcionario.getNome().toLowerCase().indexOf(cd.toLowerCase())>-1) {
				funcionarioRetorno = funcionario;
				break;
			}
		}
		return funcionarioRetorno;
	}

	@POST
	@Consumes({ APPLICATION_XML, TEXT_XML, APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
	public Response insert(Funcionario funcionario) {
		try {
			File output = new File("data.xml");
			JAXBContext context = JAXBContext.newInstance(FuncionarioList.class, Funcionario.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Integer cd = funcionariosMap.keySet().size() + 1;
			funcionario.setCdFuncionario(cd);
			funcionariosMap.put(cd, funcionario);
			FuncionarioList data = new FuncionarioList();
			List<Funcionario> list = new ArrayList<Funcionario>();
			list.addAll(funcionariosMap.values());
			data.setFuncionarios(list);
			marshaller.marshal(data, output);
			marshaller.marshal(data, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(201).type(APPLICATION_JSON).entity(funcionario).build();
	}

	@Path("{id}")
	@DELETE
	@Produces({ APPLICATION_XML, APPLICATION_JSON })
	public Response remove(@PathParam("id") Integer cd) {
		Funcionario f = funcionariosMap.remove(cd);
		return Response.status(201).type(APPLICATION_JSON).entity(f).build();
	}

	@PUT
	@Consumes({ APPLICATION_XML, TEXT_XML, APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
	public Response update(Funcionario funcionario) {
		funcionariosMap.remove(funcionario.getCdFuncionario());
		try {
			File output = new File("data.xml");
			JAXBContext context = JAXBContext.newInstance(FuncionarioList.class, Funcionario.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			funcionariosMap.put(funcionario.getCdFuncionario(), funcionario);
			FuncionarioList data = new FuncionarioList();
			List<Funcionario> list = new ArrayList<Funcionario>();
			list.addAll(funcionariosMap.values());
			data.setFuncionarios(list);
			marshaller.marshal(data, output);
			marshaller.marshal(data, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(201).type(APPLICATION_JSON).entity(funcionario).build();
	}

}
