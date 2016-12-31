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

public class Select14 {

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
	public Select14() {
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\14.jpg"));
		btnNewButton.setBounds(25, 50, 121, 170);
		SelectUI.getContentPane().add(btnNewButton);
		
		JTextPane txtpndj = new JTextPane();
		txtpndj.setFont(new Font("宋体", Font.PLAIN, 15));
		txtpndj.setText("斯特兰奇博士（本尼迪克特·康伯巴奇 Benedict Cumberbatch 饰）是一名外科手术医生，他拥有着高超的智商和精湛的技艺，是医院乃至整个医学界的传奇人物。某一日，斯特兰奇博士遭遇了一场可怕的车祸，尽管保住了双手，但这双手伤痕累累不住颤抖，这也就意味着，他再也不能拿起手术刀，站在无影灯下了。 ");
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
