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


public class Main1 extends Select{
	public static JFrame frmDvd;
	Select Select2 = new Select(); //实例化界面
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Select.change(1);
				//System.out.println(SelcPic);
				frmDvd.setVisible(false);
				Select2.SelectUI.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("E:\\Source\\Pic\\1.jpg"));
		btnNewButton.setBounds(27, 33, 162, 231);
		panel.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(223, 25, 113, 138);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(403, 25, 113, 138);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(223, 176, 113, 133);
		panel.add(btnNewButton_6);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("娱乐", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(35, 48, 155, 206);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(218, 48, 129, 133);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(378, 48, 129, 145);
		panel_1.add(btnNewButton_8);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("喜剧", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(42, 52, 159, 210);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(243, 65, 138, 147);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setBounds(411, 52, 113, 141);
		panel_2.add(btnNewButton_10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("爱情", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("你的名字");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select2.SelectUI.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("E:\\Source\\your-name.jpg"));
		btnNewButton_1.setBounds(26, 29, 194, 251);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.setBounds(234, 13, 119, 152);
		panel_3.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		btnNewButton_12.setBounds(408, 17, 119, 152);
		panel_3.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		btnNewButton_13.setBounds(234, 180, 117, 142);
		panel_3.add(btnNewButton_13);
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
