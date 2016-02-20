import org.jfree.chart.ChartPanel;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {
	public LineChart_AWT(String applicationTitle, String chartTitle, List<GlobalVarList> gegevensAlleAlgoritmen) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Gemiddelde ServiceTime", "Normalised TAT", createDataset(gegevensAlleAlgoritmen),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private DefaultCategoryDataset createDataset(List<GlobalVarList> gegevensAlleAlgoritmen) {
		//Lijst met alle gegevens van alle algoritmen worden aangeboden
		//Moeten dus verschillende lijnen maken voor alle objecten in de lijst apart
		//Miss best doen in een dubbele for één voor de lijst te doorlopen en de tweede voor data te adden
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<gegevensAlleAlgoritmen.size();i++){
			//één dataset van alle algoritmes is geselecteerd
			GlobalVarList data = gegevensAlleAlgoritmen.get(i);
			for(int j = 0;j<data.getSize();j++){
				GlobalVar percentiel = data.getPercentiel(j);
				dataset.addValue(percentiel.getAverageNorRuntime(),data.getAlgoritmeNaam(),new String(percentiel.getAverageServiceTime()+""));
			}
		}
		return dataset;
	}
}