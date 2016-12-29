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

public class Select1 {

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
	 */
	public Select1() {
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\1.jpg"));
		btnNewButton.setBounds(25, 50, 121, 170);
		SelectUI.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("宋体", Font.PLAIN, 15));
		textPane.setText("金三角湄公河上，一处被称为“鬼门关”的河段，两艘来自中国的商船遭到不明身份之人的枪击袭击。未过多久，泰国军方召开新闻发布会，指责中国商船贩卖毒品。虽然发布会宣称船员全部逃亡，但是十三具遭受残忍杀害的中国船员尸体很快被人发现。这起胆大妄为的案件令中国警方大为震惊，云南省缉毒总队队长高刚（张涵予 饰）受命带特别行动小组前往泰国，并与情报员方新武（彭于晏 饰）合作接洽。根据现有资料显示，这件案子由盘踞在金三角的大毒枭糯卡所为。糯卡贪婪残忍，胆大包天，是湄公河流域上一颗惊扰运输安全的毒瘤。为了将这个恶棍绳之于法，中国、老挝、缅甸开展了三国联合巡逻，集中对糯卡的制毒窝点进行扫荡。而高刚等人也深入最危险境地，与丧失人性的贩毒分子进行惨烈对决…… ");
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
