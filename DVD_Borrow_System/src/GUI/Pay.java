package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Pay {

	public static JFrame PayUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay window = new Pay();
					window.PayUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PayUI = new JFrame();
		PayUI.setTitle("DVD");
		PayUI.setBounds(100, 100, 707, 479);
		PayUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PayUI.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Qcord");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\new.jpg"));
		btnNewButton.setBounds(214, 47, 222, 208);
		PayUI.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main1.frmDvd.setVisible(true);
				PayUI.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(300, 300, 113, 27);
		PayUI.getContentPane().add(btnNewButton_1);
	}

}
