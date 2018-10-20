import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	
	private Font XundO = new Font("Arial",Font.BOLD,46);
	private Color background = new Color(236,226,209);
	private Color light_gray = new Color(200,200,200);
	private Draw board = new Draw();
	private JButton[][] felder = new JButton[3][3];
	private JButton nochmal = new JButton("Noch eine Runde!   ");
	private int runde = 0;
	private String player_won = "hat gewonnen";
	private String am_zug = " ist am zug";
	private JTextField messagebox = new JTextField();
	
	public GUI(){
		super();
		setSize(515,569);
		setLayout(null);
		setBackground(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		getContentPane().add(messagebox);
		messagebox.setBounds(0,0,500,30);
		messagebox.setText("Spieler eins ist am Zug");
		messagebox.setHorizontalAlignment(JTextField.CENTER);
		messagebox.setBackground(light_gray);
		messagebox.setBorder(null);
		messagebox.setForeground(Color.WHITE);
		messagebox.add(nochmal);
		nochmal.setVisible(false);
		nochmal.setBounds(365, 0, 150, 30);
		nochmal.setBackground(Color.WHITE);
		nochmal.addActionListener(new listener_nochmal());
		
		
		
		/*****Spielfeld*****/
		getContentPane().add(board);
		board.setBounds(0, 30, 500, 500);
		board.setLayout(new GridLayout(3,3,10,10));
		for(int z = 0; z < 3; z++){
			for(int s = 0;s <3; s++){
				felder[z][s] = new JButton();
				board.add(felder[z][s]);
				felder[z][s].setBounds(s*170, z*170, 160, 160);
				felder[z][s].setBackground(background);
				felder[z][s].setBorder(null);
				felder[z][s].addActionListener(new listener_button(z,s));
				felder[z][s].setFont(XundO);
			}
		}
		getContentPane().add(board);
		
		setVisible(true);
	}
	private class listener_nochmal implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			messagebox.setBackground(light_gray);
			messagebox.setText("Spieler eins ist am Zug");
			nochmal.setVisible(false);
			for(int z = 0; z < 3; z++){
				for(int s = 0;s <3; s++){
					felder[z][s].setText(" ");
				}
			}
		}
	}
	
	private class listener_button implements ActionListener{
		private int zeile;
		private int spalte;
		public listener_button(int z,int s){
			this.zeile = z;
			this.spalte = s;
		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(runde%2 == 1){
				felder[this.zeile][this.spalte].setForeground(Color.BLUE);
				felder[this.zeile][this.spalte].setText("o");
				if(gewonnen("o")){
					messagebox.setText("O gewinnt!");
					messagebox.setBackground(Color.BLUE);
					nochmal.setVisible(true);
				}else{
					messagebox.setText("x" + am_zug);
					messagebox.setBackground(Color.RED);
				}
			}else{
				felder[this.zeile][this.spalte].setForeground(Color.RED);
				felder[this.zeile][this.spalte].setText("x");
				if(gewonnen("x")){
					messagebox.setText("X gewinnt!");
					messagebox.setBackground(Color.RED);
					nochmal.setVisible(true);
				}else{
					messagebox.setText("o" + am_zug);
					messagebox.setBackground(Color.BLUE);
				}
			}
			
			runde++;
		}
		
		private boolean gewonnen(String xodero){
			if(felder[this.zeile][0].getText() == xodero){
				if(felder[this.zeile][1].getText() == xodero){
					if(felder[this.zeile][2].getText() == xodero){
					return true;
					}
				}
			}
			if(felder[0][this.spalte].getText() == xodero){
				if(felder[1][this.spalte].getText() == xodero){
					if(felder[2][this.spalte].getText() == xodero){
					return true;
					}
				}
			}
			if(felder[0][0].getText() == xodero && felder[1][1].getText() == xodero && felder[2][2].getText()==xodero)
			{
				return true;
			}
			if(felder[0][2].getText() == xodero && felder[1][1].getText() == xodero && felder[2][0].getText()==xodero)
			{
				return true;
			}
			return false;
		}
	}
	
	
}
