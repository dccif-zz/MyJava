package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Spring;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JComboBox;

public class Select12 {

	public static JFrame SelectUI;
	Pay Pay3 = new Pay();        //实例化界面
	
	public String i = "0";
	public static String SelcPic = "E:\\Source\\Pic\\";   //图片原始读取
	
	public static String TrueAddress;
	
	String Brief = "TrueAddress";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	

			public void run() {
				try {
					Select1 window = new Select1();
					Select1.SelectUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Select12() {
		initialize();
	}
	

	public String set(String i){
		this.i=i;
		TrueAddress = SelcPic + i +".jpg";
		return TrueAddress;
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
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\12.jpg"));
		btnNewButton.setBounds(25, 50, 121, 170);
		SelectUI.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("宋体", Font.PLAIN, 15));
		textPane.setText("七月（马思纯 饰）和安生（周冬雨 饰）的第一次相识在十三岁，她们一个是特立独行飞扬跋扈的“野孩子”，一个是单纯温婉循规蹈矩的“乖乖女”，从那一年开始，七月和安生几乎形影不离，她是她的光，她是她的影子，直到某一天，一位名为苏家明（李程彬 饰）的少年出现在了七月的身边，七月恋爱了。 ");
		textPane.setBounds(170, 20, 470, 200);
		SelectUI.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pay.PayUI.setVisible(true);
				SelectUI.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(190,320,70, 70);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox.setBounds(206, 252, 121, 31);
		SelectUI.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setText("3");
		textField.setBounds(414, 252, 116, 31);
		SelectUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("选择天数");
		textField_1.setBounds(206, 223, 120, 30);
		SelectUI.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("付款金额");
		textField_2.setBounds(414, 223, 120, 30);
		SelectUI.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox tian = (JComboBox)e.getSource();
				int days = Integer.parseInt((String) tian.getSelectedItem());
				String total ="";
				total = 3*days+"";
				textField.setText(total);
			}		
		});
	}
}
