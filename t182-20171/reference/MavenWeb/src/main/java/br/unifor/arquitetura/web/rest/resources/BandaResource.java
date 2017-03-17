package br.unifor.arquitetura.web.rest.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.unifor.arquitetura.entidades.Banda;
import br.unifor.arquitetura.entidades.BandaList;

@Path("/bandas")
public class BandaResource { // vamos utilizar um Map est�tico para
	// "simular" uma base de dados
	static private Map<Integer, Banda> bandasMap = new HashMap<Integer, Banda>();

	static {
		bandasMap = new HashMap<Integer, Banda>();
		File file = new File("D:\\Magnus\\testes\\file.xml");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(BandaList.class, Banda.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BandaList customer = (BandaList) jaxbUnmarshaller.unmarshal(file);
			List<Banda> bandas = customer.getBandas();
			for (Banda banda : bandas) {
				bandasMap.put(banda.getId(), banda);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Banda b1 = new Banda();
		// b1.setId(1);
		// b1.setNome("Led Zeppelin");
		// b1.setAnoDeFormacao(1968);
		// bandasMap.put(b1.getId(), b1);
		// Banda b2 = new Banda();
		// b2.setId(2);
		// b2.setNome("AC/DC");
		// b2.setAnoDeFormacao(1973);
		// bandasMap.put(b2.getId(), b2);
	}// ...

	@GET
	@Produces("text/xml")
	public List<Banda> getBandas() {
		return new ArrayList<Banda>(bandasMap.values());
	} // continua depois ...

	@Path("{id}")
	@GET
	@Produces("text/xml")
	public Banda findById(@PathParam("id") Integer id) {
		return bandasMap.get(id);
	}

	@POST
	@Consumes({ APPLICATION_XML, TEXT_XML, APPLICATION_JSON })
	@Produces({APPLICATION_JSON})
	public Response inserir(Banda banda) {
		try {

			File file = new File("D:\\Magnus\\testes\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BandaList.class, Banda.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Integer id  = bandasMap.keySet().size()+1;
			banda.setId(id);
			bandasMap.put(id, banda);
			BandaList bandaList = new BandaList();
			ArrayList<Banda> arrayList = new ArrayList<Banda>();
			arrayList.addAll(bandasMap.values());
			bandaList.setBandas(arrayList);
			jaxbMarshaller.marshal(bandaList, file);
			jaxbMarshaller.marshal(bandaList, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return Response.status(201).type(APPLICATION_JSON).entity(banda)
				.build();
	}

	@Path("{id}")
	@DELETE
	@Produces({ APPLICATION_XML, APPLICATION_JSON })
	public Response remover(@PathParam("id") Integer id) {
		Banda banda = bandasMap.remove(id);
		return Response.status(201).type(APPLICATION_JSON).entity(banda)
				.build();

	}

}
