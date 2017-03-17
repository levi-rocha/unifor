package br.unifor.edu.rest;
import java.io.File;

import javax.ws.rs.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.unifor.edu.rest.model.Funcionario;


public class FuncionarioXMLGenerator extends XMLGenerator {

  @Override
  public void generateXML(Object element, File output) {

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Funcionario.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      
      jaxbMarshaller.marshal(element, output);
      jaxbMarshaller.marshal(element, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
