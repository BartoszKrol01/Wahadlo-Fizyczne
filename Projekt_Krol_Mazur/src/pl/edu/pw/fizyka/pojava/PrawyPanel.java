package pl.edu.pw.fizyka.pojava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PrawyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean pokazPolozenie = true;
	boolean pokazPredkosc = true;
	boolean pokazPrzyspieszenie = true;
	boolean stop = true;
	boolean polski = true;
	
	
	String zeroError = "Błąd - masa i długość pręta muszą być większe od 0!";
	String brylaError = "Błąd - wybierz bryłę!";
	String tekstError = "Błąd - wpisz w pola wartości liczbowe!";
	String nothingError = "Błąd - podaj wartości!";
	String uwagaError = "Uwaga!";
	
	String wybranaMasaBrylyString = "Masa Bryły: ";
	String wybranyPromienBrylyString = "Promień Bryły: ";
	String wybranaMasaPretaString = "Masa Pręta: ";
	String wybranaDlugoscBrylyString = "Długość Bryły (Pręta): ";
	String wybranaDlugoscPretaString = "Długość Pręta: ";
	String wybranyMomentString = "Moment Bezwładności: ";
	String wybranePrzyspieszenieString = "Przyspieszenie g: ";
	String wybranaWysokoscWalcaString = "Wysokość Walca: ";
	String wybranaBrylaString = "Wybrana Bryła: ";
	String wybraneWartosciString = "Wartości wybrane przez użytkownika";
	String zakonczButtonString2 = "Zamknij";
	String wyborBrylyButtonString = "Wybór bryły sztywnej";
	String wyborPrzyspieszeniaButtonString = "Wybór przyspieszenia grawitacyjnego";
	String przeliczButtonString = "Odśwież";
	String polozenieRadioButtonString = "Pokaż położenie x(t)";
	String predkoscRadioButtonString = "Pokaż prędkość v(t)";
	String przyspieszenieRadioButtonString = "Pokaż przyspieszenie a(t)";
	String masaString = "Masa pręta [kg]:  ";
	String dlugoscString = "Długość pręta l[m]:  ";
	String edycjaWykresuString = "Edycja Wykresu";
	
	JButton wyborBrylyButton;
	JButton wyborPrzyspieszeniaButton;
	JButton przeliczButton;
	JButton zakonczButton;
	JButton stopButton;
	
	JRadioButton polozenieRadioButton;
	JRadioButton predkoscRadioButton;
	JRadioButton przyspieszenieRadioButton;
	
	JLabel edycjaWykresuLabel;
	JLabel wybraneWartosci;
	JLabel wybranaMasaBryly;
	JLabel wybranyPromienBryly;
	JLabel wybranaMasaPreta;
	JLabel wybranaDlugoscBryly;
	JLabel wybranaDlugoscPreta;
	JLabel wybranyMoment;
	JLabel wybranePrzyspieszenie;
	JLabel wybranaWysokoscWalca;
	JLabel wybranaBryla;
	JLabel masaLabel;
	JLabel dlugoscLabel;
	
	JTextField masaTextField;
	JTextField dlugoscTextField;
	
	WyborBrylyFrame wyborBryly = new WyborBrylyFrame();
	WyborPrzyspieszeniaFrame wyborPrzyspieszenia = new WyborPrzyspieszeniaFrame();
	
	double przyspieszenie = 9.81;
	double momentBezwladnosci = 0;
	double omega = 0;

	double masaBryly = 1;
	double masaPreta = 1;
	double dlugoscBryly = 1;
	double dlugoscPreta = 1;
	double promienBryly = 1;
	double ulamek = 0;
	double wysokoscWalca = 1;
	
	Color przyspieszenieColor;
	Color momentBezwladnosciColor;
	Color masaBrylyColor;
	Color masaPretaColor;
	Color dlugoscBrylyColor;
	Color dlugoscPretaColor;
	Color promienBrylyColor;
	Color wysokoscWalcaColor;
	
	SinusPanel wykres;
	AnimacjaWahadlaPanel animacjaWahadla;
	ProgressBar progress;
	
	
	
	public SinusPanel getWykres() {
		return wykres;
	}

	public void setWykres(SinusPanel wykres) {
		this.wykres = wykres;
	}

	public PrawyPanel()
	{
		//wyborBryly.setPrawyPanel(this);
		this.setPreferredSize(new Dimension(350,1000));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.weighty=0;
		gbc.weightx=1;
		
		
		//MOMENT BEZWŁADNOŚCI
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		wyborBrylyButton = new JButton(wyborBrylyButtonString);
		this.add(wyborBrylyButton,gbc);
		wyborBrylyButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				wyborBryly.setVisible(true);
				
				
			}
		});
		
		//PRZYSPIESZENIE ZIEMSKIE
		wyborPrzyspieszeniaButton = new JButton(wyborPrzyspieszeniaButtonString);
		gbc.weighty=1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.add(wyborPrzyspieszeniaButton,gbc);
		wyborPrzyspieszeniaButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				wyborPrzyspieszenia.setVisible(true);
			}
		});
		
		
		gbc.weighty=0;
		//MASA
		masaTextField = new JTextField("1");
		masaTextField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if (masaTextField.getText().equals(masaTextField.getText())) 
	                masaTextField.setText("");
			}
		});
		masaTextField.setHorizontalAlignment(JTextField.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.add(masaTextField,gbc);
		
		masaLabel = new JLabel(masaString, SwingConstants.CENTER);
		gbc.gridx = 0;
		this.add(masaLabel,gbc);
		
		//DŁUGOŚĆ
		dlugoscTextField = new JTextField("1");
		dlugoscTextField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if (dlugoscTextField.getText().equals(dlugoscTextField.getText()))
					dlugoscTextField.setText("");
			}
		});
		dlugoscTextField.setHorizontalAlignment(JTextField.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(dlugoscTextField,gbc);
		
		dlugoscLabel = new JLabel(dlugoscString, SwingConstants.CENTER);
		gbc.gridx = 0;
		this.add(dlugoscLabel,gbc);
		
		gbc.insets = new Insets(60, 0, 10, 0);
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		wybraneWartosci = new JLabel(wybraneWartosciString, SwingConstants.CENTER);
		wybranaMasaBryly = new JLabel(wybranaMasaBrylyString+ masaBryly +" kg", SwingConstants.CENTER);
		wybranyPromienBryly= new JLabel(wybranyPromienBrylyString+ promienBryly +" m", SwingConstants.CENTER);
		wybranaMasaPreta= new JLabel(wybranaMasaPretaString+ masaPreta +" kg", SwingConstants.CENTER);
		wybranaDlugoscBryly= new JLabel(wybranaDlugoscBrylyString + dlugoscBryly +" m", SwingConstants.CENTER);
		wybranaDlugoscPreta= new JLabel(wybranaDlugoscPretaString+ dlugoscPreta +" m", SwingConstants.CENTER);
		wybranyMoment= new JLabel(wybranyMomentString + " - kg*m^2", SwingConstants.CENTER);
		wybranePrzyspieszenie= new JLabel(wybranePrzyspieszenieString+ przyspieszenie +" m/s^2", SwingConstants.CENTER);
		wybranaWysokoscWalca = new JLabel(wybranaWysokoscWalcaString+ wysokoscWalca +" m", SwingConstants.CENTER);
		wybranaBryla = new JLabel(wybranaBrylaString + " - ");
		
		wybraneWartosci.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(wybraneWartosci, gbc);
		
		gbc.insets = new Insets(5, 0, 0, 0);
		
		gbc.weighty=0;
		gbc.gridwidth = 1;
		gbc.gridy = 5;
		add(wybranyPromienBryly,gbc);
		wybranyPromienBryly.setVisible(true);
		
		gbc.gridx = 1;
		add(wybranaMasaBryly,gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridy=5;
		add(wybranaDlugoscBryly, gbc);
		wybranaDlugoscBryly.setVisible(false);
		
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridy=6;
		add(wybranaWysokoscWalca, gbc);
		wybranaWysokoscWalca.setVisible(false);
		
		gbc.gridwidth = 1;
		gbc.gridy = 7;
		add(wybranaDlugoscPreta,gbc);
		
		gbc.gridx = 1;
		add(wybranaMasaPreta, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		add(wybranyMoment, gbc);
		
		gbc.gridx = 1;
		add(wybranaBryla, gbc);
		
		gbc.gridwidth = 2;
		gbc.gridy =9;
		gbc.gridx = 0;
		add(wybranePrzyspieszenie, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		gbc.gridy = 14;
		gbc.weighty = 0;		
		progress = new ProgressBar();
		add(progress, gbc);
		
		gbc.gridy = 15;
		gbc.weighty = 1;
		
		przeliczButton = new JButton(przeliczButtonString);
		add(przeliczButton, gbc);
		
		
		przeliczButton.addActionListener(new ActionListener() {
		
			
		ExecutorService exec = Executors.newFixedThreadPool(2);
		ExecutorService exec1 = Executors.newFixedThreadPool(1);
		
		
			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException 
			{
			
					try {
						
						masaPreta = Double.valueOf(masaTextField.getText());
						dlugoscPreta = Double.valueOf(dlugoscTextField.getText());
						
						
						if(masaTextField.getText().equals("0") || dlugoscTextField.getText().equals("0"))
						{
							JOptionPane.showMessageDialog(null,zeroError,uwagaError, JOptionPane.WARNING_MESSAGE);
						}
						else if(ulamek==0)
						{
							JOptionPane.showMessageDialog(null,brylaError,uwagaError, JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							
							if(ulamek == 0.33)
							{
								momentBezwladnosci = ulamek * masaBryly * dlugoscBryly * dlugoscBryly;
								wybranyMoment.setText(wybranyMomentString + momentBezwladnosci +" kg * m^2 ");
								wybranaDlugoscBryly.setVisible(true);
								wybranaWysokoscWalca.setVisible(false);
								wybranyPromienBryly.setVisible(false);
							}
							else if(ulamek == 0.083)
							{
								momentBezwladnosci = ulamek * masaBryly *(3* promienBryly * promienBryly + wysokoscWalca * wysokoscWalca);
								wybranyMoment.setText(wybranyMomentString + momentBezwladnosci +" kg * m^2");
								wybranaWysokoscWalca.setVisible(true);
								wybranaDlugoscBryly.setVisible(false);
								wybranyPromienBryly.setVisible(true);
							}
							else 
							{
								momentBezwladnosci = ulamek * masaBryly * promienBryly * promienBryly;
								wybranyMoment.setText(String.format(wybranyMomentString) + momentBezwladnosci +" kg * m^2 ");
								wybranaWysokoscWalca.setVisible(false);
								wybranaDlugoscBryly.setVisible(false);
								wybranyPromienBryly.setVisible(true);
							}
							
							omega = obliczenia();
							
							wykres.polozenie.clear();
							wykres.predkosc.clear();
							wykres.przyspieszenie.clear();
							
							wykres.setOmega(omega);
							animacjaWahadla.setUlamek(ulamek);
							animacjaWahadla.setOmega(omega);
							
							exec.execute(animacjaWahadla);
							exec.execute(wykres);
							exec1.execute(progress);
							
							
							wybranyPromienBryly.setText(wybranyPromienBrylyString + promienBryly +" m");
							wybranaMasaBryly.setText(wybranaMasaBrylyString+ masaBryly +" kg");
							wybranaDlugoscBryly.setText(wybranaDlugoscBrylyString+ dlugoscBryly +" m");
							wybranaWysokoscWalca.setText(wybranaWysokoscWalcaString+ wysokoscWalca +" m");
							wybranaDlugoscPreta.setText(wybranaDlugoscPretaString+ Double.valueOf(dlugoscTextField.getText()) +" m");
							wybranaMasaPreta.setText(wybranaMasaPretaString+ Double.valueOf(masaTextField.getText()) +" kg");
							wybranePrzyspieszenie.setText(wybranePrzyspieszenieString+ przyspieszenie +" m/s^2");
							wybranaBryla.setText(wybranaBrylaString + wypiszBryle(ulamek));
							
						}
					}
					catch (NumberFormatException e1) 
					{
						JOptionPane.showMessageDialog(null,tekstError,uwagaError, JOptionPane.WARNING_MESSAGE);
					}
					catch (NullPointerException e2)
					{
						JOptionPane.showMessageDialog(null,nothingError,uwagaError, JOptionPane.WARNING_MESSAGE);
					}
					
			}
		});
		
		gbc.insets = new Insets(60, 0, 10, 0);
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 10;
		edycjaWykresuLabel = new JLabel(edycjaWykresuString, SwingConstants.CENTER);
		edycjaWykresuLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		this.add(edycjaWykresuLabel, gbc);
		
		
		gbc.insets = new Insets(5, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 11;
		polozenieRadioButton = new JRadioButton(polozenieRadioButtonString);
		this.add(polozenieRadioButton, gbc);
		polozenieRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				wykres.edytujSeriePolozenie(pokazPolozenie);
				
			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 12;
		predkoscRadioButton = new JRadioButton(predkoscRadioButtonString);
		this.add(predkoscRadioButton, gbc);
		predkoscRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				wykres.edytujSeriePredkosc(pokazPredkosc);
				
			}
		});
		
		gbc.insets = new Insets(0, 0, 50, 0);
		gbc.gridx = 0;
		gbc.gridy = 13;
		przyspieszenieRadioButton = new JRadioButton(przyspieszenieRadioButtonString);
		this.add(przyspieszenieRadioButton, gbc);
		przyspieszenieRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				wykres.edytujSeriePrzyspieszenie(pokazPrzyspieszenie);
				
			}
		});
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		
		
		gbc.weighty=0;
		gbc.gridwidth = 2;
		gbc.gridy = 16;
		zakonczButton = new JButton(zakonczButtonString2);
		zakonczButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		this.add(zakonczButton, gbc);
		
		
		
		
	}
	
	
	public void zmienJezyk()
	{
		wybranyPromienBryly.setText(wybranyPromienBrylyString + promienBryly +" m");
		wybranaMasaBryly.setText(wybranaMasaBrylyString+ masaBryly +" kg");
		wybranaDlugoscBryly.setText(wybranaDlugoscBrylyString+ dlugoscBryly +" m");
		wybranaWysokoscWalca.setText(wybranaWysokoscWalcaString+ wysokoscWalca +" m");
		wybranaDlugoscPreta.setText(wybranaDlugoscPretaString+ Double.valueOf(dlugoscTextField.getText()) +" m");
		wybranaMasaPreta.setText(wybranaMasaPretaString+ Double.valueOf(masaTextField.getText()) +" kg");
		wybranePrzyspieszenie.setText(wybranePrzyspieszenieString+ przyspieszenie +" m/s^2");
		wybranaBryla.setText(wybranaBrylaString + wypiszBryle(ulamek));
		wybranyMoment.setText(wybranyMomentString + " - kg*m^2");
		zakonczButton.setText(zakonczButtonString2);
		wyborBrylyButton.setText(wyborBrylyButtonString);
		wyborPrzyspieszeniaButton.setText(wyborPrzyspieszeniaButtonString);
		przeliczButton.setText(przeliczButtonString);
		polozenieRadioButton.setText(polozenieRadioButtonString);
		predkoscRadioButton.setText(predkoscRadioButtonString);
		przyspieszenieRadioButton.setText(przyspieszenieRadioButtonString);
		masaLabel.setText(masaString);
		dlugoscLabel.setText(dlugoscString);
		wybraneWartosci.setText(wybraneWartosciString);
		edycjaWykresuLabel.setText(edycjaWykresuString);
	}

	public double obliczenia()
	{
		double licznik;
		double mianownik;
		double oblicz;
		
		if(ulamek==0.33)
		{
			licznik = przyspieszenie*(masaBryly*(dlugoscBryly + dlugoscPreta) + 0.5*masaPreta*dlugoscPreta);
			mianownik = 0.33 * masaPreta * dlugoscPreta * dlugoscPreta + momentBezwladnosci + masaBryly*(dlugoscBryly + dlugoscPreta)*(dlugoscBryly + dlugoscPreta);
		}
		else if(ulamek==0.083)
		{
			licznik = przyspieszenie*(masaBryly*(wysokoscWalca + dlugoscPreta) + 0.5*masaPreta*dlugoscPreta);
			mianownik = 0.33 * masaPreta * dlugoscPreta * dlugoscPreta + momentBezwladnosci + masaBryly*(wysokoscWalca + dlugoscPreta)*(wysokoscWalca+ dlugoscPreta);
		}
		else
		{
			licznik = przyspieszenie*(masaBryly*(promienBryly + dlugoscPreta) + 0.5*masaPreta*dlugoscPreta);
			mianownik = 0.33 * masaPreta * dlugoscPreta * dlugoscPreta + momentBezwladnosci + masaBryly*(promienBryly + dlugoscPreta)*(promienBryly + dlugoscPreta);
		}
		
		double u = licznik/mianownik;
		oblicz = Math.sqrt(u);
		return oblicz;
	}
	
	public String wypiszBryle(double ulamek)
	{
		String bryla;
		if(polski){
			if(ulamek == 0.083) bryla = "Walec";
			else if(ulamek == 0.33) bryla = "Pręt";
			else if(ulamek == 0.66) bryla = "Sfera";
			else if(ulamek == 0.3) bryla = "Stożek";
			else if(ulamek == 0.5) bryla = "Dysk";
			else if(ulamek == 0.4)bryla = "Kula";
			else bryla = "-";
		}
		else {
			if(ulamek == 0.083) bryla = "Cylinder";
			else if(ulamek == 0.33) bryla = "Rod";
			else if(ulamek == 0.66) bryla = "Sphere";
			else if(ulamek == 0.3) bryla = "Cone";
			else if(ulamek == 0.5) bryla = "Disk";
			else if(ulamek == 0.4)bryla = "Solid Sphere";
			else bryla = "-";
		}
		
		return bryla;
	}
	

	public double getPrzyspieszenie() {
		return przyspieszenie;
	}

	public void setPrzyspieszenie(double przyspieszenie) {
		this.przyspieszenie = przyspieszenie;
	}

	public double getMasaBryly() {
		return masaBryly;
	}

	public void setMasaBryly(double masaBryly) {
		this.masaBryly = masaBryly;
	}

	public double getDlugoscBryly() {
		return dlugoscBryly;
	}

	public void setDlugoscBryly(double dlugoscBryly) {
		this.dlugoscBryly = dlugoscBryly;
	}

	public double getPromienBryly() {
		return promienBryly;
	}

	public void setPromienBryly(double promienBryly) {
		this.promienBryly = promienBryly;
	}

	public double getUlamek() {
		return ulamek;
	}

	public void setUlamek(double ulamek) {
		this.ulamek = ulamek;
	}

	public double getWysokoscWalca() {
		return wysokoscWalca;
	}

	public void setWysokoscWalca(double wysokoscWalca) {
		this.wysokoscWalca = wysokoscWalca;
	}

	public AnimacjaWahadlaPanel getAnimacjaWahadla() {
		return animacjaWahadla;
	}

	public void setAnimacjaWahadla(AnimacjaWahadlaPanel animacjaWahadla) {
		this.animacjaWahadla = animacjaWahadla;
	}

	public boolean isPokazPolozenie() {
		return pokazPolozenie;
	}

	public void setPokazPolozenie(boolean pokazPolozenie) {
		this.pokazPolozenie = pokazPolozenie;
	}

	public boolean isPokazPredkosc() {
		return pokazPredkosc;
	}

	public void setPokazPredkosc(boolean pokazPredkosc) {
		this.pokazPredkosc = pokazPredkosc;
	}

	public boolean isPokazPrzyspieszenie() {
		return pokazPrzyspieszenie;
	}

	public void setPokazPrzyspieszenie(boolean pokazPrzyspieszenie) {
		this.pokazPrzyspieszenie = pokazPrzyspieszenie;
	}

	public boolean isPolski() {
		return polski;
	}

	public void setPolski(boolean polski) {
		this.polski = polski;
	}

	public Color getPrzyspieszenieColor() {
		return przyspieszenieColor;
	}

	public void setPrzyspieszenieColor(Color przyspieszenieColor) {
		this.przyspieszenieColor = przyspieszenieColor;
	}

	public Color getMomentBezwladnosciColor() {
		return momentBezwladnosciColor;
	}

	public void setMomentBezwladnosciColor(Color momentBezwladnosciColor) {
		this.momentBezwladnosciColor = momentBezwladnosciColor;
	}

	public Color getMasaBrylyColor() {
		return masaBrylyColor;
	}

	public void setMasaBrylyColor(Color masaBrylyColor) {
		this.masaBrylyColor = masaBrylyColor;
	}

	public Color getMasaPretaColor() {
		return masaPretaColor;
	}

	public void setMasaPretaColor(Color masaPretaColor) {
		this.masaPretaColor = masaPretaColor;
	}

	public Color getDlugoscBrylyColor() {
		return dlugoscBrylyColor;
	}

	public void setDlugoscBrylyColor(Color dlugoscBrylyColor) {
		this.dlugoscBrylyColor = dlugoscBrylyColor;
	}

	public Color getDlugoscPretaColor() {
		return dlugoscPretaColor;
	}

	public void setDlugoscPretaColor(Color dlugoscPretaColor) {
		this.dlugoscPretaColor = dlugoscPretaColor;
	}

	public Color getPromienBrylyColor() {
		return promienBrylyColor;
	}

	public void setPromienBrylyColor(Color promienBrylyColor) {
		this.promienBrylyColor = promienBrylyColor;
	}

	public Color getWysokoscWalcaColor() {
		return wysokoscWalcaColor;
	}

	public void setWysokoscWalcaColor(Color wysokoscWalcaColor) {
		this.wysokoscWalcaColor = wysokoscWalcaColor;
	}

	
	
}
