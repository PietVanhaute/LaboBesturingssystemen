import java.util.*;

public class GlobalVarList {
	private List<GlobalVar> allePercentielen;
	private int averageRuntime, averageNorRuntime, averageWaittime;
	
	public GlobalVarList(){
		allePercentielen = new ArrayList<GlobalVar>();
		averageRuntime=0;
		averageNorRuntime=0; 
		averageWaittime=0;
	}

	public void verwerkGegevens(Processlist procList) {
		//Krijgt lijst met alle processen binnen gesorteerd volgens servicetime
		//Deze worden verdeeld in 100 clusters 
		//Daarna kunnen alle gegevens berekent worden voor de grafieken
		int aantalElementenPerPercentiel = (procList.getSize()+1)/100;
		GlobalVar hulp;
		for (int i = 1; i <= 100 ;i++){
			//Nieuw percentiel wordt aangemaakt
			hulp  = new GlobalVar(procList.verdeelLijst(i,aantalElementenPerPercentiel),i);
			allePercentielen.add(hulp);
		}
	}
}
