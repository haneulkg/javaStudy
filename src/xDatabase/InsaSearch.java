package xDatabase;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsaSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFemale;
	private JButton btnUpdate, btnDelete, btnClose;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;

	int res = 0;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		new InsaSearch(vo);
//	}
	
	public InsaSearch(InsaVO vo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(250, 250, 210));
		pn1.setBounds(0, 0, 784, 75);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 개 별 조 회 (검색할 성명을 입력하세요)");
		lblNewLabel.setBackground(new Color(255, 228, 196));
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 760, 55);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 85, 784, 349);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성  명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		lblName.setBounds(77, 20, 145, 50);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나  이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		lblAge.setBounds(77, 99, 145, 50);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성  별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		lblGender.setBounds(77, 170, 145, 50);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입 사 일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		lblIpsail.setBounds(77, 259, 145, 50);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setBackground(new Color(176, 196, 222));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		txtName.setBounds(260, 24, 408, 44);
		txtName.setText(vo.getName());
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBackground(new Color(176, 196, 222));
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		txtAge.setColumns(10);
		txtAge.setBounds(260, 103, 408, 44);
		txtAge.setText(vo.getAge()+"");
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남  자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		rdMale.setBounds(260, 173, 157, 44);
		buttonGroup.add(rdMale);
		
		if(vo.getGender().equals("남자")) rdMale.setSelected(true);
		
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여  자");
		rdFemale.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		rdFemale.setBounds(478, 173, 157, 44);
		buttonGroup.add(rdFemale);
		
		if(vo.getGender().equals("여자")) rdFemale.setSelected(true);
		
		pn2.add(rdFemale);
		
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		
//		int imsi;
		for(int i=0; i<yy.length; i++) {
//			imsi = i + 2000;
			yy[i] = (i+2000)+"";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1)+"";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1)+"";
		}

		String[] ymds = vo.getIpsail().substring(0, 10).split("-"); 	// 년-월-일
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 22));
		cbYY.setBounds(260, 259, 102, 44);
		cbYY.setSelectedItem(ymds[0]);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 22));
		cbMM.setBounds(419, 259, 102, 44);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 22));
		cbDD.setBounds(572, 259, 102, 44);
		cbDD.setSelectedItem(ymds[2]);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 22));
		lblYY.setHorizontalAlignment(SwingConstants.CENTER);
		lblYY.setBounds(360, 259, 57, 44);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setHorizontalAlignment(SwingConstants.CENTER);
		lblMM.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 22));
		lblMM.setBounds(517, 259, 57, 44);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setHorizontalAlignment(SwingConstants.CENTER);
		lblDD.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 22));
		lblDD.setBounds(674, 259, 57, 44);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 444, 784, 117);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		btnUpdate.setBounds(49, 20, 195, 75);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		btnDelete.setBounds(293, 20, 195, 75);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 25));
		btnClose.setBounds(537, 20, 195, 75);
		pn3.add(btnClose);
		
		/////////////////////////////////////////////////////////
		
		// 회원정보수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// 다시입력 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		// 창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
