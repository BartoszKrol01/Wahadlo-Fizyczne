package pl.edu.pw.fizyka.pojava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class AnimacjaWahadlaPanel extends JPanel implements Runnable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double dlugoscPreta = 300;
	double wychylenie = 0;
	double amplituda = 0.5;
	double omega = 0;
	double ulamek = 0;
	double dt = 0;
	
	int brylaX;
	int brylaY;
	
	public AnimacjaWahadlaPanel()
	{
		
	}

	@Override
	public void run() {
		
		while(true)
		{
			wychylenie = amplituda * Math.sin(omega*dt);
			dt = dt + 0.01;
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		
		g2d.setStroke(new BasicStroke(5));
		
		brylaX = getWidth()/2+ (int) (Math.sin(wychylenie)*dlugoscPreta);
		brylaY = (int) (Math.cos(wychylenie)*dlugoscPreta);
		
		g2d.drawLine(brylaX,brylaY,getWidth()/2,0);
		
		if(ulamek == 0)
		{
			g2d.fillOval(brylaX-25, brylaY-25, 50, 50);
		}
		
		else if(ulamek == 0.083)
		{
			g2d.rotate(-wychylenie,brylaX ,brylaY);
			g2d.fillRect(brylaX-50, brylaY-25, 100, 50);
		}
		else if(ulamek == 0.33) 
		{
			g2d.rotate(-wychylenie,brylaX ,brylaY);
			g2d.fillRect(brylaX-50, brylaY-5, 100, 10);
		}
		else if(ulamek == 0.66 || ulamek == 0.4) 
		{
			g2d.fillOval(brylaX-25, brylaY-25, 50, 50);
		}
		else if(ulamek == 0.3)
		{
			g2d.rotate(-wychylenie, brylaX, brylaY);
			int[] X = {brylaX+40, brylaX, brylaX-40};
			int[] Y = {brylaY+50, brylaY, brylaY+50};
			g2d.fillPolygon(X,Y,3);
		} 
		else if(ulamek == 0.5)
		{
			g2d.rotate(-wychylenie,brylaX ,brylaY);
			g2d.fillRect(brylaX-50, brylaY, 100, 3);
		}
		
		
	}
	

	public double getOmega() {
		return omega;
	}

	public void setOmega(double omega) {
		this.omega = omega;
	}

	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}

	public double getUlamek() {
		return ulamek;
	}

	public void setUlamek(double ulamek) {
		this.ulamek = ulamek;
	}

	public double getWychylenie() {
		return wychylenie;
	}

	public void setWychylenie(double wychylenie) {
		this.wychylenie = wychylenie;
	}
	
	
}
