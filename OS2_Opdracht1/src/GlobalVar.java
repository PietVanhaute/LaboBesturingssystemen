import java.util.*;

public class GlobalVar {
	private List<Process> processenPercentiel;
	private int averageRuntime, averageNorRuntime, averageWaittime,percentielNummer,averageServiceTime;
	
	public GlobalVar(List<Process> lijst,int nummer){
		processenPercentiel = lijst;
		percentielNummer = nummer;
		initvar();
	}

	public List<Process> getProcessenPercentiel() {
		return processenPercentiel;
	}

	public void setProcessenPercentiel(List<Process> processenPercentiel) {
		this.processenPercentiel = processenPercentiel;
	}

	public int getAverageRuntime() {
		return averageRuntime;
	}

	public void setAverageRuntime(int averageRuntime) {
		this.averageRuntime = averageRuntime;
	}

	public int getAverageNorRuntime() {
		return averageNorRuntime;
	}

	public void setAverageNorRuntime(int averageNorRuntime) {
		this.averageNorRuntime = averageNorRuntime;
	}

	public int getAverageWaittime() {
		return averageWaittime;
	}

	public void setAverageWaittime(int averageWaittime) {
		this.averageWaittime = averageWaittime;
	}

	public int getPercentielNummer() {
		return percentielNummer;
	}

	public void setPercentielNummer(int percentielNummer) {
		this.percentielNummer = percentielNummer;
	}

	private void initvar() {
		//Kunnen ervan uitgaan dat de lijst volgens servicetime zijn gesorteerd
		averageNorRuntime=0;
		averageRuntime=0;
		averageWaittime=0;
		averageServiceTime=0;
		for(int i=0;i<processenPercentiel.size();i++){
			Process hulp = processenPercentiel.get(i);
			averageNorRuntime+=hulp.getNorRuntime();
			averageRuntime+=hulp.getRuntime();
			averageWaittime+=hulp.getWaittime();
			averageServiceTime+=hulp.getServicetime();
		}
		averageNorRuntime=averageNorRuntime/processenPercentiel.size();
		averageRuntime=averageRuntime/processenPercentiel.size();
		averageWaittime=averageWaittime/processenPercentiel.size();
		averageServiceTime=averageServiceTime/processenPercentiel.size();
	}

	public int getAverageServiceTime() {
		return averageServiceTime;
	}

	public void setAverageServiceTime(int averageServiceTime) {
		this.averageServiceTime = averageServiceTime;
	}
}
