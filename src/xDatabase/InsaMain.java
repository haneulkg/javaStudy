package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InsaMain extends JFrame {

	private JPanel contentPane;
	JButton btnInput, btnSearch, btnList, btnExit;
	
	

	public InsaMain() {
		setTitle("인사관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(250, 235, 215));
		pn1.setBounds(0, 0, 784, 103);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사관리 프로그램(v1.0)");
		lblNewLabel.setBackground(new Color(255, 218, 185));
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 760, 83);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 107, 784, 331);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon(InsaMain.class.getResource("/xDatabase/images/main.jpg")));
		lblMain.setBounds(0, 0, 784, 331);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 448, 784, 103);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setBackground(new Color(119, 136, 153));
		btnInput.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		btnInput.setBounds(39, 24, 147, 55);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setBackground(new Color(119, 136, 153));
		btnSearch.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		btnSearch.setBounds(225, 24, 147, 55);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setBackground(new Color(119, 136, 153));
		btnList.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		btnList.setBounds(411, 24, 147, 55);
		pn3.add(btnList);
		
		btnExit = new JButton("종 료");
		btnExit.setBackground(new Color(119, 136, 153));
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		btnExit.setBounds(597, 24, 147, 55);
		pn3.add(btnExit);
	
		///////////////////////////////////////////////////////////////
		
		// 사원등록버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
		
		// 개별사원조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 존재하지 않습니다");
				else new InsaSearch(vo);
			}
		});
		
		// 전체사원조회
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaMain frame = new InsaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
