package Ex;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class T00 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T00 frame = new T00();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public T00() {
		setTitle("국내 투웨어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 884, 98);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pnImage = new JPanel();
		pnImage.setBounds(0, 100, 324, 269);
		contentPane.add(pnImage);
		pnImage.setLayout(null);
		
		JPanel pntext = new JPanel();
		pntext.setBounds(358, 100, 526, 269);
		contentPane.add(pntext);
		pntext.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 379, 884, 182);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		setIconImage(new ImageIcon(getClass().getResource("./images/icon.jpg")).getImage());
	}
}
