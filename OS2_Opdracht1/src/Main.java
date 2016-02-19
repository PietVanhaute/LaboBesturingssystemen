import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
			procList.sortArrivalTime();
			//Lijst met alle gegevens van de verschillende algoritmen
			List<GlobalVarList> gegevensAlleAlgo = verwerkGegevens(procList);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static List<GlobalVarList> verwerkGegevens(Processlist procList) {
		//Lijst waarin alle algoritmes kunnen komen
		GlobalVarList hulp;
		List<GlobalVarList> gegevensAlleAlgo = new ArrayList<GlobalVarList>();
		for(int i=0;i<9;i++){
			hulp = new GlobalVarList();
			switch(i){
			case 0: 
				procList.voerFCFSUit();
				System.out.println("FCFS is uitgevoerd");
				break;
			//case 1 : procList.voerRR2Uit(); ...
			}
			procList.sortServiceTime();
			hulp.verwerkGegevens(procList);
			System.out.println("Gegevens zijn verwerkt");
			gegevensAlleAlgo.add(hulp);
			System.out.println("Gegevens zijn toegevoegd aan de lijst");
		}
		return gegevensAlleAlgo;
	}
}
