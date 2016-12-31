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
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Font;

public class Select16 {

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
					Select5 window = new Select5();
					Select5.SelectUI.setVisible(true);
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
	public Select16() {
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\16.jpg"));
		btnNewButton.setBounds(25, 50, 121, 170);
		SelectUI.getContentPane().add(btnNewButton);
		
		JTextPane txtpndj = new JTextPane();
		txtpndj.setFont(new Font("宋体", Font.PLAIN, 15));
		txtpndj.setText("道姆·柯布（莱昂纳多·迪卡普里奥 Leonardo DiCaprio 饰）与同事阿瑟（约瑟夫·戈登-莱维特 Joseph Gordon-Levitt 饰）和纳什（卢卡斯·哈斯 Lukas Haas 饰）在一次针对日本能源大亨齐藤（渡边谦 饰）的盗梦行动中失败，反被齐藤利用。齐藤威逼利诱因遭通缉而流亡海外的柯布帮他拆分他竞争对手的公司，采取极端措施在其唯一继承人罗伯特·费希尔（希里安·墨菲 Cillian Murphy 饰）的深层潜意识中种下放弃家族公司、自立门户的想法。为了重返美国，柯布偷偷求助于岳父迈尔斯（迈克尔·凯恩 Michael Caine 饰），吸收了年轻的梦境设计师艾里阿德妮（艾伦·佩吉 Ellen Page 饰）、梦境演员艾姆斯（汤姆·哈迪 Tom Hardy 饰）和药剂师约瑟夫（迪利普·劳 Dileep Rao 饰）加入行动。在一层层递进的梦境中，柯布不仅要对付费希尔潜意识的本能反抗，还必须直面已逝妻子梅尔（玛丽昂·歌迪亚 Marion Cotillard 饰）的处处破坏，实际情况远比预想危险得多……");
		txtpndj.setBounds(170, 20, 470, 200);
		SelectUI.getContentPane().add(txtpndj);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pay.PayUI.setVisible(true);
				SelectUI.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(190,320, 70, 70);
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
		comboBox.setBounds(206, 252, 120, 30);
		SelectUI.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setText("3");
		textField.setBounds(414, 252, 120, 30);
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
