import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Draw extends JPanel{

	
	 @Override
	 protected void paintComponent(Graphics g) {
	 super.paintComponent(g);	
	 g.setColor(Color.black);
	 g.fillRect(160, 0, 10, 500);
	 g.fillRect(330, 0, 10, 500);
	 g.fillRect(0, 160, 500, 10);
	 g.fillRect(0, 330, 500, 10);
	 }
}
