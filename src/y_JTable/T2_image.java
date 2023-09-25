package y_JTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T2_image extends JFrame {

	private JPanel contentPane;
	private ButtonGroup btnGroup = new ButtonGroup();
	private JRadioButton rdImg1, rdImg2, rdImg3, rdImg4, rdImg5, rdImg6;
	private JButton btnInfor;
	private JLabel lblInfor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T2_image frame = new T2_image();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public T2_image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 77);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		rdImg1 = new JRadioButton("그림 1");
		rdImg1.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		rdImg1.setBounds(35, 23, 89, 29);
		btnGroup.add(rdImg1);
		pn1.add(rdImg1);
		
		rdImg2 = new JRadioButton("그림 2");
		rdImg2.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		rdImg2.setBounds(159, 23, 89, 29);
		btnGroup.add(rdImg2);
		pn1.add(rdImg2);
		
		rdImg3 = new JRadioButton("그림 3");
		rdImg3.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		rdImg3.setBounds(283, 23, 89, 29);
		btnGroup.add(rdImg3);
		pn1.add(rdImg3);
		
		rdImg4 = new JRadioButton("그림 4");
		rdImg4.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		rdImg4.setBounds(407, 23, 89, 29);
		btnGroup.add(rdImg4);
		pn1.add(rdImg4);
		
		rdImg5 = new JRadioButton("그림 5");
		rdImg5.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		rdImg5.setBounds(531, 23, 89, 29);
		btnGroup.add(rdImg5);
		pn1.add(rdImg5);
		
		rdImg6 = new JRadioButton("그림 6");
		rdImg6.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		rdImg6.setBounds(655, 23, 89, 29);
		btnGroup.add(rdImg6);
		pn1.add(rdImg6);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 80, 784, 379);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblImage = new JLabel();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBackground(new Color(250, 235, 215));
		lblImage.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		lblImage.setBounds(12, 10, 760, 359);
		pn2.add(lblImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 463, 784, 88);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnExit = new JButton("종  료");
		btnExit.setBackground(new Color(176, 196, 222));
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		btnExit.setBounds(628, 26, 144, 52);
		pn3.add(btnExit);
		
		btnInfor = new JButton("그림정보출력");
		btnInfor.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		btnInfor.setBackground(new Color(176, 196, 222));
		btnInfor.setBounds(12, 26, 144, 52);
		pn3.add(btnInfor);
		
		lblInfor = new JLabel("그림을 클릭하면 해당 그림 파일의 정보가 출력됩니다");
		lblInfor.setBackground(new Color(176, 196, 222));
		lblInfor.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));
		lblInfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor.setBounds(168, 29, 445, 49);
		pn3.add(lblInfor);
		
		//////////////////////////////////////////////////////
		
		// 그림정보출력 버튼을 클릭시 수행
		btnInfor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String photo="그림을 클릭하면 해당 그림 파일의 정보가 출력됩니다";
				if(lblImage.getIcon() != null) photo = lblImage.getIcon().toString();
				lblInfor.setText(photo);
			}
		});
		
		// 그림 출력시 수행
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String photo="그림을 클릭하면 해당 그림 파일의 정보가 출력됩니다";
				if(lblImage.getIcon() != null) photo = lblImage.getIcon().toString();
				lblInfor.setText(photo);
			}
		});
		
		// 그림 1 라디오버튼 클릭 -> 수행할 내용
		rdImg1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource("./Images/1.jpg")));
			}
		});
		
		// 그림 2 라디오버튼 클릭 -> 수행할 내용
		rdImg2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource("./Images/2.jpg")));
			}
		});
		
		// 그림 3 라디오버튼 클릭 -> 수행할 내용
		rdImg3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource("./Images/3.jpg")));
			}
		});
		
		// 그림 4 라디오버튼 클릭 -> 수행할 내용
		rdImg4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource("./Images/4.jpg")));
			}
		});
		
		// 그림 5 라디오버튼 클릭 -> 수행할 내용
		rdImg5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource("./Images/5.jpg")));
			}
		});
		
		// 그림 6 라디오버튼 클릭 -> 수행할 내용
		rdImg6.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource("./Images/6.jpg")));
			}
		});
	
		// 종료 버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
