import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Menu {
	
	private Rectangle rect1 = new Rectangle(280,150, 100,50);
	private Rectangle rect2 = new Rectangle(280,250, 100,50);
	private Rectangle rect3 = new Rectangle(280,350, 100,50);
	private String title = "Rainbow Cup";
	private String mbg = "/Images/background.png";

	private String prevScore;
	
	public static int maxScore;
	
	public Menu()
	{
		
		
	}
	public Image getMbg()
	{
		ImageIcon bg = new ImageIcon(getClass().getResource(mbg));
		Image img = bg.getImage();
		return img;
	}
	

	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(getMbg(), 0, 0, null);
		g2.setColor(Color.WHITE.brighter());
		
		Font f1 = new Font("serif", Font.BOLD, 50);
		g2.setFont(f1);
		g2.drawString(title, 190, 80);
		
		//g2.draw(rect1);
		//g2.draw(rect2);
		//g2.draw(rect3);
		g2.setFont(new Font("arial", Font.BOLD,50));
		g2.drawString("Play", 285, 188);
		g2.drawString("Help", 281, 288);
		g2.drawString("Quit", 281, 388);
		
		g2.setFont(new Font("serif", Font.BOLD, 18));
		g2.drawString(getScore(maxScore),5,15);

		
		
	}
	public String getScore(int score)
	{
		
		prevScore = "High Score: " + Integer.toString(score);
		return prevScore;
	}
	public void tick()
	{
		setmaxScore();
	}
	public void setmaxScore()
	{
		if(maxScore < Game.score )
		{
			maxScore = Game.score;
		}
		else {
			maxScore = maxScore;
		}
	}
}
