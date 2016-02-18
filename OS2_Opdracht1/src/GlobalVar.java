import java.util.*;

public class GlobalVar {
	private List<Process> processenPercentiel;
	private int averageRuntime, averageNorRuntime, averageWaittime,percentielNummer;
	
	public GlobalVar(List<Process> lijst,int nummer){
		processenPercentiel = lijst;
		percentielNummer = nummer;
		initvar();
	}

	private void initvar() {
		//Kunnen ervan uitgaan dat de lijst volgens servicetime zijn gesorteerd
		averageNorRuntime=0;
		averageRuntime=0;
		averageWaittime=0;
		for(int i=0;i<processenPercentiel.size();i++){
			Process hulp = processenPercentiel.get(i);
			averageNorRuntime+=hulp.getNorRuntime();
			averageRuntime+=hulp.getRuntime();
			averageWaittime+=hulp.getWaittime();
		}
		averageNorRuntime=averageNorRuntime/processenPercentiel.size();
		averageRuntime=averageRuntime/processenPercentiel.size();
		averageWaittime=averageWaittime/processenPercentiel.size();
	}
}
