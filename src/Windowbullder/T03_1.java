package Windowbullder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class T03_1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JButton btnInput, btnUpdate, btnSearch, btnList, btnDelete, btnExit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T03_1 frame = new T03_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public T03_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.LIGHT_GRAY);
		pn1.setBounds(0, 0, 784, 101);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 760, 81);
		pn1.add(lblNewLabel);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(119, 136, 153));
		pn3.setBounds(0, 339, 784, 222);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("입    력");
		btnInput.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		btnInput.setBounds(92, 10, 246, 41);
		pn3.add(btnInput);
		
		btnUpdate = new JButton("수    정");
		btnUpdate.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		btnUpdate.setBounds(440, 10, 246, 41);
		pn3.add(btnUpdate);
		
		btnSearch = new JButton("개 별 조 회");
		btnSearch.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		btnSearch.setBounds(92, 84, 246, 41);
		pn3.add(btnSearch);
		
		btnDelete = new JButton("삭    제");
		btnDelete.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		btnDelete.setBounds(92, 151, 246, 41);
		pn3.add(btnDelete);
		
		btnList = new JButton("전 체 조 회");
		btnList.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		btnList.setBounds(440, 84, 246, 41);
		pn3.add(btnList);
		
		btnExit = new JButton("창 닫 기");
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		btnExit.setBounds(440, 151, 246, 41);
		pn3.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 192, 203));
		pn2.setBounds(0, 105, 784, 224);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 25));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(57, 34, 156, 44);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 25));
		lblAge.setBounds(57, 116, 156, 44);
		pn2.add(lblAge);
		
		txtName = new JTextField();
		txtName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		txtName.setBounds(257, 35, 357, 44);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		txtAge.setColumns(10);
		txtAge.setBounds(257, 116, 357, 44);
		pn2.add(txtAge);
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		// 입력 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();		// 성명으로 감
				}
				// else if(age.equals("")) {
				//	JOptionPane.showMessageDialog(null, "나이를 입력하세요");
				if(age.equals("") || !Pattern.matches("^[0-9]*$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
					txtAge.requestFocus();		
				}
				else {
					JOptionPane.showMessageDialog(null, "성명 : "+name+" , 나이: "+age);
				}
			}
		});
		
		// 수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "수정버튼을 클릭하셨습니다");
			}
		});
		// 개별조회 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "개별조회버튼을 클릭하셨습니다");
			}
		});
		// 전체조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전체조회버튼을 클릭하셨습니다");
			}
		});
		// 삭제 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "삭제버튼을 클릭하셨습니다");
			}
		});
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "작업을 종료합니다");
				System.exit(0);
			}
		});
	
		
	}
}
