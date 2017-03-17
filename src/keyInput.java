import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyInput implements KeyListener{
	Game game;
	Player player;
	public keyInput(Player player)
	{
		this.player = player;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			player.keyPressed(e);
			if(e.getKeyCode() == e.VK_ESCAPE)
			{
				Game.state = Game.STATE.MENU;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
