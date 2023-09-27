package javaProject1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class JoinMemberShip extends JFrame{
	
	private JTextField txtName,txtNickName,txtEmail,txtPassword,txtAge,txtPhoneNum;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnCheck, btnExit1;
	private JRadioButton rdMale, rdFemale;
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = null;
	
	int res = 0;
	
	public JoinMemberShip() {
		setTitle("국내 투웨이 >> 회원가입");
		setSize(1100,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 1084, 96);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JPanel pn1_1 = new JPanel();
		pn1_1.setBackground(new Color(250, 235, 215));
		pn1_1.setBounds(12, 10, 1060, 76);
		pn1.add(pn1_1);
		pn1_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 28));
		lblNewLabel.setBounds(12, 10, 1036, 56);
		pn1_1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 106, 1084, 550);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JPanel pn1_2 = new JPanel();
		pn1_2.setBounds(537, 0, 3, 550);
		pn2.add(pn1_2);
		pn1_2.setBackground(new Color(105, 105, 105));
		pn1_2.setLayout(null);
		
		txtName = new JTextField();
		txtName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtName.setBackground(new Color(176, 196, 222));
		txtName.setBounds(30, 100, 370, 60);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtNickName = new JTextField();
		txtNickName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtNickName.setColumns(10);
		txtNickName.setBackground(new Color(176, 196, 222));
		txtNickName.setBounds(30, 270, 370, 60);
		pn2.add(txtNickName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(176, 196, 222));
		txtEmail.setBounds(30, 440, 200, 60);
		pn2.add(txtEmail);
		
		JLabel lblNewLabel_1 = new JLabel("성명 입력란");
		lblNewLabel_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 20, 200, 55);
		pn2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1_1 = new JLabel("닉네임 입력란");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(30, 190, 170, 55);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("이메일 입력란");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(30, 360, 170, 55);
		pn2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("비밀번호 입력란(8자리 이하의 숫자)");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(590, 20, 332, 55);
		pn2.add(lblNewLabel_1_3);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtPassword.setColumns(10);
		txtPassword.setBackground(new Color(176, 196, 222));
		txtPassword.setBounds(590, 100, 370, 60);
		pn2.add(txtPassword);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("나이 입력란");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(590, 190, 170, 55);
		pn2.add(lblNewLabel_1_1_1);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtAge.setColumns(10);
		txtAge.setBackground(new Color(176, 196, 222));
		txtAge.setBounds(590, 270, 370, 60);
		pn2.add(txtAge);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBackground(new Color(176, 196, 222));
		txtPhoneNum.setBounds(590, 440, 370, 60);
		pn2.add(txtPhoneNum);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("전화번호 입력란(형식:000-0000-0000)");
		lblNewLabel_1_2_1.setBounds(590, 360, 359, 55);
		pn2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		
		JComboBox cbEmail = new JComboBox();
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"@naver.com", "@google.com", "@gmail.com", "@daum.net", "@kakao.com", "기타(메일주소 전부 입력)"}));
		cbEmail.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		cbEmail.setBounds(240, 440, 160, 60);
		pn2.add(cbEmail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setBounds(537, 540, 547, 3);
		pn2.add(panel_2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 651, 1084, 210);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(537, 0, 3, 210);
		pn3.add(panel);
		panel.setBackground(new Color(105, 105, 105));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBounds(30, 90, 370, 60);
		pn3.add(panel_1);
		panel_1.setLayout(null);
		
		rdMale = new JRadioButton("남자");
		rdMale.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		rdMale.setBounds(22, 0, 119, 54);
		rdMale.setBackground(new Color(176, 196, 222));
		buttonGroup.add(rdMale);
		panel_1.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		rdFemale.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		rdFemale.setBounds(184, 0, 119, 54);
		rdFemale.setBackground(new Color(176, 196, 222));
		buttonGroup.add(rdFemale);
		panel_1.add(rdFemale);
		
		btnCheck = new JButton("회원가입완료");
		btnCheck.setBounds(590, 42, 150, 110);
		pn3.add(btnCheck);
		btnCheck.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		btnCheck.setBackground(new Color(255, 192, 203));
		
		btnExit1 = new JButton("가입취소");
		btnExit1.setBounds(867, 42, 150, 110);
		pn3.add(btnExit1);
		btnExit1.setBackground(new Color(211, 211, 211));
		btnExit1.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		
		JLabel lblNewLabel_2 = new JLabel("성별 선택란");
		lblNewLabel_2.setBounds(30, 10, 170, 55);
		pn3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		
		
		
		/////////////////////////////////////////////////////////////////
		
		// 회원가입완료버튼 - btnCheck 클릭시
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getMemberLogin();
			}
		});
		
		// 회원가입완료버튼 - btnCheck enter키
		btnCheck.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("btnCheck");
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getMemberLogin();
			}
		});
		
		
		// 나가기버튼 - btnExit
		// 마우스로 나가기버튼
		btnExit1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		// enter키로 나가기버튼
		btnExit1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) dispose();
			}
		});
		
		
		}

		// 회원가입 완료버튼 
		protected void getMemberLogin() {
			String name = txtName.getText();
			String nickName = txtNickName.getText();
			String email = txtEmail.getText();
			int age;
			String gender;
			int password;
			String phoneNum = txtPhoneNum.getText();
			
			if(name.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "성명을 입력해주세요");
				txtName.requestFocus();
			}
			else if(nickName.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "닉네임을 입력해주세요");
				txtNickName.requestFocus();
			}
			else if(email.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "이메일 주소를 입력해주세요");
				txtEmail.requestFocus();
			}
			else if(txtAge.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "나이를 입력해주세요");
				txtAge.requestFocus();
			}
			else if(!Pattern.matches("^[0-9]*$", txtAge.getText())) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력해주세요");
				txtAge.requestFocus();
			}
			else if(txtPassword.getText().length()>8) {
				JOptionPane.showMessageDialog(null, "패스워드는 8자리까지 가능합니다");
				txtPassword.requestFocus();
			}
			else if(txtPassword.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요");
				txtPassword.requestFocus();
			}
			else if(!Pattern.matches("^[0-9]*$", txtPassword.getText())) {
				JOptionPane.showMessageDialog(null, "패스워드는 숫자로 입력해주세요");
				txtPassword.requestFocus();
			} 
			else if(phoneNum.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요");
				txtPhoneNum.requestFocus();
			}
			else if(!Pattern.matches("^[0-9]{3}-?[0-9]{4}-?[0-9]{4}$", phoneNum)) {
				JOptionPane.showMessageDialog(null, "전화번호를 형식에 알맞게 입력해주세요");
				txtPhoneNum.requestFocus();
			}
			else {
				if(rdFemale.isSelected()) gender="여자";
				else gender = "남자";
				age = Integer.parseInt(txtAge.getText());
				password = Integer.parseInt(txtPassword.getText());
				
				vo = dao.getNickNameSearch(nickName);
				if(vo.getNickName() != null) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 닉네임입니다, 다시 입력해주세요");
					txtNickName.requestFocus();
				}
				else {
					vo.setName(name);
					vo.setNickName(nickName);
					vo.setEmail(email);
					vo.setAge(age);
					vo.setPassword(password);
					vo.setPhoneNum(phoneNum);
					
					res = dao.setMemberInput(vo);
					
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원가입실패 : 다시 가입해주세요");
						txtName.requestFocus();
					}
					else JOptionPane.showMessageDialog(null, "회원가입성공 : 환영합니다");
						dispose();
						new Main();
				}	
		
			
		}
	}
}

