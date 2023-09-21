package Windowbullder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class T02 extends JFrame {
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JCheckBox chckbxHobby1, chckbxHobby2, chckbxHobby3, chckbxHobby4;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T02 frame = new T02();
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
	public T02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 21, 560, 54);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTittle = new JLabel("라디오 버튼 연습");
		lblTittle.setBackground(new Color(112, 128, 144));
		lblTittle.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 27));
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(12, 10, 536, 34);
		pn1.add(lblTittle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 97, 560, 165);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성 별");
		lblNewLabel.setFont(new Font("경기천년바탕 Bold", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(72, 39, 96, 35);
		pn2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("취 미");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("경기천년바탕 Bold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(72, 84, 96, 35);
		pn2.add(lblNewLabel_1);
		
		rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		rdbtnMale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnMale.setBounds(175, 46, 96, 20);
		buttonGroup.add(rdbtnMale);
		pn2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setSelected(true);
		rdbtnFemale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFemale.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		rdbtnFemale.setBounds(334, 46, 96, 20);
		buttonGroup.add(rdbtnFemale);
		pn2.add(rdbtnFemale);
		
		JLabel lblMsg = new JLabel("메세지 출력란");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBackground(Color.LIGHT_GRAY);
		lblMsg.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 17));
		lblMsg.setBounds(156, 127, 234, 35);
		pn2.add(lblMsg);
		
		chckbxHobby1 = new JCheckBox("등산");
		chckbxHobby1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		chckbxHobby1.setBounds(175, 82, 64, 35);
		pn2.add(chckbxHobby1);
		
		chckbxHobby2 = new JCheckBox("낚시");
		chckbxHobby2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		chckbxHobby2.setBounds(254, 82, 64, 35);
		pn2.add(chckbxHobby2);
		
		chckbxHobby3 = new JCheckBox("수영");
		chckbxHobby3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		chckbxHobby3.setBounds(336, 82, 64, 35);
		pn2.add(chckbxHobby3);
		
		chckbxHobby4 = new JCheckBox("바둑");
		chckbxHobby4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		chckbxHobby4.setBounds(426, 82, 79, 35);
		pn2.add(chckbxHobby4);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 290, 560, 61);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		// 전송 버튼
		JButton btnSubmit = new JButton("전 송");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "";
				if(rdbtnMale.isSelected()) gender = rdbtnMale.getText();
				else if(rdbtnFemale.isSelected()) gender = rdbtnFemale.getText();
				
				String hobby = "";
				if(chckbxHobby1.isSelected()) hobby += chckbxHobby1.getText() + "|";
				if(chckbxHobby2.isSelected()) hobby += chckbxHobby2.getText() + "|";
				if(chckbxHobby3.isSelected()) hobby += chckbxHobby3.getText() + "|";
				if(chckbxHobby4.isSelected()) hobby += chckbxHobby4.getText() + "|";
				
				lblMsg.setText(gender + " : "+hobby);
				JOptionPane.showMessageDialog(null, gender+ " : "+hobby);
			}
		});
		btnSubmit.setFont(new Font("경기천년바탕 Bold", Font.PLAIN, 17));
		btnSubmit.setBounds(99, 10, 144, 41);
		pn3.add(btnSubmit);
		
		JButton btnReset = new JButton("종 료");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReset.setFont(new Font("경기천년바탕 Bold", Font.PLAIN, 17));
		btnReset.setBounds(321, 10, 144, 41);
		pn3.add(btnReset);
	}
}
