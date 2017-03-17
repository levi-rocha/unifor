package com.mkyong.core;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.unifor.arquitetura.entidades.Banda;
import br.unifor.arquitetura.entidades.BandaList;

public class JAXBWriter {
	public static void main(String[] args) {
		Banda b1 = new Banda();
		b1.setId(1);
		b1.setNome("Led Zeppelin");
		b1.setAnoDeFormacao(1968);
		Banda b2 = new Banda();
		b2.setId(2);
		b2.setNome("AC/DC");
		b2.setAnoDeFormacao(1973);
		BandaList bandaList = new BandaList();
		ArrayList<Banda> arrayList = new ArrayList<Banda>();
		arrayList.add(b1);
		arrayList.add(b2);
		bandaList.setBandas(arrayList);
		try {

			File file = new File("D:\\Magnus\\testes\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BandaList.class, Banda.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(bandaList, file);
			jaxbMarshaller.marshal(bandaList, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}