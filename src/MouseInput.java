import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{
	
	Menu menu; 
	
	
	public MouseInput()
	{
		menu = new Menu();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*g2.drawString("Play", 285, 188);
		g2.drawString("Help", 281, 288);
		g2.drawString("Quit", 281, 388);
		*/
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		
		if(mx >= 300 && mx <= 380)
		{
			if(my >= 140 && my <= 200)
			{
				Game.state = Game.STATE.GAME;
			}
		}
		if(mx >= 300 && mx <= 350)
		{
			if(my >= 350 && my <= 400)
			{
				System.exit(1);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
