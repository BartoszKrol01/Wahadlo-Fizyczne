package pl.edu.pw.fizyka.pojava;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ZaawansowaneFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	WyborBrylyFrame wyborBrylyFrame;
	
	JPanel borderLayoutPanel;
	JPanel zaawansowanePanel;
	
	JTextField masaTextField;
	JTextField dlugoscTextField;
	JTextField wysokoscWalcaTextField;
	JTextField promienTextField;
	
	JButton zakonczZaw;
	
	String uwagaError = "Uwaga!";
	String nothingError = "Błąd - Wprowadz wartości";
	
	String zakonczString = "Zakończ";
	String masaLabelString = "Masa [kg]";
	String promienLabelString = "Promień bryły [m]";
	String wysokoscWalcaLabelString = "Wysokość walca [m]";
	String dlugoscLabelString = "Długość pręta [m]";
	
	JLabel masaLabel = new JLabel(masaLabelString, SwingConstants.CENTER);
	JLabel promienLabel = new JLabel(promienLabelString, SwingConstants.CENTER);
	JLabel wysokoscWalcaLabel = new JLabel(wysokoscWalcaLabelString, SwingConstants.CENTER);
	JLabel dlugoscLabel = new JLabel(dlugoscLabelString, SwingConstants.CENTER);

	double promien=1;
	double dlugosc=1;
	double masa=1;
	double wysokoscWalca=1;
	
	public ZaawansowaneFrame() throws HeadlessException {

		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		
		borderLayoutPanel = new JPanel();
		borderLayoutPanel.setLayout(new BorderLayout());
		this.add(borderLayoutPanel);
		
		zakonczZaw = new JButton(zakonczString);
		borderLayoutPanel.add(zakonczZaw, BorderLayout.SOUTH);
		zakonczZaw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				promien = Double.valueOf(promienTextField.getText());
				masa = Double.valueOf(masaTextField.getText());
				dlugosc = Double.valueOf(dlugoscTextField.getText());
				wysokoscWalca = Double.valueOf(wysokoscWalcaTextField.getText());
				
				try {
					if(promien == 0 || masa == 0 || dlugosc == 0 || wysokoscWalca == 0) {
						
						JOptionPane.showMessageDialog(null,nothingError,uwagaError, JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						wyborBrylyFrame.prawyPanel.setPromienBryly(promien);
						wyborBrylyFrame.prawyPanel.setDlugoscBryly(dlugosc);
						wyborBrylyFrame.prawyPanel.setWysokoscWalca(wysokoscWalca);
						wyborBrylyFrame.prawyPanel.setMasaBryly(masa);
						
					}
					
				}
				catch (NumberFormatException e1) 
				{
					JOptionPane.showMessageDialog(null,nothingError,uwagaError, JOptionPane.WARNING_MESSAGE);
				}
				catch (NullPointerException e2)
				{
					JOptionPane.showMessageDialog(null,nothingError,uwagaError, JOptionPane.WARNING_MESSAGE);
				}
				
				setVisible(false);
			}
		});
		
		zaawansowanePanel = new JPanel();
		zaawansowanePanel.setLayout(new GridBagLayout());
		borderLayoutPanel.add(zaawansowanePanel, BorderLayout.CENTER);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		zaawansowanePanel.add(masaLabel, gbc);
		
		gbc.gridx = 1;
		masaTextField = new JTextField();
		zaawansowanePanel.add(masaTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		zaawansowanePanel.add(dlugoscLabel, gbc);
		
		gbc.gridx = 1;
		dlugoscTextField = new JTextField();
		zaawansowanePanel.add(dlugoscTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		zaawansowanePanel.add(promienLabel, gbc);
		
		gbc.gridx = 1;
		promienTextField = new JTextField();
		zaawansowanePanel.add(promienTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		zaawansowanePanel.add(wysokoscWalcaLabel, gbc);
		
		gbc.gridx = 1;
		wysokoscWalcaTextField = new JTextField(10);
		zaawansowanePanel.add(wysokoscWalcaTextField, gbc);
		
		dlugoscLabel.setVisible(false);
		dlugoscTextField.setVisible(false);
		
		promienLabel.setVisible(false);
		promienTextField.setVisible(false);
		
		wysokoscWalcaLabel.setVisible(false);
		wysokoscWalcaTextField.setVisible(false);
	}

	public void pokazOkno(String bryla) {
		
		masaTextField.setText(wyborBrylyFrame.prawyPanel.masaBryly+"");
		dlugoscTextField.setText(wyborBrylyFrame.prawyPanel.dlugoscBryly+"");
		promienTextField.setText(wyborBrylyFrame.prawyPanel.promienBryly+"");
		wysokoscWalcaTextField.setText(wyborBrylyFrame.prawyPanel.wysokoscWalca+"");
		
		if(bryla.equals("walec")) {
			
			this.setSize(300,150);
			
			dlugoscLabel.setVisible(false);
			dlugoscTextField.setVisible(false);
			
			promienLabel.setVisible(true);
			promienTextField.setVisible(true);
			
			wysokoscWalcaLabel.setVisible(true);
			wysokoscWalcaTextField.setVisible(true);
			
		}
		
		else if(bryla.equals("pret")) {
			
			this.setSize(300,110);
			
			dlugoscLabel.setVisible(true);
			dlugoscTextField.setVisible(true);
			
			promienLabel.setVisible(false);
			promienTextField.setVisible(false);
			
			wysokoscWalcaLabel.setVisible(false);
			wysokoscWalcaTextField.setVisible(false);
			
		}
		
		else {
			
			this.setSize(300,110);
			
			dlugoscLabel.setVisible(false);
			dlugoscTextField.setVisible(false);
			
			promienLabel.setVisible(true);
			promienTextField.setVisible(true);
			
			wysokoscWalcaLabel.setVisible(false);
			wysokoscWalcaTextField.setVisible(false);
			
		}
		
	}
	
	public void zmienJezyk()
	{
		zakonczZaw.setText(zakonczString);
		
		masaLabel.setText(masaLabelString);
		dlugoscLabel.setText(dlugoscLabelString);
		wysokoscWalcaLabel.setText(wysokoscWalcaLabelString);
		promienLabel.setText(promienLabelString);
	}

	public WyborBrylyFrame getWyborBrylyFrame() {
		return wyborBrylyFrame;
	}

	public void setWyborBrylyFrame(WyborBrylyFrame wyborBrylyFrame) {
		this.wyborBrylyFrame = wyborBrylyFrame;
	}

}
