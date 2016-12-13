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

public class Main1 extends Select{

	public static JFrame frmDvd;
	private final Action action = new SwingAction();

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
	private void initialize() {
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
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("娱乐", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("喜剧", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("爱情", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("你的名字");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDvd.setVisible(false);
				Select.SelectUI.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("E:\\Source\\your-name.jpg"));
		btnNewButton_1.setBounds(26, 29, 194, 251);
		panel_3.add(btnNewButton_1);
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
