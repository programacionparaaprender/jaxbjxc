package com.programacionparaaprender.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Bharath");
			StringWriter writer = new StringWriter();
			//convertir objetos java a xml
			marshaller.marshal(patient, writer);
			System.out.println("convertir objetos java a xml");
			System.out.println(writer.toString());
			
			StringReader reader = new StringReader(writer.toString());		
			Unmarshaller unMarshaller = context.createUnmarshaller();
			Patient patientResult = (Patient)unMarshaller.unmarshal(reader);
			System.out.println("convertir objetos xml a java");
			System.out.println(patientResult.getName());
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
