import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Ball {

	private double x;
	private double y;
	private double xVel;
	private double yVel;
	private int diameter;
	private int pos = 640/ 12 * 9;
	private String paths = "/Images/Coin.png";
	private Random r;
	
	
	
	public Ball(double x, double y,int diameter)
	{
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		r = new Random();
		
		int r2 = r.nextInt((4))+1;
		while(r2 == 1 || r2 == 2)
		{
			r2 = r.nextInt((4)) +1;
			
		}
		yVel -=r2;
	}
	
	public void tick()
	{
		y -= yVel;
		//y = (int) Game.clamp(y, 0, pos- 72);
	}
	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(getImg(), (int)x, (int)y, null);
		//g2.setColor(Color.RED.darker());
		//g2.fillOval(x, y, diameter, diameter);
	}
	public Rectangle getBounds() 
	{
		return new Rectangle((int)getX(), (int)getY(), 48, 48);
	}
	public Image getImg()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(paths));
		Image img = i.getImage();
		return img;
	}
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

}
