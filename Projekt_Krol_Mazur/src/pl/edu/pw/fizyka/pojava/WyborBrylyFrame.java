package pl.edu.pw.fizyka.pojava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WyborBrylyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	double ulamek;
	
	String tytulWyborBrylyString = "Wybór Bryły Sztywnej";
	String zakonczString = "Zakończ";
	
	String walecString = "Walec";
	String sferaString = "Sfera";
	String pretString = "Pręt";
	String stozekString = "Stożek";
	String dyskString = "Dysk";
	String kulaString = "Kula";

	String longError = "Nie wybrałeś momentu bezwładności"
			+"\n"+"Aby ponowić swój wybór kliknij 'ok'";
	String uwagaError = "Uwaga!";
	
	JPanel grid;
	JPanel przyciskiPanel;
	
	JFrame zaawansowaneOkno;
	
	ImageIcon obrazek;
	
	JButton zakonczButton = new JButton(zakonczString);
	
	
	JLabel walecLabel = new JLabel(walecString, SwingConstants.CENTER);
	JLabel sferaLabel = new JLabel(sferaString, SwingConstants.CENTER);
	JLabel pretLabel = new JLabel(pretString, SwingConstants.CENTER);
	JLabel stozekLabel = new JLabel(stozekString, SwingConstants.CENTER);
	JLabel dyskLabel = new JLabel(dyskString, SwingConstants.CENTER);
	JLabel kulaLabel = new JLabel(kulaString, SwingConstants.CENTER);
	
	PrawyPanel prawyPanel;
	ZaawansowaneFrame zaawansowaneFrame = new ZaawansowaneFrame();
	
	public WyborBrylyFrame() 
	{
		super();	
		zaawansowaneFrame.setWyborBrylyFrame(this);
		this.setSize(610,615);
		this.setLocationRelativeTo(null);
		this.setTitle(tytulWyborBrylyString);
		this.setLayout(new BorderLayout());
		grid = new JPanel();
		grid.setLayout(new GridLayout(2,3));
		this.add(grid, BorderLayout.CENTER);
		przyciskiPanel = new JPanel();
		przyciskiPanel.setLayout(new GridLayout(1,2));
		this.add(przyciskiPanel, BorderLayout.SOUTH);
		
		
		obrazek = new ImageIcon(getClass().getResource("/obrazki/walec.jpg"));
		
		JPanel walecPanel = new JPanel();
		walecPanel.setLayout(new BorderLayout());
		grid.add(walecPanel);
		JButton walecPrzycisk = new JButton();
		walecPrzycisk.setBackground(Color.white);
		walecPrzycisk.setIcon(obrazek);
		walecPrzycisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ulamek=0.083;
				prawyPanel.setUlamek(ulamek);
				zaawansowaneFrame.setVisible(true);
				zaawansowaneFrame.pokazOkno("walec");
			}
		});
		walecPanel.add(walecPrzycisk, BorderLayout.CENTER);
		walecPanel.add(walecLabel, BorderLayout.SOUTH);
		
		
		obrazek = new ImageIcon(getClass().getResource("/obrazki/sfera.jpg"));
		
		JPanel sferaPanel = new JPanel();
		sferaPanel.setLayout(new BorderLayout());
		grid.add(sferaPanel);
		JButton sferaPrzycisk = new JButton();
		sferaPrzycisk.setBackground(Color.white);
		sferaPrzycisk.setIcon(obrazek);
		sferaPrzycisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ulamek=0.66;
				prawyPanel.setUlamek(ulamek);
				zaawansowaneFrame.setVisible(true);
				zaawansowaneFrame.pokazOkno("sfera");
			}
		});
		sferaPanel.add(sferaPrzycisk, BorderLayout.CENTER);
		sferaPanel.add(sferaLabel, BorderLayout.SOUTH);
		
		obrazek = new ImageIcon(getClass().getResource("/obrazki/pret.png"));
		
		JPanel pretPanel = new JPanel();
		pretPanel.setLayout(new BorderLayout());
		grid.add(pretPanel);
		JButton pretPrzycisk = new JButton();
		pretPrzycisk.setBackground(Color.white);
		pretPrzycisk.setIcon(obrazek);
		pretPrzycisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ulamek=0.33;
				prawyPanel.setUlamek(ulamek);
				zaawansowaneFrame.setVisible(true);
				zaawansowaneFrame.pokazOkno("pret");
				
			}
		});
		pretPanel.add(pretPrzycisk, BorderLayout.CENTER);
		pretPanel.add(pretLabel, BorderLayout.SOUTH);
		
		
		
		obrazek = new ImageIcon(getClass().getResource("/obrazki/stozek.png"));
		
		JPanel stozekPanel = new JPanel();
		stozekPanel.setLayout(new BorderLayout());
		grid.add(stozekPanel);
		JButton stozekPrzycisk = new JButton();
		stozekPrzycisk.setBackground(Color.white);
		stozekPrzycisk.setIcon(obrazek);
		stozekPrzycisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ulamek = 0.3;
				prawyPanel.setUlamek(ulamek);
				zaawansowaneFrame.setVisible(true);
				zaawansowaneFrame.pokazOkno("stozek");
			}
		});
		stozekPanel.add(stozekPrzycisk, BorderLayout.CENTER);
		stozekPanel.add(stozekLabel, BorderLayout.SOUTH);
		
		
		obrazek = new ImageIcon(getClass().getResource("/obrazki/dysk.png"));
		
		JPanel dyskPanel = new JPanel();
		dyskPanel.setLayout(new BorderLayout());
		grid.add(dyskPanel);
		JButton dyskPrzycisk = new JButton();
		dyskPrzycisk.setBackground(Color.white);
		dyskPrzycisk.setIcon(obrazek);
		dyskPrzycisk.setActionCommand("reszta");
		dyskPrzycisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ulamek = 0.5;
				prawyPanel.setUlamek(ulamek);
				zaawansowaneFrame.setVisible(true);
				zaawansowaneFrame.pokazOkno("dysk");
			}
		});
		dyskPanel.add(dyskPrzycisk, BorderLayout.CENTER);
		dyskPanel.add(dyskLabel, BorderLayout.SOUTH);
		
		
		obrazek = new ImageIcon(getClass().getResource("/obrazki/sfera.jpg"));
		
		JPanel kulaPanel = new JPanel();
		kulaPanel.setLayout(new BorderLayout());
		grid.add(kulaPanel);
		JButton kulaPrzycisk = new JButton();
		kulaPrzycisk.setBackground(Color.white);
		kulaPrzycisk.setIcon(obrazek);
		kulaPrzycisk.setActionCommand("reszta");
		kulaPrzycisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ulamek = 0.4;
				prawyPanel.setUlamek(ulamek);
				zaawansowaneFrame.setVisible(true);
				zaawansowaneFrame.pokazOkno("kula");
			}
		});
		kulaPanel.add(kulaPrzycisk, BorderLayout.CENTER);
		kulaPanel.add(kulaLabel, BorderLayout.SOUTH);
		
		przyciskiPanel.add(zakonczButton);
		zakonczButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(ulamek == 0)
				{
					JOptionPane.showMessageDialog(null,longError,
							uwagaError, JOptionPane.WARNING_MESSAGE);
				}
				else setVisible(false);
			}
		});
		
		
		
		
	}
	
	public void zmienJezyk()
	{
		this.setTitle(tytulWyborBrylyString);
		
		zakonczButton.setText(zakonczString);
		
		walecLabel.setText(walecString);
		sferaLabel.setText(sferaString);
		pretLabel.setText(pretString);
		stozekLabel.setText(stozekString);
		dyskLabel.setText(dyskString);
		kulaLabel.setText(kulaString);
	}

	public double getUlamek() {
		return ulamek;
	}
	public PrawyPanel getPrawyPanel() {
		return prawyPanel;
	}
	public void setPrawyPanel(PrawyPanel prawyPanel) {
		this.prawyPanel = prawyPanel;
	}
}
		


	
