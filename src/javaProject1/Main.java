package javaProject1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtNickName;
	private JTextField txtPassword;
	JButton btnLogin, btnUse, btnMember, btnExit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setTitle("국내 투웨이");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 844, 64);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn5 = new JPanel();
		pn5.setBackground(new Color(250, 235, 215));
		pn5.setBounds(12, 10, 143, 44);
		pn1.add(pn5);
		pn5.setLayout(null);
		
		JLabel lbltittl = new JLabel("국내 투웨이");
		lbltittl.setBounds(0, 0, 143, 43);
		pn5.add(lbltittl);
		lbltittl.setBackground(new Color(250, 235, 215));
		lbltittl.setHorizontalAlignment(SwingConstants.CENTER);
		lbltittl.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(0, 65, 844, -1);
		pn1.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 60, 845, 4);
		pn1.add(panel_2);
		panel_2.setBackground(new Color(105, 105, 105));
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 63, 514, 418);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblphoto = new JLabel("");
		lblphoto.setIcon(new ImageIcon(Main.class.getResource("/javaProject1/images/icon.jpg")));
		lblphoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblphoto.setBounds(12, 45, 490, 306);
		pn2.add(lblphoto);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 481, 844, 170);
		contentPane.add(pn4);
		pn4.setLayout(null);
		
		JPanel pn3_1 = new JPanel();
		pn3_1.setBounds(12, 10, 308, 41);
		pn4.add(pn3_1);
		pn3_1.setBackground(new Color(250, 250, 210));
		pn3_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("로그인(닉네임,비밀번호)");
		lblNewLabel.setBounds(12, 0, 284, 41);
		pn3_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pn3_2 = new JPanel();
		pn3_2.setBounds(12, 61, 96, 41);
		pn4.add(pn3_2);
		pn3_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("닉네임");
		lblNewLabel_1.setBounds(0, 0, 96, 38);
		pn3_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		
		JPanel pn3_2_1 = new JPanel();
		pn3_2_1.setBounds(120, 61, 200, 41);
		pn4.add(pn3_2_1);
		pn3_2_1.setBackground(new Color(176, 196, 222));
		pn3_2_1.setLayout(null);
		
		txtNickName = new JTextField();
		txtNickName.setBounds(0, 0, 200, 41);
		pn3_2_1.add(txtNickName);
		txtNickName.setHorizontalAlignment(SwingConstants.CENTER);
		txtNickName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		txtNickName.setBackground(new Color(176, 196, 222));
		txtNickName.setColumns(10);
		
		JPanel pn3_2_2 = new JPanel();
		pn3_2_2.setBounds(12, 113, 96, 38);
		pn4.add(pn3_2_2);
		pn3_2_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setBounds(0, 0, 96, 38);
		pn3_2_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		
		JPanel pn3_2_1_1 = new JPanel();
		pn3_2_1_1.setBounds(120, 112, 200, 41);
		pn4.add(pn3_2_1_1);
		pn3_2_1_1.setLayout(null);
		pn3_2_1_1.setBackground(new Color(176, 196, 222));
		
		txtPassword = new JTextField();
		txtPassword.setBounds(0, 0, 200, 41);
		pn3_2_1_1.add(txtPassword);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		txtPassword.setBackground(new Color(176, 196, 222));
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("로그인 확인");
		btnLogin.setBounds(332, 61, 140, 41);
		pn4.add(btnLogin);
		btnLogin.setBackground(new Color(250, 235, 215));
		btnLogin.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		
		btnUse = new JButton("여행지 보러가기");
		btnUse.setBounds(332, 110, 140, 41);
		pn4.add(btnUse);
		btnUse.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnUse.setBackground(new Color(250, 235, 215));
		
		btnMember = new JButton("회원가입하기");
		btnMember.setBounds(332, 10, 140, 41);
		pn4.add(btnMember);
		btnMember.setBackground(new Color(216, 191, 216));
		btnMember.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		
		btnExit = new JButton("나가기");
		btnExit.setBounds(679, 104, 153, 47);
		pn4.add(btnExit);
		btnExit.setBackground(new Color(211, 211, 211));
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(105, 105, 105));
		panel_2_1.setBounds(0, 0, 845, 4);
		pn4.add(panel_2_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(512, 63, 332, 418);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(28, 10, 292, 398);
		pn3.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("국내 투웨이 이용방법");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		lblNewLabel_2.setBounds(12, 10, 250, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("즐거운 여행이 되시길 바랍니다");
		lblNewLabel_3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(67, 373, 207, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("1. 회원가입하기");
		lblNewLabel_4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(12, 70, 250, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("2. 로그인하기");
		lblNewLabel_4_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(12, 120, 250, 25);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("3. 지역 선택하기");
		lblNewLabel_4_2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(12, 170, 250, 25);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("4. 여행지와 먹거리 추천리스트 보기");
		lblNewLabel_4_3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		lblNewLabel_4_3.setBounds(12, 220, 250, 25);
		panel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("5. 여행가기");
		lblNewLabel_4_4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		lblNewLabel_4_4.setBounds(12, 270, 250, 25);
		panel.add(lblNewLabel_4_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 0, 4, 418);
		pn3.add(panel_3);
		panel_3.setBackground(new Color(105, 105, 105));
		
		////////////////////////////////////////////////////////////////////
		
		// 회원가입하기 버튼 클릭시 수행
		btnMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinMemberShip();
			}
		});
		
		// 나가기버튼 - btnExit
		// 마우스로 나가기버튼
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// enter키로 나가기버튼
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) System.exit(0);
			}
		});
	}
}
