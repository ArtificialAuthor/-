//??? Artt
//???????????
package game.windowTabs;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import game.Window;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//????? - ?????? ???????? ????
public class TabMainMenu extends WindowTab {
	//CFG1
	BufferedImage background;
	BufferedImage moon;
	BufferedImage earth;
	//CFG2
	public TabMainMenu() {
		//??????????
		setLayout(null);
		
		
		//?????? "?????"
		JButton exit = new JButton("exit");
		exit.setBounds(Window.resolution.width/2-75, Window.resolution.height/2+100, 150, 50);
		exit.addActionListener(new listenExit());
		exit.setFont(defaultButtonFont);
		add(exit);
		
		//?????? "??????"
		JButton athors = new JButton("athors");
		athors.setBounds(Window.resolution.width/2-75, Window.resolution.height/2, 150, 50);
		athors.addActionListener(new listenAuthors());
		athors.setFont(defaultButtonFont);
		add(athors);
		
		//?????? "??????"
		JButton play = new JButton("play");
		play.setBounds(Window.resolution.width/2-75, Window.resolution.height/2-100, 150, 50);
		play.addActionListener(new listenPlay());
		play.setFont(defaultButtonFont);
		add(play);
		
		try {
			background = ImageIO.read(Window.class.getResource("sprites/background.png"));
			moon = ImageIO.read(Window.class.getResource("sprites/moon.png"));
			earth = ImageIO.read(Window.class.getResource("sprites/earth.png"));
		} catch (Exception e) {}
	}
	
	//CFG 3
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, Window.resolution.width, Window.resolution.height, null);
		g.drawImage(moon, -(int)(Window.resolution.height*1.4d)/2, 0, (int)(Window.resolution.height*1.4d), (int)(Window.resolution.height*1.4d), null);
		g.drawImage(earth, Window.resolution.width-300, 200, 3*64, 3*64, null);
	}
}

//CFG 4
//????????? ?????? "?????"
class listenExit implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.exit(0);
	}
}
//????????? ?????? "??????"
class listenAuthors implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(1); //1 - ID ?????? ? ????????
	}
}
//????????? ?????? "??????"
class listenPlay implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(2); //2 - ID ?????? ? ?????
	}
}