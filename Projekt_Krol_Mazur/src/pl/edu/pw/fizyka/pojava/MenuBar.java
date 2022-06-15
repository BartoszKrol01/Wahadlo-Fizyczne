package pl.edu.pw.fizyka.pojava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar
	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenu jezykiMenu;
	JMenuItem engMenuItem;
	JMenuItem plMenuItem;
	JMenu instrukcjaMenu;
	JMenuItem instrukcjaMenuItem;
	JMenu matematykaMenu;
	JMenuItem matematykaItem;
	JLabel label;
	
	JFrame dialog;
	JFrame dialog1;
	JEditorPane pane = new JEditorPane();
	
	WyborBrylyFrame wyborBrylyFrame;
	WyborPrzyspieszeniaFrame wyborPrzyspieszeniaFrame;
	PrawyPanel prawyPanel;
	SinusPanel sinusPanel;
	GlowneOknoWahadla okno;
	ZaawansowaneFrame zaawansowaneFrame;
	ProgressBar progressBar;
	
	boolean polski = true;
	boolean angielskiMenu = true;
	
	//ANGIELSKI
	//Menu
	String jezykiMenuStringENG = "Select Language";
	String matematykaENG="Mathematical formulas";
	String instrukcjaMenuStringENG = "Guide";
	String instrukcjaStringENG = "<html>"
			+ "<head><style>"
			+ "p {font-family: Arial; font-size:16;}"
			+ "</style</head>"
			+ "  <title>PHYSICAL PENDULUM-SIMULATION</title>\r\n"
			+ "</head>\r\n"
			+ "\r\n"
			+ "<body>\r\n"
			+ "  <h1>What is it and what is it for?</h1>\r\n"
			+ "  <p>The application allows you to learn and understand the principle of operation of the physical pendulum. "
			+ "The animation shows the movement of the pendulum in approximation of small deflections."
			+ "Under the animation there are graphs of position, speed and acceleration in the function of time."
			+ "The pendulum consists of two parts."
			+ "The first is a rod constituting the 'base' of the pendulum, to which the user can choose any rigid body,"
			+ " which will be suspended at the end of the rod. "
			+ "After making the selection, the user can determine all physical parameters - the mass and length of the 'base', "
			+ "the mass and dimensions of the selected rigid body. In addition, the user can change the value of gravitational acceleration 'g', "
			+ "so as to observe how the movement of the same pendulum may hypothetically look on other planets :)."
			+ " </p>\r\n"
			+ "<h1>Quick Start Guide</h1>\r\n"
			+ "<h2>1) Choose a rigid body that will be the end of the pendulum</h3>\r\n"
			+ "<h2>2) You can specify its weight and dimensions, if not, default values will be set</h3>\r\n"
			+ "<h2>3) Select the value of gravitational acceleration</h3>\r\n"
			+ "<h2>4) Enter values for the weight and length of the member</h3>\r\n"
			+ "<h2>5) Click 'Refresh'</h3>\r\n"
			+ "<h2>Have Fun!!</h3>\r\n"
			+ "</body>\r\n"
			+ "\r\n"
			+ "</html>";
	String kliknijStringENG = "Click...";
	String dialogTytulStringENG = "Program User Manual";
	
	//Errory i Okno
	String tytulGlowneOknoStringENG = "Physical Pendulum";
	
	String zeroErrorENG = "Error - the weight and length of the rod must be greater than 0!";
	String brylaErrorENG = "Error - choose a rigid body!";
	String tekstErrorENG = "Error - enter numeric values in the fields!";
	String nothingErrorENG = "Error - enter values!";
	String uwagaErrorENG = "Warning";
	String longErrorENG = "You have not selected the moment of inertia"
			+"\n"+"To repeat your choice click 'ok'";
	String zeroError2ENG = "Error - Enter numeric values greater than 0";
	String tekstError2ENG = "Enter a numeric value in the field";
	
	//PrawyPanel
	String wyborBrylyButtonStringENG = "Choose a rigid body";
	String wyborPrzyspieszeniaButtonStringENG = "Choose gravitational acceleration";
	String przeliczButtonStringENG = "Refresh";
	String polozenieRadioButtonStringENG = "Show x(t)";
	String predkoscRadioButtonStringENG = "Show v(t)";
	String przyspieszenieRadioButtonStringENG = "Show a(t)";
	
	String wybraneWartosciStringENG = "User-selected Values";
	String edycjaWykresyStringENG = "Chart Edition";
	
	String wybranaMasaBrylyStringENG = "Rigid Body Mass: ";
	String wybranyPromienBrylyStringENG = "Rigid Body Radius: ";
	String wybranaMasaPretaStringENG = "Rod Mass: ";
	String wybranaDlugoscBrylyStringENG = "Rigid Body Lenght: ";
	String wybranaDlugoscPretaStringENG = "Rod Lenght: ";
	String wybranyMomentStringENG = "Moment of inertia: ";
	String wybranePrzyspieszenieStringENG = "Selected gravitational acceleration: ";
	String wybranaWysokoscWalcaStringENG = "Cylinder Height: ";
	String wybranaBrylaStringENG = "Selected rigid body: ";
	String zakonczButtonString2ENG = "Exit";
	String masaStringENG = "Rod Mass [kg]: ";
	String dlugoscStringENG = "Rod length [m]: ";
	
	
	//wyborBrylyFrame
	String tytulWyborBrylyStringENG = "Selection of Rigid Body";
	
	String zakonczStringENG = "Finish";
	
	String walecStringENG = "Cylinder";
	String sferaStringENG = "Sphere";
	String pretStringENG = "Rod";
	String stozekStringENG = "Cone";
	String dyskStringENG = "Disk";
	String kulaStringENG = "Solid sphere";
	
	
	//zaawansowaneFrame
	String masaLabelStringENG = "Mass [kg]";
	String promienLabelStringENG = "Radius [m]";
	String wysokoscWalcaLabelStringENG = "Cylinder Height[m]";
	String dlugoscLabelStringENG = "Rod Lenght [m]";
	
	
	//wyborPrzyspieszeniaFrame
	String infoLabelStringENG = "Selected acceleration g[m/s^2]: ";
	String dodajPrzyspieszenieButtonStringENG = "Add an item";
	String wpiszPrzyspieszenieTextFieldStringENG = "Enter your acceleration value g";
	String tytulWyborPrzyspieszeniaFrameStringENG = "Gravitational acceleration choosing";
	String ziemskieENG = "On Earth";
	String naMarsieENG = "On Mars";
	String naKsiezycuENG = "On Moon";
	
	//sinusPanel
	String tytulSinusPanelStringENG = "Time-dependent sinusoidal waveform";
	
	//progressBar
	String energiaKinetycznaStringENG = "Kinetic Energy";
	String energiaPotencjalnaStringENG = "Potential Energy";
	
		//POLSKI
	//Menu
	String jezykiMenuString = "Wybierz język";
	String instrukcjaMenuString = "Instrukcja";
	String instrukcjaString = "<html>"
			+ "<head><style>"
			+ "p {font-family: Arial; font-size:16;}"
			+ "</style</head>"
			+ "  <title>WAHADŁO FIZYCZNE-SYMULACJA</title>\r\n"
			+ "</head>\r\n"
			+ "\r\n"
			+ "<body>\r\n"
			+ "  <h1>Co to jest i do czego służy?</h1>\r\n"
			+ "  <p>Aplikacja umożliwia poznanie i zrozumienie zasady działania wahadła fizycznego. "
			+ "Widoczna animacja przedstawia ruch wahadła dla przybliżenia małych wychyleń. "
			+ "Pod spodem rysują się wykresy położenia, prędkości oraz przyspieszenia od czasu danego wahadła. "
			+ "Wahadło składa się z dwóch części. "
			+ "Pierwsza z nich to pręt stanowiący 'bazę' wahadła, do której użytkownik może dobrać dowolną bryłę sztywną,"
			+ " która będzie zawieszona na końcu pręta. "
			+ "Po dokonaniu wyboru użytkownik może ustalić wszystkie parametry fizyczne- masę oraz długość bazowego pręta, "
			+ "masę oraz wymiary wybranej bryły. Dodatkowo użytkownik może zmienić wartość przyspieszenia grawitacyjnego 'g', "
			+ "tak aby zaobserwować jak ruch takiego samego wahadła może hipotetycznie wyglądać  na innych planetach :)."
			+ " </p>\r\n"
			+ "<h1>Skrócona instrukcja obsługi</h1>\r\n"
			+ "<h2>1) Wybierz bryłę sztywną, która będzie stanowić koniec wahadła</h3>\r\n"
			+ "<h2>2) Jeśli chcesz określić jej masę oraz wymiary, kliknij 'Zaawansowane'</h3>\r\n"
			+ "<h2>3) Wybierz wartość przyspieszenia grawitacyjnego</h3>\r\n"
			+ "<h2>4) Wprowadź wartości masy oraz długości pręta</h3>\r\n"
			+ "<h2>5) Kliknij 'Odśwież'</h3>\r\n"
			+ "<h2>Miłej zabawy!!</h3>\r\n"
			+ "</body>\r\n"
			+ "\r\n"
			+ "</html>";
	String kliknijString = "Kliknij...";
	String dialogTytulString = "Instrukcja obsługi programu";
	String tytulMatematyka="Wzory i zależności";
	String matematyka="Wzory i zależności";
	
	//Error i Okno
	String tytulGlowneOknoString;
	
	String zeroError;
	String brylaError;
	String tekstError;
	String nothingError;
	String uwagaError;
	String longError;
	String zeroError2;
	String tekstError2;
	
	//PrawyPanel
	String wyborBrylyButtonString;
	String wyborPrzyspieszeniaButtonString;
	String przeliczButtonString;
	String polozenieRadioButtonString;
	String predkoscRadioButtonString;
	String przyspieszenieRadioButtonString;
	
	String wybraneWartosciString;
	String edycjaWykresyString;
	
	String wybranaMasaBrylyString;
	String wybranyPromienBrylyString;
	String wybranaMasaPretaString;
	String wybranaDlugoscBrylyString;
	String wybranaDlugoscPretaString;
	String wybranyMomentString;
	String wybranePrzyspieszenieString;
	String wybranaWysokoscWalcaString;
	String wybranaBrylaString;
	
	String masaString;
	String dlugoscString;
	String zakonczButtonString2;
	
	//wyborBrylyFrame
	String tytulWyborBrylyString;
	
	String zakonczString;
	
	String walecString;
	String sferaString;
	String pretString;
	String stozekString;
	String dyskString;
	String kulaString;
	
	
	//zaawansowaneFrame
	String masaLabelString;
	String promienLabelString;
	String wysokoscWalcaLabelString;
	String dlugoscLabelString;
	
	
	//wyborPrzyspieszeniaFrame
	String infoLabelString;
	String dodajPrzyspieszenieButtonString;
	String wpiszPrzyspieszenieTextFieldString;
	String tytulWyborPrzyspieszeniaFrameString;
	String ziemskie;
	String naMarsie;
	String naKsiezycu;
	
	//SinusPanel
	String tytulSinusPanelString;
	
	//progressBar
	String energiaKinetycznaString = "Energia kinetyczna";
	String energiaPotencjalnaString = "Energia potencjalna";
	
	public MenuBar()
	{

		jezykiMenu = new JMenu(jezykiMenuString);
		this.add(jezykiMenu);
		
		engMenuItem= new JMenuItem("English");
		engMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(polski)
				{
					//POLSKI
					tytulGlowneOknoString = okno.tytulString;
					
					zeroError = prawyPanel.zeroError;
					brylaError = prawyPanel.brylaError;
					tekstError = prawyPanel.tekstError;
					nothingError = prawyPanel.nothingError;
					uwagaError =wyborBrylyFrame.uwagaError;
					longError = wyborBrylyFrame.longError;
					zeroError2 = wyborPrzyspieszeniaFrame.zeroError2;
					tekstError2 = wyborPrzyspieszeniaFrame.tekstError2;
					
					//PrawyPanel
					wyborBrylyButtonString = prawyPanel.wyborBrylyButtonString;
					wyborPrzyspieszeniaButtonString = prawyPanel.wyborPrzyspieszeniaButtonString;
					przeliczButtonString = prawyPanel.przeliczButtonString;
					polozenieRadioButtonString = prawyPanel.polozenieRadioButtonString;
					predkoscRadioButtonString = prawyPanel.predkoscRadioButtonString;
					przyspieszenieRadioButtonString = prawyPanel.przyspieszenieRadioButtonString;
					
					wybraneWartosciString = prawyPanel.wybraneWartosciString;
					edycjaWykresyString = prawyPanel.edycjaWykresuString;
					
					wybranaMasaBrylyString = prawyPanel.wybranaMasaBrylyString;
					wybranyPromienBrylyString = prawyPanel.wybranyPromienBrylyString;
					wybranaMasaPretaString = prawyPanel.wybranaMasaPretaString;
					wybranaDlugoscBrylyString = prawyPanel.wybranaDlugoscBrylyString;
					wybranaDlugoscPretaString = prawyPanel.wybranaDlugoscPretaString;
					wybranyMomentString = prawyPanel.wybranyMomentString;
					wybranePrzyspieszenieString = prawyPanel.wybranePrzyspieszenieString;
					wybranaWysokoscWalcaString = prawyPanel.wybranaWysokoscWalcaString;
					wybranaBrylaString = prawyPanel.wybranaBrylaString;
					zakonczButtonString2 = prawyPanel.zakonczButtonString2;
					masaString = prawyPanel.masaString;
					dlugoscString = prawyPanel.dlugoscString;
					
					
					//wyborBrylyFrame
					tytulWyborBrylyString = wyborBrylyFrame.tytulWyborBrylyString;
					
					zakonczString = wyborBrylyFrame.zakonczString;
					
					walecString = wyborBrylyFrame.walecString;
					sferaString = wyborBrylyFrame.sferaString;
					pretString = wyborBrylyFrame.pretString;
					stozekString = wyborBrylyFrame.stozekString;
					dyskString = wyborBrylyFrame.dyskString;
					kulaString = wyborBrylyFrame.kulaString;
					
					
					//zaawansowaneFrame
					masaLabelString = zaawansowaneFrame.masaLabelString;
					promienLabelString = zaawansowaneFrame.promienLabelString;
					wysokoscWalcaLabelString = zaawansowaneFrame.wysokoscWalcaLabelString;
					dlugoscLabelString = zaawansowaneFrame.dlugoscLabelString;
					
					
					//wyborPrzyspieszeniaFrame
					infoLabelString = wyborPrzyspieszeniaFrame.infoLabelString;
					dodajPrzyspieszenieButtonString = wyborPrzyspieszeniaFrame.dodajPrzyspieszenieButtonString;
					wpiszPrzyspieszenieTextFieldString = wyborPrzyspieszeniaFrame.wpiszPrzyspieszenieTextFieldString;
					tytulWyborPrzyspieszeniaFrameString = wyborPrzyspieszeniaFrame.tytulWyborPrzyspieszeniaFrameString;
					ziemskie = wyborPrzyspieszeniaFrame.ziemskie;
					naMarsie = wyborPrzyspieszeniaFrame.naMarsie;
					naKsiezycu = wyborPrzyspieszeniaFrame.naKsiezycu;
					
					//sinusPanel
					tytulSinusPanelString = sinusPanel.tytulSinusPanelString;
					
					polski = false;
				}
				
				
				okno.setTitle(tytulGlowneOknoStringENG);
				
				//PrawyPanel
				
				prawyPanel.brylaError = brylaErrorENG;
				prawyPanel.zeroError = zeroErrorENG;
				prawyPanel.tekstError = tekstErrorENG;
				prawyPanel.nothingError = nothingErrorENG;
				prawyPanel.uwagaError = nothingErrorENG;
				prawyPanel.wybranaMasaBrylyString = wybranaMasaBrylyStringENG;
				prawyPanel.wybranyPromienBrylyString = wybranyPromienBrylyStringENG;
				prawyPanel.wybranaMasaPretaString = wybranaMasaPretaStringENG;
				prawyPanel.wybranaDlugoscBrylyString = wybranaDlugoscBrylyStringENG;
				prawyPanel.wybranaDlugoscPretaString = wybranaDlugoscPretaStringENG;
				prawyPanel.wybranyMomentString = wybranyMomentStringENG;
				prawyPanel.wybranePrzyspieszenieString = wybranePrzyspieszenieStringENG;
				prawyPanel.wybranaWysokoscWalcaString = wybranaWysokoscWalcaStringENG;
				prawyPanel.wybranaBrylaString = wybranaBrylaStringENG;
				prawyPanel.zakonczButtonString2 = zakonczButtonString2ENG;
				prawyPanel.wyborBrylyButtonString = wyborBrylyButtonStringENG;
				prawyPanel.przeliczButtonString = przeliczButtonStringENG;
				prawyPanel.polozenieRadioButtonString = polozenieRadioButtonStringENG;
				prawyPanel.predkoscRadioButtonString = predkoscRadioButtonStringENG;
				prawyPanel.przyspieszenieRadioButtonString = przyspieszenieRadioButtonStringENG;
			 	prawyPanel.masaString = masaStringENG;
				prawyPanel.dlugoscString = dlugoscStringENG;
				prawyPanel.wyborPrzyspieszeniaButtonString = wyborPrzyspieszeniaButtonStringENG;
				prawyPanel.wybraneWartosciString = wybraneWartosciStringENG;
				prawyPanel.edycjaWykresuString = edycjaWykresyStringENG;
				prawyPanel.setPolski(false);
				
				prawyPanel.zmienJezyk();
				
				//WyborBrylyFrame
				
				wyborBrylyFrame.tytulWyborBrylyString = tytulWyborBrylyStringENG;
				
				wyborBrylyFrame.zakonczString = zakonczStringENG;
				wyborBrylyFrame.walecString = walecStringENG;
				wyborBrylyFrame.sferaString = sferaStringENG;
				wyborBrylyFrame.pretString = pretStringENG;
				wyborBrylyFrame.stozekString = stozekStringENG;
				wyborBrylyFrame.dyskString = dyskStringENG;
				wyborBrylyFrame.kulaString = kulaStringENG;
				wyborBrylyFrame.longError = longErrorENG;
				wyborBrylyFrame.uwagaError = uwagaErrorENG;
				
				wyborBrylyFrame.zmienJezyk();
				
				//ZaawansowaneFrame
				
				zaawansowaneFrame.uwagaError = uwagaErrorENG;
				zaawansowaneFrame.nothingError = nothingErrorENG;
				zaawansowaneFrame.zakonczString = zakonczStringENG;
				zaawansowaneFrame.masaLabelString = masaLabelStringENG;
				zaawansowaneFrame.promienLabelString = promienLabelStringENG;
				zaawansowaneFrame.wysokoscWalcaLabelString = wysokoscWalcaLabelStringENG;
				zaawansowaneFrame.dlugoscLabelString = dlugoscLabelStringENG;
				
				zaawansowaneFrame.zmienJezyk();
				
				//WyborPrzyspieszeniaFrame
				wyborPrzyspieszeniaFrame.dodajPrzyspieszenieButtonString = dodajPrzyspieszenieButtonStringENG;
				wyborPrzyspieszeniaFrame.infoLabelString = infoLabelStringENG;
				wyborPrzyspieszeniaFrame.wpiszPrzyspieszenieTextFieldString = wpiszPrzyspieszenieTextFieldStringENG;
				wyborPrzyspieszeniaFrame.zakonczButtonString = zakonczStringENG;
				wyborPrzyspieszeniaFrame.tytulWyborPrzyspieszeniaFrameString = tytulWyborPrzyspieszeniaFrameStringENG;
				wyborPrzyspieszeniaFrame.ziemskie = ziemskieENG;
				wyborPrzyspieszeniaFrame.naMarsie = naMarsieENG;
				wyborPrzyspieszeniaFrame.naKsiezycu = naKsiezycuENG;
				wyborPrzyspieszeniaFrame.uwagaError = uwagaErrorENG;
				wyborPrzyspieszeniaFrame.zeroError2 = zeroError2ENG;
				wyborPrzyspieszeniaFrame.tekstError2 = tekstError2ENG;
				
				wyborPrzyspieszeniaFrame.zmienJezyk();
				
				//SinusPanel
				sinusPanel.wykresy.setTitle(tytulSinusPanelStringENG);
				
				//progressBar
				progressBar.energiaKinetycznaString = energiaKinetycznaStringENG;
				progressBar.energiaPotencjalnaString = energiaPotencjalnaStringENG;
				
				progressBar.zmienJezyk();
				
				zmienJezyk();
				
			}
		});
		jezykiMenu.add(engMenuItem);
		
		plMenuItem = new JMenuItem("Polski");
		plMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(polski) polski = true;
				else
				{
					okno.setTitle(tytulGlowneOknoString);
					
					//PrawyPanel
					
					prawyPanel.brylaError = brylaError;
					prawyPanel.zeroError = zeroError;
					prawyPanel.tekstError = tekstError;
					prawyPanel.nothingError = nothingError;
					prawyPanel.uwagaError = nothingError;
					prawyPanel.wybranaMasaBrylyString = wybranaMasaBrylyString;
					prawyPanel.wybranyPromienBrylyString = wybranyPromienBrylyString;
					prawyPanel.wybranaMasaPretaString = wybranaMasaPretaString;
					prawyPanel.wybranaDlugoscBrylyString = wybranaDlugoscBrylyString;
					prawyPanel.wybranaDlugoscPretaString = wybranaDlugoscPretaString;
					prawyPanel.wybranyMomentString = wybranyMomentString;
					prawyPanel.wybranePrzyspieszenieString = wybranePrzyspieszenieString;
					prawyPanel.wybranaWysokoscWalcaString = wybranaWysokoscWalcaString;
					prawyPanel.wybranaBrylaString = wybranaBrylaString;
					prawyPanel.zakonczButtonString2 = zakonczButtonString2;
					prawyPanel.wyborBrylyButtonString = wyborBrylyButtonString;
					prawyPanel.przeliczButtonString = przeliczButtonString;
					prawyPanel.polozenieRadioButtonString = polozenieRadioButtonString;
					prawyPanel.predkoscRadioButtonString = predkoscRadioButtonString;
					prawyPanel.przyspieszenieRadioButtonString = przyspieszenieRadioButtonString;
					prawyPanel.wyborPrzyspieszeniaButtonString = wyborPrzyspieszeniaButtonString;
				 	prawyPanel.masaString = masaString;
					prawyPanel.dlugoscString = dlugoscString;
					prawyPanel.wybraneWartosciString = wybraneWartosciString;
					prawyPanel.edycjaWykresuString = edycjaWykresyString;
					prawyPanel.setPolski(true);
					
					prawyPanel.zmienJezyk();
					
					//WyborBrylyFrame
					
					wyborBrylyFrame.tytulWyborBrylyString = tytulWyborBrylyString;
					
					wyborBrylyFrame.zakonczString = zakonczString;
					wyborBrylyFrame.walecString = walecString;
					wyborBrylyFrame.sferaString = sferaString;
					wyborBrylyFrame.pretString = pretString;
					wyborBrylyFrame.stozekString = stozekString;
					wyborBrylyFrame.dyskString = dyskString;
					wyborBrylyFrame.kulaString = kulaString;
					wyborBrylyFrame.longError = longError;
					wyborBrylyFrame.uwagaError = uwagaError;
					
					wyborBrylyFrame.zmienJezyk();
					
					//ZaawansowaneFrame
					
					zaawansowaneFrame.uwagaError = uwagaError;
					zaawansowaneFrame.nothingError = nothingError;
					zaawansowaneFrame.zakonczString = zakonczString;
					zaawansowaneFrame.masaLabelString = masaLabelString;
					zaawansowaneFrame.promienLabelString = promienLabelString;
					zaawansowaneFrame.wysokoscWalcaLabelString = wysokoscWalcaLabelString;
					zaawansowaneFrame.dlugoscLabelString = dlugoscLabelString;
					
					zaawansowaneFrame.zmienJezyk();
					
					//WyborPrzyspieszeniaFrame
					wyborPrzyspieszeniaFrame.dodajPrzyspieszenieButtonString = dodajPrzyspieszenieButtonString;
					wyborPrzyspieszeniaFrame.infoLabelString = infoLabelString;
					wyborPrzyspieszeniaFrame.wpiszPrzyspieszenieTextFieldString = wpiszPrzyspieszenieTextFieldString;
					wyborPrzyspieszeniaFrame.zakonczButtonString = zakonczString;
					wyborPrzyspieszeniaFrame.tytulWyborPrzyspieszeniaFrameString = tytulWyborPrzyspieszeniaFrameString;
					wyborPrzyspieszeniaFrame.ziemskie = ziemskie;
					wyborPrzyspieszeniaFrame.naMarsie = naMarsie;
					wyborPrzyspieszeniaFrame.naKsiezycu = naKsiezycu;
					wyborPrzyspieszeniaFrame.uwagaError = uwagaError;
					wyborPrzyspieszeniaFrame.zeroError2 = zeroError2;
					wyborPrzyspieszeniaFrame.tekstError2 = tekstError2;
					
					wyborPrzyspieszeniaFrame.zmienJezyk();
					
					//SinusPanel
					sinusPanel.wykresy.setTitle(tytulSinusPanelString);
					
					zmienJezyk();
				}
			}
		});
		jezykiMenu.add(plMenuItem);
		
		instrukcjaMenu = new JMenu(instrukcjaMenuString);
		this.add(instrukcjaMenu);
		instrukcjaMenuItem = new JMenuItem(kliknijString);

		matematykaItem = new JMenuItem(kliknijString);
		matematykaMenu=new JMenu(matematyka);
		matematykaMenu.add(matematykaItem);
		this.add(matematykaMenu);
		
		dialog = new JFrame();
		dialog.setTitle(dialogTytulString);
		dialog.setLayout(new BorderLayout());
		dialog.setSize(700,580);
		dialog.setLocationRelativeTo(null);
		
		pane.setBackground(Color.LIGHT_GRAY);
		pane.setEditable(false);
		pane.setContentType("text/html");
		pane.setText(instrukcjaString);
		dialog.add(pane);
		
		
		dialog1 = new JFrame();
		dialog1.setTitle(tytulMatematyka);
		label = new JLabel(); 
		label.setIcon(new ImageIcon(getClass().getResource("/obrazki/mat.png")));
	    label.setBounds(0, 0, 800, 700);
	    dialog1.add(label);
		
	    dialog1.setLayout(new BorderLayout());
		dialog1.setSize(490,700);
		dialog1.setLocationRelativeTo(null);
		pane.setBackground(Color.LIGHT_GRAY);
		pane.setEditable(false);
		
		instrukcjaMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dialog.setVisible(true);
			}
		});
		instrukcjaMenu.add(instrukcjaMenuItem);
		
		matematykaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dialog1.setVisible(true);
			}
		});
	}
	
	public void zmienJezyk()
	{
		if(angielskiMenu)
		{
			label.setIcon(new ImageIcon(getClass().getResource("/obrazki/matENG.png")));
			jezykiMenu.setText(jezykiMenuStringENG);
			matematykaMenu.setText(matematykaENG);
			instrukcjaMenu.setText(instrukcjaMenuStringENG);
			matematykaItem.setText(kliknijStringENG);
			dialog.setTitle(dialogTytulStringENG);
			pane.setText(instrukcjaStringENG);
			instrukcjaMenuItem.setText(kliknijStringENG);
			angielskiMenu = false;
		}
		else
		{
			label.setIcon(new ImageIcon(getClass().getResource("/obrazki/mat.png")));
			jezykiMenu.setText(jezykiMenuString);
			matematykaMenu.setText(matematyka);
			instrukcjaMenu.setText(instrukcjaMenuString);
			dialog.setTitle(dialogTytulString);
			pane.setText(instrukcjaString);
			instrukcjaMenuItem.setText(kliknijString);
			matematykaItem.setText(kliknijString);
			angielskiMenu = true;
		}
		
	}

	public WyborBrylyFrame getWyborBrylyFrame() {
		return wyborBrylyFrame;
	}

	public void setWyborBrylyFrame(WyborBrylyFrame wyborBrylyFrame) {
		this.wyborBrylyFrame = wyborBrylyFrame;
	}

	public WyborPrzyspieszeniaFrame getWyborPrzyspieszeniaFrame() {
		return wyborPrzyspieszeniaFrame;
	}

	public void setWyborPrzyspieszeniaFrame(WyborPrzyspieszeniaFrame wyborPrzyspieszeniaFrame) {
		this.wyborPrzyspieszeniaFrame = wyborPrzyspieszeniaFrame;
	}

	public PrawyPanel getPrawyPanel() {
		return prawyPanel;
	}

	public void setPrawyPanel(PrawyPanel prawyPanel) {
		this.prawyPanel = prawyPanel;
	}

	public SinusPanel getSinusPanel() {
		return sinusPanel;
	}

	public void setSinusPanel(SinusPanel sinusPanel) {
		this.sinusPanel = sinusPanel;
	}

	public GlowneOknoWahadla getOkno() {
		return okno;
	}

	public void setOkno(GlowneOknoWahadla okno) {
		this.okno = okno;
	}

	public ZaawansowaneFrame getZaawansowaneFrame() {
		return zaawansowaneFrame;
	}

	public void setZaawansowaneFrame(ZaawansowaneFrame zaawansowaneFrame) {
		this.zaawansowaneFrame = zaawansowaneFrame;
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(ProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	
}
