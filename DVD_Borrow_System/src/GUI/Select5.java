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

public class Select5 {

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
	 */
	public Select5() {
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\5.jpg"));
		btnNewButton.setBounds(25, 50, 121, 170);
		SelectUI.getContentPane().add(btnNewButton);
		
		JTextPane txtpndj = new JTextPane();
		txtpndj.setFont(new Font("宋体", Font.PLAIN, 15));
		txtpndj.setText("本片根据印度畅销书作家奇坦·巴哈特（Chetan Bhagat）的处女作小说《五点人》（Five Point Someone）改编而成。法兰（马德哈万 R Madhavan 饰）、拉杜（沙曼·乔希 Sharman Joshi 饰）与兰乔（阿米尔·汗 Aamir Khan 饰）是皇家工程学院的学生，三人共居一室，结为好友。在以严格著称的学院里，兰乔是个非常与众不同的学生，他不死记硬背，甚至还公然顶撞校长“病毒”（波曼·伊拉尼 Boman Irani 饰），质疑他的教学方法。他不仅鼓动法兰与拉杜去勇敢追寻理想，还劝说校长的二女儿碧雅（卡琳娜·卡普 Kareena Kapoor 饰）离开满眼铜臭的未婚夫。兰乔的特立独行引起了模范学生“消音器”（奥米·维嘉 Omi Vaidya 饰）的不满，他约定十年后再与兰乔一决高下，看哪种生活方式更能取得成功。");
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
