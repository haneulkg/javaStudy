package Swing3_Layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T05_NullLayout1 extends JFrame {
	private JButton btnExit;
	
	public T05_NullLayout1() {
		setTitle("절대위치(Null) 레이아웃");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(null);
		
		add(getBtnExit());
		
	}
	
	private JButton getBtnExit() {
		btnExit = new JButton();
		btnExit.setText("종료");
		btnExit.setBounds(100, 80, 70, 50);
		return btnExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			T05_NullLayout1 t05 = new T05_NullLayout1();
			t05.setVisible(true);				
			}
		});
	}
}
