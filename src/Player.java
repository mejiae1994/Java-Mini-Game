import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Player {
	
	private double x;
	private double y;
	private double xVel = 0;
	private double yVel = 0;
	BufferedImage bi;
	Image img;
	ImageIcon newIcon;
	Handler handler;
	
	private String paths = "/Images/Cup.png";
	
	public Player(double x, double y)
	{
		this.x = x;
		this.y = y;
		handler = new Handler();
		
	}
	public Player()
	{
		
	}
	
	public void tick()
	{
		x += xVel;
		if(x > 560) x = 560;
		if(x < -20) x = -20; 
		
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle((int)x+8, (int)y+64, 32, 64);
	}

	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g; 
		
		
		//g2.drawImage(img, 0, 0, 64, 64, null);
		g2.drawImage(getPlayerImg(), (int)x,(int) y, null);
			
	}
	public double getxVel() {
		return xVel;
	}
	public void setX(double value)
	{
		x = value;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public Image getPlayerImg()
	{
		//this resizes the imageicon
		ImageIcon i = new ImageIcon(getClass().getResource(paths));
		
		img = i.getImage();
		
		Image newimg = img.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		
		ImageIcon there = new ImageIcon(newimg);
		
		img = there.getImage();
		return img;
	}
	public void getImg()
	{
		img = getPlayerImg();
		
	}
	public BufferedImage getBi()
	{
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		return bi;
		
	}
	public void keyPressed(KeyEvent e) {
		int buttons = e.getKeyCode();
		if(buttons == e.VK_RIGHT)
		{
			this.setxVel(4);
		}
		if(buttons == e.VK_LEFT)
		{
			this.setxVel(-4);
		}
	
		
	}

	public void keyReleased(KeyEvent e) {
		int buttons = e.getKeyCode();
		if(buttons == e.VK_RIGHT)
		{
			this.setxVel(0);
		}
		if(buttons == e.VK_LEFT)
		{
			this.setxVel(0);
		}
	
	}

	
}
