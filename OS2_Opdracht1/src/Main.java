import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Pieter-Jan\\Documents\\workspace\\OS2_Opdracht1\\processen10000.xml");
//			File file = new File("C:\\Users\\Pieter-Jan\\Documents\\workspace\\OS2_Opdracht1\\test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Processlist.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Processlist procList = (Processlist) jaxbUnmarshaller.unmarshal(file);
			System.out.println(procList);
			System.out.println(procList.getProcessenLijst().get(6).getArrivaltime());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
