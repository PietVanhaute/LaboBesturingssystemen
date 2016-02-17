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
}
