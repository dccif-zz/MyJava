package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;


public class Main1{
	public static JFrame frmDvd;
	Select1 SelectNew1 = new Select1();
	Select2 SelectNew2 = new Select2();
	Select3 SelectNew3 = new Select3();
	Select4 SelectNew4 = new Select4();
	Select5 SelectNew5 = new Select5();
	Select6 SelectNew6 = new Select6();
	Select7 SelectNew7 = new Select7();
	Select8 SelectNew8 = new Select8();
	Select9 SelectNew9 = new Select9();
	Select10 SelectNew10 = new Select10();
	Select11 SelectNew11 = new Select11();
	Select12 SelectNew12 = new Select12();
	Select13 SelectNew13 = new Select13();
	Select14 SelectNew14 = new Select14();
	Select15 SelectNew15 = new Select15();
	Select16 SelectNew16 = new Select16();//实例化界面
	public final Action action = new SwingAction();
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 window = new Main1();
					window.frmDvd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public Main1() {
		initialize();
	}
	
	
	/*public String get(String i){
		this.i=i;
		TrueAddress = SelcPic + i +".jpg";
		return TrueAddress;
	}*/
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmDvd = new JFrame();
		frmDvd.setTitle("DVD租赁系统");
		frmDvd.setBounds(100, 100, 707, 479);
		frmDvd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDvd.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(51, 37, 575, 367);
		frmDvd.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("动作", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select1.SelectUI.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\1.jpg"));
		btnNewButton.setBounds(19, 50, 121, 170);
		panel.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\2.jpg"));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select2.SelectUI.setVisible(true);
			}
		});
		
		btnNewButton_4.setBounds(158, 50, 119, 170);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select4.SelectUI.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\4.jpg"));
		btnNewButton_5.setBounds(438, 50, 113, 170);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select3.SelectUI.setVisible(true);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\3.jpg"));
		btnNewButton_6.setBounds(296, 50, 123, 170);
		panel.add(btnNewButton_6);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("喜剧", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select5.SelectUI.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\5.jpg"));
		btnNewButton_3.setBounds(19, 50, 121, 170);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDvd.setVisible(false);
				Select6.SelectUI.setVisible(true);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\6.jpg"));
		btnNewButton_9.setBounds(159, 50, 120, 170);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select8.SelectUI.setVisible(true);
			}
		});
		btnNewButton_10.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\8.jpg"));
		btnNewButton_10.setBounds(434, 50, 117, 170);
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_15 = new JButton("");
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select7.SelectUI.setVisible(true);
			}
		});
		btnNewButton_15.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\7.jpg"));
		btnNewButton_15.setBounds(297, 50, 121, 170);
		panel_2.add(btnNewButton_15);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("爱情", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select9.SelectUI.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\9.jpg"));
		btnNewButton_1.setBounds(19, 50, 111, 170);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select10.SelectUI.setVisible(true);
			}
		});
		btnNewButton_11.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\10.jpg"));
		btnNewButton_11.setBounds(149, 50, 121, 170);
		panel_3.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select12.SelectUI.setVisible(true);
			}
		});
		btnNewButton_12.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\12.jpg"));
		btnNewButton_12.setBounds(437, 50, 114, 170);
		panel_3.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select11.SelectUI.setVisible(true);
			}
		});
		btnNewButton_13.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\11.jpg"));
		btnNewButton_13.setBounds(300, 50, 118, 170);
		panel_3.add(btnNewButton_13);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("科幻", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select13.SelectUI.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\13.jpg"));
		btnNewButton_2.setBounds(19, 50, 117, 170);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select14.SelectUI.setVisible(true);
			}
		});
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\14.jpg"));
		btnNewButton_7.setBounds(155, 50, 120, 170);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select15.SelectUI.setVisible(true);
			}
		});
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\15.jpg"));
		btnNewButton_8.setBounds(294, 50, 121, 170);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_14 = new JButton("");
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDvd.setVisible(false);
				Select16.SelectUI.setVisible(true);
			}
		});
		btnNewButton_14.setIcon(new ImageIcon("C:\\Users\\dccif\\Documents\\Work\\Source\\Pic\\16.jpg"));
		btnNewButton_14.setBounds(430, 50, 121, 170);
		panel_1.add(btnNewButton_14);
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}


