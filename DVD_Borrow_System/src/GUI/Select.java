package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select extends Pay {

	public static JFrame SelectUI;
	Pay Pay3 = new Pay();        //实例化界面
	
	public static String SelcPic = "E:\\Source\\Pic\\";   //图片原始读取
	
	String Brief = "zhelishijianjie";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select window = new Select();
					window.SelectUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Select() {
		initialize();
	}
	
	public static void change(int i) {
		String SelcPic = SelcPic + i +".jpg";
	}
		

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		SelectUI = new JFrame();
		SelectUI.setTitle("DVD");
		SelectUI.setBounds(100, 100, 707, 479);
		SelectUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SelectUI.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("pic");
		btnNewButton.setIcon(new ImageIcon(SelcPic));
		btnNewButton.setBounds(25, 47, 194, 251);
		SelectUI.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(Brief);
		textPane.setBounds(275, 47, 309, 86);
		SelectUI.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pay.PayUI.setVisible(true);
				SelectUI.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(286, 319, 71, 70);
		SelectUI.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main1.frmDvd.setVisible(true);
				SelectUI.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(490, 341, 113, 27);
		SelectUI.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("继续选择");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectUI.setVisible(false);
				Main1.frmDvd.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(363, 341, 113, 27);
		SelectUI.getContentPane().add(btnNewButton_3);
	}
}
