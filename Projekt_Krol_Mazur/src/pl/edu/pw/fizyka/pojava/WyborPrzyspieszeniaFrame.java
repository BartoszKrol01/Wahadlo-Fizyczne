package pl.edu.pw.fizyka.pojava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WyborPrzyspieszeniaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String dodajPrzyspieszenieButtonString = "Dodaj Pozycje";
	String infoLabelString = "Wybrane przespieszenie";
	String wpiszPrzyspieszenieTextFieldString = "Wpisz swoją wartość przyspieszenia g";
	String zakonczButtonString = "Zakończ";
	String tytulWyborPrzyspieszeniaFrameString = "Wybor przyspieszenia grawitacyjnego";
	String ziemskie = "Ziemskie";
	String naMarsie = "Na Marsie";
	String naKsiezycu = "Na Księżycu";
	
	String uwagaError = "Uwaga";
	String zeroError2 = "Błąd - wpisz wartosci liczbowe wieksze od 0";
	String tekstError2 = "Błąd - wpisz w pole wartość liczbową!";
	
	String[] przyspieszeniaString = {ziemskie, naMarsie, naKsiezycu};
	
	@SuppressWarnings("rawtypes")
	JComboBox gComboBox;
	JButton dodajPrzyspieszenieButton;
	JLabel infoLabel;
	JTextField wpiszPrzyspieszenieTextField;
	JButton zakonczButton;
	JButton resetButton;
	
	PrawyPanel parent;
	
	double przyspieszenie = 9.81;
	int i=2;
	
	List<Double> customG = new ArrayList<Double>();
	
	
	public WyborPrzyspieszeniaFrame()
	{
		this.setSize(400,270);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setLayout(new BorderLayout());
		this.setTitle(tytulWyborPrzyspieszeniaFrameString);
		
		ChoosingPanel panel = new ChoosingPanel();
		add(panel, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
	    southPanel.setLayout(new FlowLayout());
	    this.add(southPanel, BorderLayout.SOUTH);
		
		zakonczButton = new JButton(zakonczButtonString);
	    zakonczButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
	    southPanel.add(zakonczButton);
	    
	    resetButton = new JButton("Reset");
	    resetButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gComboBox.removeAllItems();
				gComboBox.addItem(ziemskie);
				gComboBox.addItem(naMarsie);
				gComboBox.addItem(naKsiezycu);
				i=2;
				customG.clear();
				wpiszPrzyspieszenieTextField.setText(wpiszPrzyspieszenieTextFieldString);
			}
		});
	    southPanel.add(resetButton);
	}
	
	class ChoosingPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public ChoosingPanel() 
		{
				setLayout(new GridLayout(4,1));
				gComboBox = new JComboBox(przyspieszeniaString);
				dodajPrzyspieszenieButton = new JButton(dodajPrzyspieszenieButtonString);
				infoLabel = new JLabel();
				wpiszPrzyspieszenieTextField = new JTextField(wpiszPrzyspieszenieTextFieldString);
				
				wpiszPrzyspieszenieTextField.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						if (wpiszPrzyspieszenieTextField.getText().equals(wpiszPrzyspieszenieTextField.getText())) 
							wpiszPrzyspieszenieTextField.setText("");
					}
				});
			   
				dodajPrzyspieszenieButton.addActionListener(new ActionListener() 
				{
					
			        public void actionPerformed(ActionEvent e)
			        {
			        	try{
			        		
			        		Double.parseDouble(wpiszPrzyspieszenieTextField.getText());
			        		if (Double.valueOf(wpiszPrzyspieszenieTextField.getText()) != 0) 
					        {
					        	gComboBox.addItem(wpiszPrzyspieszenieTextField.getText());
					        	i++;
					        	gComboBox.setSelectedIndex(i);
					        	przyspieszenie = Double.valueOf((String) gComboBox.getSelectedItem());
					        	infoLabel.setText(infoLabelString+"	"+"[m/s^2]:"+"	"+ przyspieszenie );
					        	customG.add(przyspieszenie);
					        }
			        		else
			        		{
			        			
			        			JOptionPane.showMessageDialog(WyborPrzyspieszeniaFrame.this,zeroError2,uwagaError, JOptionPane.WARNING_MESSAGE);
			        		}
			        		
			        	}
			        	catch(NumberFormatException e1) {
			        		
			        		JOptionPane.showMessageDialog(WyborPrzyspieszeniaFrame.this,tekstError2,uwagaError, JOptionPane.WARNING_MESSAGE);
			        		
			        	}
				          
			          
			        }
			        
			     });
			      gComboBox.addActionListener(new ActionListener() 
			      {
			    	  
			        public void actionPerformed(ActionEvent e)
			        {
			        	
			        	
			          if(gComboBox.getSelectedItem() == ziemskie)
			          {
			        	  przyspieszenie = 9.81;
			        	  parent.setPrzyspieszenie(przyspieszenie);
			          }
			          else if(gComboBox.getSelectedItem() == naMarsie)
			          {
			        	  przyspieszenie = 3.7;
			        	  parent.setPrzyspieszenie(przyspieszenie);
			          }
			          else if(gComboBox.getSelectedItem() == naKsiezycu)
			          {
			        	  przyspieszenie = 1.6;
			        	  parent.setPrzyspieszenie(przyspieszenie);
			          }
			          else
			          {
			        	 try {
			        		 przyspieszenie = Double.valueOf((String) gComboBox.getSelectedItem());
			        	 }
			        	 catch(NullPointerException e1) {
			        		 przyspieszenie = 9.81;
			        	 }
			        	 parent.setPrzyspieszenie(przyspieszenie);
			          }
			          infoLabel.setText(infoLabelString+"	"+"[m/s^2]:"+"	"+ przyspieszenie );
			        }
			        
			      });
			      
			      add(wpiszPrzyspieszenieTextField);
			      add(gComboBox);
			      add(dodajPrzyspieszenieButton);
			      add(infoLabel);

		}

	}
	
	@SuppressWarnings("unchecked")
	public void zmienJezyk()
	{
		zakonczButton.setText(zakonczButtonString);
		wpiszPrzyspieszenieTextField.setText(wpiszPrzyspieszenieTextFieldString);
		this.setTitle(tytulWyborPrzyspieszeniaFrameString);
		infoLabel.setText(infoLabelString+"	"+"[m/s^2]:"+"	"+ przyspieszenie );
		dodajPrzyspieszenieButton.setText(dodajPrzyspieszenieButtonString);
		gComboBox.removeAllItems();
		gComboBox.addItem(ziemskie);
		gComboBox.addItem(naMarsie);
		gComboBox.addItem(naKsiezycu);
		for(Double i: customG)
		{
			gComboBox.addItem(i);
		}
	}

	public PrawyPanel getParent() {
		return parent;
	}

	public void setParent(PrawyPanel parent) {
		this.parent = parent;
	}
	
	
	public double getprzyspieszenie() {
		return przyspieszenie;
	}
	
}
