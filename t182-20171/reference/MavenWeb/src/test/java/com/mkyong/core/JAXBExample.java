package com.mkyong.core;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.unifor.arquitetura.entidades.Banda;
import br.unifor.arquitetura.entidades.BandaList;

public class JAXBExample {
	public static void main(String[] args) {

	 try {

		File file = new File("D:\\Magnus\\testes\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(BandaList.class, Banda.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		BandaList customer = (BandaList) jaxbUnmarshaller.unmarshal(file);
		System.out.println(customer);

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}