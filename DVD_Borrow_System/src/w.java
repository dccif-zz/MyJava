


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Component;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class w {

	private JFrame frmDvd;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					w window = new w();
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
	public w() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmDvd = new JFrame();
		frmDvd.setTitle("DVD\u79DF\u8D41");
		frmDvd.setBounds(100, 100, 628, 455);
		frmDvd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDvd.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(36, 13, 548, 368);
		frmDvd.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u7231\u60C5", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u4F60\u7684\u540D\u5B57");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f2=new JFrame("Windows 2");
				f2.setBounds(200,200,200,200);
				f2.setVisible(true);
				frmDvd.setVisible(false);
				f2.addWindowListener(new WindowAdapter(){
				public void  windowClosing(WindowEvent e){
				frmDvd.setVisible(true);
				}
		});
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.addMouseListener(new MouseAdapter() {

		});
		btnNewButton.setIcon(new ImageIcon("E:\\Source\\your-name.jpg"));
		btnNewButton.setBounds(14, 13, 223, 290);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u52A8\u4F5C", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u5A31\u4E50", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u559C\u5267", null, panel_3, null);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
