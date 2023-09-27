package javaProject1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class TravelInformation extends JFrame {
	
	private JButton btnGangwon,btnChungbuk,btnGyeongnam,btnJeollbuk,btnJeju,btnGyeonggi,btnChungnam;
	private JButton btnGyeongbuk,btnJeollanam,btnCheck,btnExit;
	
	TravelListDAO dao = new TravelListDAO();
	TravelListVO tVo = null; 
	
	
	public TravelInformation(MemberVO vo) {
		setVisible(true);
		setTitle("국내 투웨이 >> 여행지찾기");
		setSize(1100,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 1084, 98);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("여행지 찾기");
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 1060, 78);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 97, 1084, 677);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		

		btnGangwon = new JButton("강원도");
		
		btnGangwon.setBounds(281, 76, 90, 40);
		btnGangwon.setBackground(new Color(224, 255, 255));
		btnGangwon.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		panel_1.add(btnGangwon);
		
		btnChungbuk = new JButton("충청북도");
		btnChungbuk.setBounds(226, 186, 100, 40);
		btnChungbuk.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnChungbuk.setBackground(new Color(224, 255, 255));
		panel_1.add(btnChungbuk);
		
		btnGyeongnam = new JButton("경상남도");
		btnGyeongnam.setBounds(281, 386, 100, 40);
		btnGyeongnam.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnGyeongnam.setBackground(new Color(224, 255, 255));
		panel_1.add(btnGyeongnam);
		
		btnJeollbuk = new JButton("전라북도");
		btnJeollbuk.setBounds(147, 342, 100, 40);
		btnJeollbuk.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnJeollbuk.setBackground(new Color(224, 255, 255));
		panel_1.add(btnJeollbuk);
		
		btnJeollanam = new JButton("전라남도");
		btnJeollanam.setBounds(133, 444, 100, 40);
		btnJeollanam.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnJeollanam.setBackground(new Color(224, 255, 255));
		panel_1.add(btnJeollanam);
		
		btnJeju = new JButton("제주도");
		btnJeju.setBounds(104, 614, 90, 40);
		btnJeju.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnJeju.setBackground(new Color(224, 255, 255));
		panel_1.add(btnJeju);
		
		btnGyeonggi = new JButton("경기도");
		btnGyeonggi.setBounds(162, 117, 90, 40);
		btnGyeonggi.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnGyeonggi.setBackground(new Color(224, 255, 255));
		panel_1.add(btnGyeonggi);
		
		btnChungnam = new JButton("충청남도");
		btnChungnam.setBounds(133, 253, 100, 40);
		btnChungnam.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnChungnam.setBackground(new Color(224, 255, 255));
		panel_1.add(btnChungnam);
		
		btnGyeongbuk = new JButton("경상북도");
		btnGyeongbuk.setBounds(332, 253, 100, 40);
		btnGyeongbuk.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnGyeongbuk.setBackground(new Color(224, 255, 255));
		panel_1.add(btnGyeongbuk);
		

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(42, 10, 551, 657);
		lblNewLabel_1.setIcon(new ImageIcon(TravelInformation.class.getResource("/javaProject1/images/iconMap.jpg")));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(586, 0, 3, 677);
		panel_1.add(panel_4);
		panel_4.setBackground(new Color(105, 105, 105));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(176, 196, 222));
		panel_6.setBounds(617, 43, 443, 71);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("여행조건 선택하기");
		lblNewLabel_3.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 419, 51);
		panel_6.add(lblNewLabel_3);
		
		JComboBox cbKind = new JComboBox();
		cbKind.setBackground(new Color(250, 235, 215));
		cbKind.setBounds(617, 165, 264, 50);
		cbKind.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		cbKind.setModel(new DefaultComboBoxModel(new String[] {"", "산책", "체험", "바닷가", "케이블카", "워터파크", "수목원", "폭포", "동굴", "관람", "아쿠아리움"}));
		panel_1.add(cbKind);
		
		JLabel lblNewLabel_4_1 = new JLabel("----- 선택해주세요 ----- ");
		lblNewLabel_4_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(617, 115, 229, 45);
		panel_1.add(lblNewLabel_4_1);
		
		btnCheck = new JButton("검색하기");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheck.setBackground(new Color(250, 235, 215));
		btnCheck.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnCheck.setBounds(934, 166, 126, 50);
		panel_1.add(btnCheck);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("----- 지역이름과 여행지를 확인해주세요 ----- ");
		lblNewLabel_4_1_1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		lblNewLabel_4_1_1.setBounds(617, 270, 362, 45);
		panel_1.add(lblNewLabel_4_1_1);
		
		JComboBox cbArea = new JComboBox();
		cbArea.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		cbArea.setBounds(617, 330, 126, 50);
		
		panel_1.add(cbArea);
		
		JComboBox cbAddress = new JComboBox();
		cbAddress.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		cbAddress.setBounds(617, 510, 362, 50);
		panel_1.add(cbAddress);
		
		JComboBox cbTravelName = new JComboBox();
		cbTravelName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		cbTravelName.setBounds(617, 420, 362, 50);
		panel_1.add(cbTravelName);
		
		JLabel lblNewLabel_4 = new JLabel("지역");
		lblNewLabel_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(755, 332, 90, 50);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("여행지");
		lblNewLabel_4_2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		lblNewLabel_4_2.setBounds(991, 420, 90, 50);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("주소");
		lblNewLabel_4_3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 17));
		lblNewLabel_4_3.setBounds(991, 510, 90, 50);
		panel_1.add(lblNewLabel_4_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 764, 1084, 87);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 196, 222));
		panel_3.setBounds(42, 10, 489, 67);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("찾으시는 지역을 지도에서 클릭해주세요");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		lblNewLabel_2.setBounds(12, 10, 465, 47);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(586, 10, 3, 87);
		panel_2.add(panel_5);
		panel_5.setBackground(new Color(105, 105, 105));
		
		btnExit = new JButton("나가기");
		btnExit.setBackground(new Color(211, 211, 211));
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		btnExit.setBounds(911, 10, 161, 67);
		panel_2.add(btnExit);
		
		/////////////////////////////////////////////////////////////////
		
		// 콤보박스-선택후 검색하기 버튼
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String check = cbKind.getSelectedItem().toString();
				//TravelListVO vo = dao.getSelect(check);
				ArrayList<TravelListVO> vos = dao.getSelect(check);
				String[] areas = new String[vos.size()];
				String[] names = new String[vos.size()];
				String[] addresss = new String[vos.size()];
				for(int i=0; i<vos.size(); i++) {
					tVo = vos.get(i);
					areas[i] = (i+1+". ")+tVo.getArea();
					names[i] = (i+1+". ")+tVo.getName();
					addresss[i] = (i+1+". ")+tVo.getAddress();
				}
				cbArea.setModel(new DefaultComboBoxModel(areas));
				cbTravelName.setModel(new DefaultComboBoxModel(names));
				cbAddress.setModel(new DefaultComboBoxModel(addresss));
			}
		});
		
		// 나가기버튼 클릭 
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// 나가기버튼 enter키
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) dispose();
			}
		});
		
		// 강원도 버튼클릭처리
		btnGangwon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("강원도");
			}
		});
		// 경기도 버튼클릭처리
		btnGyeonggi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("경기도");
			}
		});
		// 충청북도 버튼클릭처리
		btnChungbuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("충청북도");
			}
		});
		// 충청남도 버튼클릭처리
		btnChungnam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("충청남도");
			}
		});
		// 경상북도 버튼클릭처리
		btnGyeongbuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("경상북도");
			}
		});
		// 경상남도 버튼클릭처리
		btnGyeongnam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("경상남도");
			}
		});
		// 전라북도 버튼클릭처리
		btnJeollbuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("전라북도");
			}
		});
		// 전라남도 버튼클릭처리
		btnJeollanam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("전라남도");
			}
		});
		// 제주도 버튼클릭처리
		btnJeju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreaKind("제주도");
			}
		});
	}
}
