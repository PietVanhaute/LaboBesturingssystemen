import java.util.*;

public class GlobalVarList {
	private List<GlobalVar> allePercentielen;
	private int averageTotRuntime, averageTotNorRuntime, averageTotWaittime;
	private String algoritmeNaam;

	public GlobalVarList(){
		allePercentielen = new ArrayList<GlobalVar>();
		averageTotRuntime=0;
		averageTotNorRuntime=0; 
		averageTotWaittime=0;
	}
	
	public String getAlgoritmeNaam() {
		return algoritmeNaam;
	}

	public void setAlgoritmeNaam(String algoritmeNaam) {
		this.algoritmeNaam = algoritmeNaam;
	}
	
	public List<GlobalVar> getAllePercentielen() {
		return allePercentielen;
	}

	public void setAllePercentielen(List<GlobalVar> allePercentielen) {
		this.allePercentielen = allePercentielen;
	}

	public int getAverageTotRuntime() {
		return averageTotRuntime;
	}

	public void setAverageTotRuntime(int averageRuntime) {
		this.averageTotRuntime = averageRuntime;
	}

	public int getAverageTotNorRuntime() {
		return averageTotNorRuntime;
	}

	public void setAverageTotNorRuntime(int averageNorRuntime) {
		this.averageTotNorRuntime = averageNorRuntime;
	}

	public int getAverageTotWaittime() {
		return averageTotWaittime;
	}

	public void setAverageTotWaittime(int averageWaittime) {
		this.averageTotWaittime = averageWaittime;
	}

	public void verwerkGegevens(Processlist procList) {
		//Krijgt lijst met alle processen binnen gesorteerd volgens servicetime
		//Deze worden verdeeld in 100 clusters 
		//Daarna kunnen alle gegevens berekent worden voor de grafieken
		int aantalElementenPerPercentiel = (procList.getSize()+1)/100;
		GlobalVar hulp;
		for (int i = 0; i < 100 ;i++){
			//Nieuw percentiel wordt aangemaakt
			hulp  = new GlobalVar(procList.verdeelLijst(i,aantalElementenPerPercentiel),i);
			allePercentielen.add(hulp);
		}
		for(int i = 0;i<100;i++){
			GlobalVar hulpGlobal = allePercentielen.get(i);
			averageTotNorRuntime+=hulpGlobal.getAverageNorRuntime();
			averageTotRuntime+=hulpGlobal.getAverageRuntime();
			averageTotWaittime+=hulpGlobal.getAverageWaittime();
		}
		averageTotNorRuntime=averageTotNorRuntime/100;
		averageTotRuntime=averageTotRuntime/100;
		averageTotWaittime=averageTotWaittime/100;
	}

	public int getSize() {
		return allePercentielen.size();
	}

	public GlobalVar getPercentiel(int j) {
		return allePercentielen.get(j);
	}
}
