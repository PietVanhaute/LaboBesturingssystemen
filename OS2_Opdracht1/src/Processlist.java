import java.util.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "processlist")
public class Processlist {
	private List<Process> processenLijst;
	
	public Processlist(){
		
	}
	
	public List<Process> getProcessenLijst() {
		return processenLijst;
	}
	
	@XmlElement(name = "process")
	public void setProcessenLijst(List<Process> processenLijst) {
		this.processenLijst = processenLijst;
	}

	public int getSize() {
		return processenLijst.size();
	}

	public void sortArrivalTime() {
		Collections.sort(processenLijst,(Process p1, Process p2) -> p1.getArrivaltime()-p2.getArrivaltime());
	}
	
	public void sortServiceTime() {
		Collections.sort(processenLijst,(Process p1, Process p2) -> p1.getServicetime()-p2.getServicetime());		
	}
	
	//Uitvoering van het FCFS algo
	public void voerFCFSUit() {
		//We beginnen bij het eerste proces
		int tijd=0;
		for(int i=0;i<processenLijst.size();i++){
			Process hulp = processenLijst.get(i);
			if( tijd < hulp.getArrivaltime()){
				tijd = hulp.getArrivaltime();
			}
			hulp.setWaittime(tijd-hulp.getArrivaltime());
			hulp.setEndtime(tijd+hulp.getServicetime());
			tijd+=hulp.getServicetime();
		}
	}

	public List<Process> verdeelLijst(int i, int aantalElementenPerPercentiel) {
		List<Process> deelLijst = processenLijst.subList(i*aantalElementenPerPercentiel, (i+1)*aantalElementenPerPercentiel-1);
		return deelLijst;
	}
	
}
