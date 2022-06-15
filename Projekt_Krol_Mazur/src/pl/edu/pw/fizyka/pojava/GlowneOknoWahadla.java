package pl.edu.pw.fizyka.pojava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GlowneOknoWahadla extends JFrame {


	//synchronizacja wahadła z wykresem, punkt na wykresie, zmiana omegi, JComboBox
	
	private static final long serialVersionUID = 1L;

	//MENU
	MenuBar menuBar;
	
	//ANIMACJE
	JPanel animacjePanel;
	AnimacjaWahadlaPanel wahadloPanel;
	SinusPanel sinusPanel;
	
	//prawyPanel
	PrawyPanel prawyPanel;
	
	String tytulString = "Wahadło Fizyczne";
	
	public GlowneOknoWahadla(){
		
		
		//FRAME
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setTitle(tytulString);
		
		//MENU
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		//leftPanel
		animacjePanel = new JPanel();
		animacjePanel.setLayout(new BorderLayout());
		add(BorderLayout.CENTER, animacjePanel);
		
		wahadloPanel = new AnimacjaWahadlaPanel();
		animacjePanel.add(BorderLayout.CENTER, wahadloPanel);
						
		//SINUS
		sinusPanel = new SinusPanel();
		animacjePanel.add(BorderLayout.SOUTH, sinusPanel.chartPanel);
	
		
		//PrawyPanel
		prawyPanel = new PrawyPanel();
		add(BorderLayout.EAST, prawyPanel);
		prawyPanel.setWykres(sinusPanel);
		
		
		//Przekazywanie wskaznikow
		prawyPanel.wyborBryly.setPrawyPanel(prawyPanel);
		prawyPanel.wyborPrzyspieszenia.setParent(prawyPanel);
		prawyPanel.setAnimacjaWahadla(wahadloPanel);
		prawyPanel.progress.setPanel(wahadloPanel);
		
		sinusPanel.setPrawyPanel(prawyPanel);
		
		menuBar.setWyborBrylyFrame(prawyPanel.wyborBryly);
		menuBar.setWyborPrzyspieszeniaFrame(prawyPanel.wyborPrzyspieszenia);
		menuBar.setPrawyPanel(prawyPanel);
		menuBar.setSinusPanel(sinusPanel);
		menuBar.setOkno(this);
		menuBar.setZaawansowaneFrame(prawyPanel.wyborBryly.zaawansowaneFrame);
		menuBar.setProgressBar(prawyPanel.progress);
		
	}

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlowneOknoWahadla mainFrame = new GlowneOknoWahadla();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
