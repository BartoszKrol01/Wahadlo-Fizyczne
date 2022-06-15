package pl.edu.pw.fizyka.pojava;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SinusPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double amplituda = 0.5;
	double omega=0;
	double dt;
	
	
	PrawyPanel prawyPanel;
	
	XYSeries polozenie;
	XYSeries predkosc;
	XYSeries przyspieszenie;
	XYSeriesCollection xySeriesCollection;
	XYDataset xyDataSet;
	JFreeChart wykresy;
	
	ChartPanel chartPanel;
	
	String tytulSinusPanelString = "Przebieg sinusoidalny w funkcji czasu";
	String osXString = "t[s]";
	
	public SinusPanel()
	{
		polozenie = new XYSeries("x(t)");
		predkosc = new XYSeries("v(t)");
		przyspieszenie = new XYSeries("a(t)");
		xySeriesCollection = new XYSeriesCollection();
		xyDataSet = xySeriesCollection;
		
		wykresy = ChartFactory.createXYLineChart 
                (tytulSinusPanelString,  // Title 
                  osXString,           // X-Axis label 
                  "",           // Y-Axis label 
                  xyDataSet,          // Dataset 
                  PlotOrientation.VERTICAL,        //Plot orientation 
                  true,                //show legend 
                  true,                // Show tooltips 
                  false               //url show 
                 ); 
		
		chartPanel = new ChartPanel(wykresy);
	}
	
	public void edytujSeriePolozenie(boolean pokaz)
	{
			
			if(pokaz)
			{
				xySeriesCollection.addSeries(polozenie);
				prawyPanel.setPokazPolozenie(false);
			}
			else
			{
				xySeriesCollection.removeSeries(polozenie);
				prawyPanel.setPokazPolozenie(true);
			}
		
	}
	
	public void edytujSeriePredkosc(boolean pokaz)
	{
		if(pokaz)
		{
			xySeriesCollection.addSeries(predkosc);
			prawyPanel.setPokazPredkosc(false);
		}
		else
		{
			xySeriesCollection.removeSeries(predkosc);
			prawyPanel.setPokazPredkosc(true);
		}
	}
	
	public void edytujSeriePrzyspieszenie(boolean pokaz)
	{
		if(pokaz)
		{
			xySeriesCollection.addSeries(przyspieszenie);
			prawyPanel.setPokazPrzyspieszenie(false);
		}
		else
		{
			xySeriesCollection.removeSeries(przyspieszenie);
			prawyPanel.setPokazPrzyspieszenie(true);
		}
	}

	@Override
	public void run() {
		
		while(true)
		{
			polozenie.add(dt,amplituda * Math.sin(omega * dt));
			predkosc.add(dt,amplituda * omega * Math.cos(omega * dt));
			przyspieszenie.add(dt,-1* amplituda * omega * omega * Math.sin(omega * dt));
			dt = dt + 0.01;
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	public PrawyPanel getPrawyPanel() {
		return prawyPanel;
	}

	public void setPrawyPanel(PrawyPanel prawyPanel) {
		this.prawyPanel = prawyPanel;
	}
	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}

	public double getOmega() {
		return omega;
	}

	public void setOmega(double omega) {
		this.omega = omega;
	}

}
