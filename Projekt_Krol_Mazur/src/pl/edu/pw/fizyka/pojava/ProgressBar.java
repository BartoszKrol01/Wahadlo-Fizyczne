package pl.edu.pw.fizyka.pojava;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;




public class ProgressBar extends JPanel implements Runnable {
	

	private static final long serialVersionUID = 1L;

	String energiaKinetycznaString = "Energia kinetyczna";
	String energiaPotencjalnaString = "Energia potencjalna";
	JProgressBar EK;
	JProgressBar EP;
	JLabel labelEK=new JLabel(energiaKinetycznaString);
	JLabel labelEP=new JLabel(energiaPotencjalnaString);
	int counterEP=0;
	int counterEK=100;
	int wych;
	AnimacjaWahadlaPanel panel;
	int omega;
	
	public AnimacjaWahadlaPanel getPanel() {
		return panel;
	}


	public void setPanel(AnimacjaWahadlaPanel panel) {
		this.panel = panel;
	}


	public ProgressBar() {
		
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);
	
		setPreferredSize(new Dimension(200,80));
		panel=new AnimacjaWahadlaPanel();
		EK= new JProgressBar(0,100);
		EP= new JProgressBar(0,100);
		
		EK.setValue(100);
		EP.setValue(0);
		EP.setPreferredSize(new Dimension(100,100));
		EK.setPreferredSize(new Dimension(100,100));
		

		this.add(labelEK);
		this.add(EK);
		this.add(labelEP);
		this.add(EP);

		
	}
	

	@Override
	public void run() {

		while(true) {
	
			
			while(wych<=100)
			{
				
				wych=(int)(200*panel.getWychylenie());
				

				EP.setValue(Math.abs(wych));
				
				
				EK.setValue(100-EP.getValue());
				
				
				
				try {
					Thread.sleep((long)(5*Math.PI/(panel.omega))); //5 PI/omega
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
			
			
			while(wych<=100)
			{
				
				
				
				wych=(int)(200*panel.getWychylenie());
				System.out.println(wych);
				EP.setValue(Math.abs(wych));
				EK.setValue(100-EP.getValue());
				try {
					Thread.sleep((long)(5*Math.PI/(panel.omega))); //5 PI/omega
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}

		}

	}
	
	public void zmienJezyk()
	{
		labelEK.setText(energiaKinetycznaString);
		labelEP.setText(energiaPotencjalnaString);
	}
	
	

		

}
	

	
	
	
	

	



