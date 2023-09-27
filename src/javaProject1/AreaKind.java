package javaProject1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AreaKind extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtName1;
	private JTextField txtAddress1;
	private JTextField txthashTag1;
	private JTextField txtName2;
	private JTextField txtAddress2;
	private JTextField txthashTag2;
	private JTextField txtName3;
	private JTextField txtAddress3;
	private JTextField txthashTag3;
	private JTextField txtName4;
	private JTextField txtAddress4;
	private JTextField txthashTag4;
	private JTextField txtName5;
	private JTextField txtAddress5;
	private JTextField txthashTag5;
	private JTextField txtName6;
	private JTextField txtAddress6;
	private JTextField txthashTag6;
	private JTextField txtName7;
	private JTextField txtAddress7;
	private JTextField txthashTag7;
	private JTextField txtName8;
	private JTextField txtAddress8;
	private JTextField txthashTag8;
	private JTextField txtName9;
	private JTextField txtAddress9;
	private JTextField txthashTag9;
	private JTextField txtName10;
	private JTextField txtAddress10;
	private JTextField txthashTag10;
	
	private TravelListDAO dao = new TravelListDAO();
	private TravelListVO vo = null;
	
	private String area;
	private JLabel lblNewLabel;
	private JLabel lblAreaImg;
	
	public AreaKind(String area) {
		this.area = area;
		setTitle("국내 투웨이 >> 여행지 찾기 >> "+ area);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100,900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1084, 100);
		panel.setBackground(new Color(153, 204, 153));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(area + "여행지 찾기");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 23));
		lblNewLabel.setBounds(160, 10, 901, 80);
		panel.add(lblNewLabel);
		
		lblAreaImg = new JLabel("");
		lblAreaImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreaImg.setBounds(12, 10, 120, 80);
		String IconImage = "";
		if(area.equals("강원도")) IconImage = "/javaProject1/images/강원도.jpg";
		else if(area.equals("경기도")) IconImage = "/javaProject1/images/경기도.jpg";
		else if(area.equals("경상남도")) IconImage = "/javaProject1/images/경상남도.jpg";
		else if(area.equals("경상북도")) IconImage = "/javaProject1/images/경상북도.jpg";
		else if(area.equals("전라북도")) IconImage = "/javaProject1/images/전라북도.jpg";
		else if(area.equals("전라남도")) IconImage = "/javaProject1/images/전라남도.jpg";
		else if(area.equals("충청남도")) IconImage = "/javaProject1/images/충청남도.jpg";
		else if(area.equals("충청북도")) IconImage = "/javaProject1/images/충청북도.jpg";
		else IconImage = "/javaProject1/images/제주도.jpg";
		lblAreaImg.setIcon(new ImageIcon(Main.class.getResource(IconImage)));
		panel.add(lblAreaImg);
		
		JButton btnNewButton = new JButton("나가기");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 23));
		btnNewButton.setBounds(866, 774, 206, 77);
		getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 98, 1084, 645);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setBounds(540, 0, 3, 645);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(105, 105, 105));
		panel_3.setBounds(0, 128, 1084, 3);
		panel_1.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_3_1.setBounds(0, 256, 1084, 3);
		panel_1.add(panel_3_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_3_1_1.setBounds(0, 384, 1084, 3);
		panel_1.add(panel_3_1_1);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_3_1_1_1.setBounds(0, 512, 1084, 3);
		panel_1.add(panel_3_1_1_1);
		
		JLabel lblImg2 = new JLabel("");
		lblImg2.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg2.setBounds(10, 143, 125, 103);
		panel_1.add(lblImg2);
		
		JLabel lblImg3 = new JLabel("");
		lblImg3.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg3.setBounds(10, 271, 125, 103);
		panel_1.add(lblImg3);
		
		JLabel lblImg4 = new JLabel("");
		lblImg4.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg4.setBounds(10, 399, 125, 103);
		panel_1.add(lblImg4);
		
		JLabel lblImg5 = new JLabel("");
		lblImg5.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg5.setBounds(10, 532, 125, 103);
		panel_1.add(lblImg5);
		
		JLabel lblImg6 = new JLabel("");
		lblImg6.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg6.setBounds(555, 15, 125, 103);
		panel_1.add(lblImg6);
		
		JLabel lblImg7 = new JLabel("");
		lblImg7.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg7.setBounds(555, 141, 125, 103);
		panel_1.add(lblImg7);
		
		JLabel lblImg8 = new JLabel("");
		lblImg8.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg8.setBounds(555, 271, 125, 103);
		panel_1.add(lblImg8);
		
		JLabel lblImg9 = new JLabel("");
		lblImg9.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg9.setBounds(555, 399, 125, 103);
		panel_1.add(lblImg9);
		
		JLabel lblImg10 = new JLabel("");
		lblImg10.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg10.setBounds(555, 532, 125, 103);
		panel_1.add(lblImg10);
		
		JLabel lblImg1 = new JLabel("");
		lblImg1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg1.setBounds(10, 15, 125, 103);
		panel_1.add(lblImg1);
		
		txtName1 = new JTextField();
		txtName1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName1.setBounds(168, 10, 358, 30);
		panel_1.add(txtName1);
		txtName1.setColumns(10);
		
		txtAddress1 = new JTextField();
		txtAddress1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress1.setColumns(10);
		txtAddress1.setBounds(168, 50, 358, 30);
		panel_1.add(txtAddress1);
		
		txthashTag1 = new JTextField();
		txthashTag1.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag1.setColumns(10);
		txthashTag1.setBounds(168, 88, 358, 30);
		panel_1.add(txthashTag1);
		
		txtName2 = new JTextField();
		txtName2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName2.setColumns(10);
		txtName2.setBounds(168, 141, 358, 30);
		panel_1.add(txtName2);
		
		txtAddress2 = new JTextField();
		txtAddress2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress2.setColumns(10);
		txtAddress2.setBounds(168, 181, 358, 30);
		panel_1.add(txtAddress2);
		
		txthashTag2 = new JTextField();
		txthashTag2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag2.setColumns(10);
		txthashTag2.setBounds(168, 219, 358, 30);
		panel_1.add(txthashTag2);
		
		txtName3 = new JTextField();
		txtName3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName3.setColumns(10);
		txtName3.setBounds(168, 266, 358, 30);
		panel_1.add(txtName3);
		
		txtAddress3 = new JTextField();
		txtAddress3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress3.setColumns(10);
		txtAddress3.setBounds(168, 306, 358, 30);
		panel_1.add(txtAddress3);
		
		txthashTag3 = new JTextField();
		txthashTag3.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag3.setColumns(10);
		txthashTag3.setBounds(168, 344, 358, 30);
		panel_1.add(txthashTag3);
		
		txtName4 = new JTextField();
		txtName4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName4.setColumns(10);
		txtName4.setBounds(168, 394, 358, 30);
		panel_1.add(txtName4);
		
		txtAddress4 = new JTextField();
		txtAddress4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress4.setColumns(10);
		txtAddress4.setBounds(168, 434, 358, 30);
		panel_1.add(txtAddress4);
		
		txthashTag4 = new JTextField();
		txthashTag4.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag4.setColumns(10);
		txthashTag4.setBounds(168, 472, 358, 30);
		panel_1.add(txthashTag4);
		
		txtName5 = new JTextField();
		txtName5.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName5.setColumns(10);
		txtName5.setBounds(170, 525, 358, 30);
		panel_1.add(txtName5);
		
		txtAddress5 = new JTextField();
		txtAddress5.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress5.setColumns(10);
		txtAddress5.setBounds(170, 565, 358, 30);
		panel_1.add(txtAddress5);
		
		txthashTag5 = new JTextField();
		txthashTag5.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag5.setColumns(10);
		txthashTag5.setBounds(170, 603, 358, 30);
		panel_1.add(txthashTag5);
		
		txtName6 = new JTextField();
		txtName6.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName6.setColumns(10);
		txtName6.setBounds(692, 10, 358, 30);
		panel_1.add(txtName6);
		
		txtAddress6 = new JTextField();
		txtAddress6.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress6.setColumns(10);
		txtAddress6.setBounds(692, 50, 358, 30);
		panel_1.add(txtAddress6);
		
		txthashTag6 = new JTextField();
		txthashTag6.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag6.setColumns(10);
		txthashTag6.setBounds(692, 88, 358, 30);
		panel_1.add(txthashTag6);
		
		txtName7 = new JTextField();
		txtName7.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName7.setColumns(10);
		txtName7.setBounds(692, 138, 358, 30);
		panel_1.add(txtName7);
		
		txtAddress7 = new JTextField();
		txtAddress7.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress7.setColumns(10);
		txtAddress7.setBounds(692, 178, 358, 30);
		panel_1.add(txtAddress7);
		
		txthashTag7 = new JTextField();
		txthashTag7.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag7.setColumns(10);
		txthashTag7.setBounds(692, 216, 358, 30);
		panel_1.add(txthashTag7);
		
		txtName8 = new JTextField();
		txtName8.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName8.setColumns(10);
		txtName8.setBounds(692, 266, 358, 30);
		panel_1.add(txtName8);
		
		txtAddress8 = new JTextField();
		txtAddress8.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress8.setColumns(10);
		txtAddress8.setBounds(692, 306, 358, 30);
		panel_1.add(txtAddress8);
		
		txthashTag8 = new JTextField();
		txthashTag8.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag8.setColumns(10);
		txthashTag8.setBounds(692, 344, 358, 30);
		panel_1.add(txthashTag8);
		
		txtName9 = new JTextField();
		txtName9.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName9.setColumns(10);
		txtName9.setBounds(692, 394, 358, 30);
		panel_1.add(txtName9);
		
		txtAddress9 = new JTextField();
		txtAddress9.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress9.setColumns(10);
		txtAddress9.setBounds(692, 434, 358, 30);
		panel_1.add(txtAddress9);
		
		txthashTag9 = new JTextField();
		txthashTag9.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag9.setColumns(10);
		txthashTag9.setBounds(692, 472, 358, 30);
		panel_1.add(txthashTag9);
		
		txtName10 = new JTextField();
		txtName10.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtName10.setColumns(10);
		txtName10.setBounds(692, 527, 358, 30);
		panel_1.add(txtName10);
		
		txtAddress10 = new JTextField();
		txtAddress10.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txtAddress10.setColumns(10);
		txtAddress10.setBounds(692, 567, 358, 30);
		panel_1.add(txtAddress10);
		
		txthashTag10 = new JTextField();
		txthashTag10.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 14));
		txthashTag10.setColumns(10);
		txthashTag10.setBounds(692, 605, 358, 30);
		panel_1.add(txthashTag10);
		
		//////////////////////////////////////////////////////////
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberVO vo = new MemberVO();
				new TravelInformation(vo);
				dispose();
			}
		});
		
		String icon1 = "";
		if(area.equals("강원도")) icon1 = "/javaProject1/images/강_1.jpg";
		else if(area.equals("경기도")) icon1 = "/javaProject1/images/경기_1.jpg";
		else if(area.equals("경상남도")) icon1 = "/javaProject1/images/경남_1.jpg";
		else if(area.equals("경상북도")) icon1 = "/javaProject1/images/경북_1.jpg";
		else if(area.equals("전라북도")) icon1 = "/javaProject1/images/전북_1.jpg";
		else if(area.equals("전라남도")) icon1 = "/javaProject1/images/전남_1.jpg";
		else if(area.equals("충청남도")) icon1 = "/javaProject1/images/충남_1.jpg";
		else if(area.equals("충청북도")) icon1 = "/javaProject1/images/충북_1.jpg";
		else icon1 = "/javaProject1/images/제주_1.jpg";
		lblImg1.setIcon(new ImageIcon(Main.class.getResource(icon1)));
		
		String icon2 = "";
		if(area.equals("강원도")) icon2 = "/javaProject1/images/강_2.jpg";
		else if(area.equals("경기도")) icon2 = "/javaProject1/images/경기_2.jpg";
		else if(area.equals("경상남도")) icon2 = "/javaProject1/images/경남_2.jpg";
		else if(area.equals("경상북도")) icon2 = "/javaProject1/images/경북_2.jpg";
		else if(area.equals("전라북도")) icon2 = "/javaProject1/images/전북_2.jpg";
		else if(area.equals("전라남도")) icon2 = "/javaProject1/images/전남_2.jpg";
		else if(area.equals("충청남도")) icon2 = "/javaProject1/images/충남_2.jpg";
		else if(area.equals("충청북도")) icon2 = "/javaProject1/images/충북_2.jpg";
		else icon2 = "/javaProject1/images/제주_2.jpg";
		lblImg2.setIcon(new ImageIcon(Main.class.getResource(icon2)));
		
		String icon3 = "";
		if(area.equals("강원도")) icon3 = "/javaProject1/images/강_3.jpg";
		else if(area.equals("경기도")) icon3 = "/javaProject1/images/경기_3.jpg";
		else if(area.equals("경상남도")) icon3 = "/javaProject1/images/경남_3.jpg";
		else if(area.equals("경상북도")) icon3 = "/javaProject1/images/경북_3.jpg";
		else if(area.equals("전라북도")) icon3 = "/javaProject1/images/전북_3.jpg";
		else if(area.equals("전라남도")) icon3 = "/javaProject1/images/전남_3.jpg";
		else if(area.equals("충청남도")) icon3 = "/javaProject1/images/충남_3.jpg";
		else if(area.equals("충청북도")) icon3 = "/javaProject1/images/충북_3.jpg";
		else icon3 = "/javaProject1/images/제주_3.jpg";
		lblImg3.setIcon(new ImageIcon(Main.class.getResource(icon3)));
		
		String icon4 = "";
		if(area.equals("강원도")) icon4 = "/javaProject1/images/강_4.jpg";
		else if(area.equals("경기도")) icon4 = "/javaProject1/images/경기_4.jpg";
		else if(area.equals("경상남도")) icon4 = "/javaProject1/images/경남_4.jpg";
		else if(area.equals("경상북도")) icon4 = "/javaProject1/images/경북_4.jpg";
		else if(area.equals("전라북도")) icon4 = "/javaProject1/images/전북_4.jpg";
		else if(area.equals("전라남도")) icon4 = "/javaProject1/images/전남_4.jpg";
		else if(area.equals("충청남도")) icon4 = "/javaProject1/images/충남_4.jpg";
		else if(area.equals("충청북도")) icon4 = "/javaProject1/images/충북_4.jpg";
		else icon4 = "/javaProject1/images/제주_4.jpg";
		lblImg4.setIcon(new ImageIcon(Main.class.getResource(icon4)));
		
		String icon5 = "";
		if(area.equals("강원도")) icon5 = "/javaProject1/images/강_5.jpg";
		else if(area.equals("경기도")) icon5 = "/javaProject1/images/경기_5.jpg";
		else if(area.equals("경상남도")) icon5 = "/javaProject1/images/경남_5.jpg";
		else if(area.equals("경상북도")) icon5 = "/javaProject1/images/경북_5.jpg";
		else if(area.equals("전라북도")) icon5 = "/javaProject1/images/전북_5.jpg";
		else if(area.equals("전라남도")) icon5 = "/javaProject1/images/전남_5.jpg";
		else if(area.equals("충청남도")) icon5 = "/javaProject1/images/충남_5.jpg";
		else if(area.equals("충청북도")) icon5 = "/javaProject1/images/충북_5.jpg";
		else icon5 = "/javaProject1/images/제주_5.jpg";
		lblImg5.setIcon(new ImageIcon(Main.class.getResource(icon5)));
		
		String icon6 = "";
		if(area.equals("강원도")) icon6 = "/javaProject1/images/강_6.jpg";
		else if(area.equals("경기도")) icon6 = "/javaProject1/images/경기_6.jpg";
		else if(area.equals("경상남도")) icon6 = "/javaProject1/images/경남_6.jpg";
		else if(area.equals("경상북도")) icon6 = "/javaProject1/images/경북_6.jpg";
		else if(area.equals("전라북도")) icon6 = "/javaProject1/images/전북_6.jpg";
		else if(area.equals("전라남도")) icon6 = "/javaProject1/images/전남_6.jpg";
		else if(area.equals("충청남도")) icon6 = "/javaProject1/images/충남_6.jpg";
		else if(area.equals("충청북도")) icon6 = "/javaProject1/images/충북_6.jpg";
		else icon6 = "/javaProject1/images/제주_6.jpg";
		lblImg6.setIcon(new ImageIcon(Main.class.getResource(icon6)));
		
		String icon7 = "";
		if(area.equals("강원도")) icon7 = "/javaProject1/images/강_7.jpg";
		else if(area.equals("경기도")) icon7 = "/javaProject1/images/경기_7.jpg";
		else if(area.equals("경상남도")) icon7 = "/javaProject1/images/경남_7.jpg";
		else if(area.equals("경상북도")) icon7 = "/javaProject1/images/경북_7.jpg";
		else if(area.equals("전라북도")) icon7 = "/javaProject1/images/전북_7.jpg";
		else if(area.equals("전라남도")) icon7 = "/javaProject1/images/전남_7.jpg";
		else if(area.equals("충청남도")) icon7 = "/javaProject1/images/충남_7.jpg";
		else if(area.equals("충청북도")) icon7 = "/javaProject1/images/충북_7.jpg";
		else icon7 = "/javaProject1/images/제주_7.jpg";
		lblImg7.setIcon(new ImageIcon(Main.class.getResource(icon7)));
		
		String icon8 = "";
		if(area.equals("강원도")) icon8 = "/javaProject1/images/강_8.jpg";
		else if(area.equals("경기도")) icon8 = "/javaProject1/images/경기_8.jpg";
		else if(area.equals("경상남도")) icon8 = "/javaProject1/images/경남_8.jpg";
		else if(area.equals("경상북도")) icon8 = "/javaProject1/images/경북_8.jpg";
		else if(area.equals("전라북도")) icon8 = "/javaProject1/images/전북_8.jpg";
		else if(area.equals("전라남도")) icon8 = "/javaProject1/images/전남_8.jpg";
		else if(area.equals("충청남도")) icon8 = "/javaProject1/images/충남_8.jpg";
		else if(area.equals("충청북도")) icon8 = "/javaProject1/images/충북_8.jpg";
		else icon8 = "/javaProject1/images/제주_8.jpg";
		lblImg8.setIcon(new ImageIcon(Main.class.getResource(icon8)));
		
		String icon9 = "";
		if(area.equals("강원도")) icon9 = "/javaProject1/images/강_9.jpg";
		else if(area.equals("경기도")) icon9 = "/javaProject1/images/경기_9.jpg";
		else if(area.equals("경상남도")) icon9 = "/javaProject1/images/경남_9.jpg";
		else if(area.equals("경상북도")) icon9 = "/javaProject1/images/경북_9.jpg";
		else if(area.equals("전라북도")) icon9 = "/javaProject1/images/전북_9.jpg";
		else if(area.equals("전라남도")) icon9 = "/javaProject1/images/전남_9.jpg";
		else if(area.equals("충청남도")) icon9 = "/javaProject1/images/충남_9.jpg";
		else if(area.equals("충청북도")) icon9 = "/javaProject1/images/충북_9.jpg";
		else icon9 = "/javaProject1/images/제주_9.jpg";
		lblImg9.setIcon(new ImageIcon(Main.class.getResource(icon9)));
		
		String icon10 = "";
		if(area.equals("강원도")) icon10 = "/javaProject1/images/강_10.jpg";
		else if(area.equals("경기도")) icon10 = "/javaProject1/images/경기_10.jpg";
		else if(area.equals("경상남도")) icon10 = "/javaProject1/images/경남_10.jpg";
		else if(area.equals("경상북도")) icon10 = "/javaProject1/images/경북_10.jpg";
		else if(area.equals("전라북도")) icon10 = "/javaProject1/images/전북_10.jpg";
		else if(area.equals("전라남도")) icon10 = "/javaProject1/images/전남_10.jpg";
		else if(area.equals("충청남도")) icon10 = "/javaProject1/images/충남_10.jpg";
		else if(area.equals("충청북도")) icon10 = "/javaProject1/images/충북_10.jpg";
		else icon10 = "/javaProject1/images/제주_10.jpg";
		lblImg10.setIcon(new ImageIcon(Main.class.getResource(icon10)));
		
		vo = new TravelListVO();
		ArrayList<TravelListVO> vos = dao.getTravelListSearch(area);
		String txtName = "";
		String txtAddress = "";
		String txthashTag = "";
		
		txtName1.setText(vos.get(0).getName());
		txtAddress1.setText(vos.get(0).getAddress());
		txthashTag1.setText(vos.get(0).getHastTag1()+"  :  "+vos.get(0).getHastTag2());
		
		
		txtName2.setText(vos.get(1).getName());
		txtAddress2.setText(vos.get(1).getAddress());
		txthashTag2.setText(vos.get(1).getHastTag1()+"  :  "+vos.get(1).getHastTag2());
		
		txtName3.setText(vos.get(2).getName());
		txtAddress3.setText(vos.get(2).getAddress());
		txthashTag3.setText(vos.get(2).getHastTag1()+"  :  "+vos.get(2).getHastTag2());
		
		txtName4.setText(vos.get(3).getName());
		txtAddress4.setText(vos.get(3).getAddress());
		txthashTag4.setText(vos.get(3).getHastTag1()+"  :  "+vos.get(3).getHastTag2());
		
		txtName5.setText(vos.get(4).getName());
		txtAddress5.setText(vos.get(4).getAddress());
		txthashTag5.setText(vos.get(4).getHastTag1()+"  :  "+vos.get(4).getHastTag2());
		
		txtName6.setText(vos.get(5).getName());
		txtAddress6.setText(vos.get(5).getAddress());
		txthashTag6.setText(vos.get(5).getHastTag1()+"  :  "+vos.get(5).getHastTag2());
		
		txtName7.setText(vos.get(6).getName());
		txtAddress7.setText(vos.get(6).getAddress());
		txthashTag7.setText(vos.get(6).getHastTag1()+"  :  "+vos.get(6).getHastTag2());
		
		txtName8.setText(vos.get(7).getName());
		txtAddress8.setText(vos.get(7).getAddress());
		txthashTag8.setText(vos.get(7).getHastTag1()+"  :  "+vos.get(7).getHastTag2());
		
		txtName9.setText(vos.get(8).getName());
		txtAddress9.setText(vos.get(8).getAddress());
		txthashTag9.setText(vos.get(8).getHastTag1()+"  :  "+vos.get(8).getHastTag2());
		
		txtName10.setText(vos.get(9).getName());
		txtAddress10.setText(vos.get(9).getAddress());
		txthashTag10.setText(vos.get(9).getHastTag1()+"  :  "+vos.get(9).getHastTag2());
		
	}
}
