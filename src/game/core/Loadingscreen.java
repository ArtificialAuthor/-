//References
package game.core;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.IOException;

//Canvas - class, game logic & drawings host
public final class Loadingscreen extends JPanel implements Runnable{
	//CFG 1, private
	BufferedImage logo;
	int[] pos = {0,0};
	
	//CFG 2
	public Loadingscreen() {
		setLayout(null);
		
		//Getting logo image
		try {
			logo = ImageIO.read(getClass().getResource("logo.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pos[0] = Window.resolution.width/2 - logo.getWidth()/2;
		pos[1] = Window.resolution.height/2 - logo.getHeight()/2;
		
		new Thread(this).start();
	}
	
	//Runnable interface - repaintings
	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(10);
				repaint();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Drawing interface - repaintings
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Window.resolution.width, Window.resolution.height);
		g.drawImage(logo, pos[0], pos[1], null);
	}
}