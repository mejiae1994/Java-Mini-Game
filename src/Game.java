import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3578101643906483918L;
	Window main;
	private static final int WIDTH = 640,HEIGHT = WIDTH / 12 * 9;
	private boolean running = false;
	private Thread thread;
	private Random r;
	Handler handler;
	Player player;
	private String gbpath = "/Images/bg.jpg";
	private int it = 0;
	private boolean createball = true;
	private Menu menu;
	public static int score = 0;
	public static enum STATE
	{
		MENU,
		GameOver,
		GAME;
	};
	public static STATE state = STATE.MENU;
	
	public Game()
	{
		setFocusable(true);
		
		main = new Window(WIDTH, HEIGHT, "game", this);
		
		handler = new Handler();
		r = new Random();
		player = new Player((640/2)-50,345);
		addKeyListener(new keyInput(player));
		this.addMouseListener(new MouseInput());
		
		handler.addBall(new Ball(300,16,48));
		menu = new Menu();
		
		
	}
	
	public static void main(String[] args)
	{
		new Game();
	
	}
	
	public void someoneScored()
	{
		if(collision())
		{
			score++;
			handler.removeBall(handler.TempBall);
			
		}

	}
	public boolean collision() 
	{
		return handler.TempBall.getBounds().intersects(player.getBounds());
	}
	public synchronized void start() //starts the thread
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public  synchronized void stop() //stops the thread
	{
		 try{
             thread.join(); //tells the thread to stop and makes running false so the run method stops
             running = false;
     }catch(Exception e){
             e.printStackTrace();
     }
	}
	public Image getbg()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(gbpath));
		
		Image newm =  i.getImage();
		
		return newm;
	}

	@Override
	public void run() //this is the game loop
	{
		this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >= 1){
                        tick();
                        delta--;
                }
                if(running)
                        render();
                frames++;
                if(System.currentTimeMillis() - timer > 1000){
                        timer += 1000;
                        System.out.println("FPS: " + frames);
                        frames = 0;
                }
        }
        stop();
		
	}
	public void tick() //this handles the physics and this is where object movements need to be updated
	{
		if(state == STATE.GAME){
		player.tick();
		if(handler.TempBall.getY() > 400)
		{
			handler.addBall(new Ball(r.nextInt(20+590-20),16,32));
		}
		someoneScored();
		handler.tick();
		menu.tick();
		
		}
	}
	 private void render()//renders all the graphics, needs to be implemented in other classes
	 {
         BufferStrategy bs = this.getBufferStrategy();
         if(bs == null){
                 this.createBufferStrategy(3);
                 return;
         }      
         Graphics g = bs.getDrawGraphics();
         g.setColor(Color.BLACK);
         g.fillRect(0, 0, WIDTH, HEIGHT); //draws a rectangle the size of the frame
         if(state == STATE.GAME){
         g.drawImage(getbg(), 0, 0, this);
         handler.render(g);
         player.render(g);
         
         g.setColor(Color.BLACK);
         g.setFont(new Font("serif", Font.BOLD, 18));
         g.drawString(new String("score:" + Integer.toString(score)), 560, 20);
         } else if(state == STATE.MENU)
         {
        	 menu.render(g);
         }
         else if(state == STATE.GameOver)
         {
        	 score = 0;
        	 player.setX((double)(640/2)-50);
        	 menu.render(g);
        	 state = STATE.MENU;
         }
         g.dispose();
         bs.show();
         
        
         
 }
	 public static float clamp(float var, float min, float max){
         if(var >= max)
                 return var = max;
         else if(var < min)
                 return var = min;
         else
                 return var;
 }

	

}
