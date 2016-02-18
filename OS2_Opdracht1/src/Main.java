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
			procList.sortArrivalTime();
			verwerkGegevens(procList);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static void verwerkGegevens(Processlist procList) {
		//Lijst waarin alle algoritmes kunnen komen
		GlobalVarList hulp = new GlobalVarList();
		for(int i=0;i<9;i++){
			switch(i){
			case 0: 
				procList.voerFCFSUit();
				System.out.println("FCFS is uitgevoerd");
				procList.sortServiceTime();
				hulp.verwerkGegevens(procList);
				System.out.println("Gegevens zijn verwerkt");
				break;
			//case 1 : procList.voerRR2Uit(); ...
			}
		}
		
	}
}
