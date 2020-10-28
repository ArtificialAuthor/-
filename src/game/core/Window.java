//References
package game.core;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;

//Window - class, program host
public final class Window extends JFrame{
	//CFG 1, public
	public static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static Window self;
	
	//CFG 2
	public Window() {
		//Inner
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		setUndecorated(true);
		setVisible(true);
		setPreferredSize(resolution);
		
		//Outer
		add(new Loadingscreen());
		pack();
	}
	
	//Starter protocol
	public static void main(String args[]) {
		self = new Window();
	}
}