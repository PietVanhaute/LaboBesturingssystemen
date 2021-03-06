import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jfree.ui.RefineryUtilities;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("processen10000.xml");
//			File file = new File("C:\\Users\\Pieter-Jan\\Documents\\workspace\\OS2_Opdracht1\\test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Processlist.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Processlist procList = (Processlist) jaxbUnmarshaller.unmarshal(file);
			System.out.println(procList);
			procList.sortArrivalTime();
			//Lijst met alle gegevens van de verschillende algoritmen
			List<GlobalVarList> gegevensAlleAlgoritmen = verwerkGegevens(procList);
			maakGrafiek(gegevensAlleAlgoritmen);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static void maakGrafiek(List<GlobalVarList> gegevensAlleAlgoritmen) {
		LineChart_AWT chart = new LineChart_AWT("Scheduling Algortimes" ,"Scheduling Algoritmes",gegevensAlleAlgoritmen);
		chart.pack( );
		RefineryUtilities.centerFrameOnScreen( chart );
		chart.setVisible( true );
		
	}

	private static List<GlobalVarList> verwerkGegevens(Processlist procList) {
		//Lijst waarin alle algoritmes kunnen komen
		GlobalVarList hulp;
		List<GlobalVarList> gegevensAlleAlgo = new ArrayList<GlobalVarList>();
		for(int i=0;i<1;i++){
			hulp = new GlobalVarList();
			switch(i){
			case 0: 
				procList.voerFCFSUit();
				System.out.println("FCFS is uitgevoerd");
				hulp.setAlgoritmeNaam("FCFS");
				break;
			//case 1 : procList.voerRR2Uit(); ...
			}
			procList.sortServiceTime();
			hulp.verwerkGegevens(procList);
			System.out.println("Gegevens zijn verwerkt");
			gegevensAlleAlgo.add(hulp);
			System.out.println("Gegevens zijn toegevoegd aan de lijst");
			//System.out.println(gegevensAlleAlgo.get(0).getSize());
		}
		return gegevensAlleAlgo;
	}
}
