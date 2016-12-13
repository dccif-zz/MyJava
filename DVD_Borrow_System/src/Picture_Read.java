import javax.swing.*;

public class Picture_Read{

public static void main(String[] args) {
		  Pic dvd = new Pic();
		  dvd.addPic();
	}
	
}
class Pic extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton[] buttons = new JButton[12]; 

	ImageIcon ic = new ImageIcon("E:\\Source\\your-name.jpg");
	
	@SuppressWarnings("deprecation")
	public void addPic(){
		//super("DVD");

		this.setTitle("DVD");	
		this.setSize(480,720);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		
		label.setIcon(ic);
		panel.add(label);
	
		this.setContentPane(panel);
		this.show();
	    
	   }  
}