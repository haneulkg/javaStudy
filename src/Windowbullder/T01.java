package Windowbullder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class T01 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMid,txtName,txtsosuk;
	private JButton btnInput,btnClose,btnReset;
	private JPasswordField txtPwd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T01 frame = new T01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T01() {
		setTitle("스윙연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 창");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 30));
		lblNewLabel.setBounds(91, 10, 581, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(91, 120, 120, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(91, 200, 120, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("소속");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(91, 360, 120, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("소속");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		lblNewLabel_1_1_2.setBounds(40, 378380, 120, 40);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("성명");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(91, 280, 120, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		txtMid.setBounds(285, 121, 354, 40);
		contentPane.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(285, 281, 354, 40);
		contentPane.add(txtName);
		
		txtsosuk = new JTextField();
		txtsosuk.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		txtsosuk.setColumns(10);
		txtsosuk.setBounds(285, 361, 354, 40);
		contentPane.add(txtsosuk);
		
		// 회원가입 버튼
		JButton btnInput = new JButton("회원가입");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "아이디 : " + txtMid.getText() + "\n";
				str += "비밀번호 : " + txtPwd.getText() + "\n";
				str += "성 명 : " + txtName.getText() + "\n";
				str += "소 속 : " + txtsosuk.getText() + "\n";
				
				JOptionPane.showMessageDialog(null, str);
			}
		});
		btnInput.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		btnInput.setBounds(70, 464, 150, 40);
		contentPane.add(btnInput);
		
		// 리셋 버튼
		JButton btnReset = new JButton("다시입력");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtsosuk.setText("");
			}
		});
		btnReset.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		btnReset.setBounds(300, 464, 150, 40);
		contentPane.add(btnReset);
		
		
		// 창닫기 버튼
		JButton btnClose = new JButton("창닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		btnClose.setBounds(520, 464, 150, 40);
		contentPane.add(btnClose);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		txtPwd.setBounds(285, 201, 354, 40);
		contentPane.add(txtPwd);
	}
}
