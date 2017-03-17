import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

/*calling same method inside same method is like recurssion, 
 * works with same methods in different classes
 */
public class Handler {
	
	LinkedList<Ball> ball = new LinkedList<Ball>(); 
	Ball TempBall;
	private Random r;
	Player p;
	public Handler()
	{
		p = new Player();
	}
	
	public void render(Graphics g)
	{
		for(int i =0;i < ball.size();i++)
		{
			TempBall = ball.get(i);
			
			TempBall.render(g);
		}
	}
	
	
	public void tick()
	{
		for(int i =0;i < ball.size();i++)
		{	
			TempBall = ball.get(i);
			if(TempBall.getY() > 400)
			{
				removeBall(TempBall);
				Game.state = Game.STATE.GameOver;
			}
		
		}
		
		TempBall.tick();
		
	}
	
	public void addBall(Ball object) //when called by hanlder.addBall, this adds an object to the linked list
	{
		this.ball.add(object);
	}
	public void removeBall(Ball object) //removes the objects of type Ball
	{
		this.ball.remove(object);
	}

}
