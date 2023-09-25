package xDatabase;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InsaList extends JFrame {
	
	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	private ButtonGroup genderGroup = new ButtonGroup();
	private JButton btnCondition, btnExit, btnList;
	private JComboBox cbCondition;
	
	@SuppressWarnings("rawtypes")
	Vector title,vData;
	DefaultTableModel dtm;
	
	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;
	
	@SuppressWarnings("unchecked")
	public InsaList() {
		setTitle("JTable 연습(DB에서 값 가져와서 JTalbe에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		setVisible(true);	// 메인은 1개만 있어야하므로 메인삭제 후 작성함
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 66);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		btnExit = new JButton("종  료");
		btnExit.setBackground(new Color(216, 191, 216));
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		btnExit.setBounds(611, 10, 147, 42);
		pn1.add(btnExit);
		
		cbCondition = new JComboBox();
		cbCondition.setBackground(new Color(250, 235, 215));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));
		cbCondition.setBounds(23, 10, 96, 42);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));
		txtCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtCondition.setBounds(142, 10, 147, 42);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new JButton("조건검색");
		btnCondition.setBackground(new Color(176, 196, 222));
		btnCondition.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnCondition.setBounds(312, 10, 115, 42);
		pn1.add(btnCondition);
		
		btnList = new JButton("전체검색");
		btnList.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnList.setBackground(new Color(176, 196, 222));
		btnList.setBounds(450, 11, 138, 41);
		pn1.add(btnList);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 88, 784, 360);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 456, 784, 105);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnNameAsc = new JButton("성명오름차순");
		btnNameAsc.setBackground(new Color(119, 136, 153));
		btnNameAsc.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnNameAsc.setBounds(404, 10, 154, 36);
		pn3.add(btnNameAsc);
		
		JButton btnNameDesc = new JButton("성명내림차순");
		btnNameDesc.setBackground(new Color(119, 136, 153));
		btnNameDesc.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnNameDesc.setBounds(404, 59, 154, 36);
		pn3.add(btnNameDesc);
		
		JButton btnIpsailAsc = new JButton("입사일오름차순");
		btnIpsailAsc.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnIpsailAsc.setBackground(new Color(119, 136, 153));
		btnIpsailAsc.setBounds(601, 10, 154, 36);
		pn3.add(btnIpsailAsc);
		
		JButton btnIpsailDesc = new JButton("입사일내림차순");
		btnIpsailDesc.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnIpsailDesc.setBackground(new Color(119, 136, 153));
		btnIpsailDesc.setBounds(601, 59, 154, 36);
		pn3.add(btnIpsailDesc);
		
		JRadioButton rdFemale = new JRadioButton("여    자");
		rdFemale.setBackground(new Color(143, 188, 143));
		rdFemale.setHorizontalAlignment(SwingConstants.LEFT);
		rdFemale.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		rdFemale.setBounds(18, 10, 105, 36);
		genderGroup.add(rdFemale);
		pn3.add(rdFemale);
		
		JRadioButton rdMale = new JRadioButton("남    자");
		rdMale.setBackground(new Color(143, 188, 143));
		rdMale.setHorizontalAlignment(SwingConstants.LEFT);
		rdMale.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		rdMale.setBounds(18, 59, 105, 36);
		genderGroup.add(rdMale);
		pn3.add(rdMale);
		
		JButton btnGenderSearch = new JButton("성별검색");
		btnGenderSearch.setBackground(new Color(176, 196, 222));
		btnGenderSearch.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 15));
		btnGenderSearch.setBounds(146, 10, 98, 85);
		pn3.add(btnGenderSearch);
		
		// ** JTable 설계하기 **
		// - 부제목(서브타이틀)과 데이터를 Vector 타입으로 준비한다
		
		// 1. 부제목을 Vector타입으로 준비하기
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. 데이터를 Vector타입으로 준비하기 - 데이터는 Database에서 가져오기
		vData = dao.getInsaList();
		
		// 3. DB에서 가져온 자료를 DefaultTableModel에 (를 생성하면서) 담아주기
		dtm = new DefaultTableModel(vData, title);
		
		// 4. DefaultTableModel에 담긴 Vector형식의 자료와 타이틀로 JTable을 생성시키기(생성시 담아주기)
		tbl = new JTable(dtm);
		tbl.setBackground(new Color(250, 235, 215));	// 디자인
		
		// 5. 자료가 담긴 table을 JScrollPane생성시에 함께 담아서 생성하기
		sp = new JScrollPane(tbl);
		sp.setBounds(12, 61, 760, 289);					// 디자인
		
		// 6. JScrollPane을 패널에 올려주기
		pn2.add(sp);
		tbl.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));	// 디자인
		
		// JTable안의 셀의 내용을 가운데정렬하기
		tableCellAlign(tbl);
		
		// 0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
		
		////////////////////////////////////////////////////////////////////////////////
		
		// 성별버튼 클릭시 성별별로 조회하기
		/*
		// 남자 라디오버튼 클릭시 남자만 검색하기
		rdMale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vData = dao.getGender("남자");
				dtm.setDataVector(vData, title);
			}
		});
		
		// 여자 라디오버튼 클릭시 여자만 검색하기
		rdFemale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vData = dao.getGender("여자");
				dtm.setDataVector(vData, title);
			}
		});
		*/
		// 성별 라디오버튼으로 성별을 선택 -> '성별버튼'클릭시 해당 자료만 검색 -> 출력하기
		btnGenderSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdMale.isSelected()) gender = "남자";
				else gender = "여자";
				
				vData = dao.getGender(gender);
				dtm.setDataVector(vData, title);
				
				////////////////////////////////////
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 입사일 오름차순 버튼
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail","a");
				dtm.setDataVector(vData, title);
				
				////////////////////////////////////
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 입사일 내림차순 버튼
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail","d");
				dtm.setDataVector(vData, title);
				
				////////////////////////////////////
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 성명 오름차순 버튼
		btnNameAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name","a");
				dtm.setDataVector(vData, title);
				
				////////////////////////////////////
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 성명 내림차순 버튼
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name", "d");
				dtm.setDataVector(vData, title);
				
				////////////////////////////////////
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// table안의 셀을 클릭할때 입력된 정보 가져오기
		tbl.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				
				Object value = tbl.getValueAt(row, col);	// 행과 열 -> Object
			}
		});
			
		// 조건별 검색처리하기(조건버튼클릭시 처리할 내용)
		btnCondition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getConditionProcess();
			}
		});
		
		// 조건검색항목 선택 -> 조건에 필요한 검색어를 입력 -> enter키를 누르면 바로 검색 실행하기
		txtCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getConditionProcess();
			}
		});
		
		// 전체검색버튼 클릭시 실행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList();
				dtm.setDataVector(vData, title);
								
				////////////////////////////////////
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// 조건검색 콤보박스안의 항목을 변경할때마다 자동으로 커서를 입력 텍스트필드로 이동시키기
		cbCondition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
			}
		});
		
		// 종료 버튼 enter
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) dispose();
			}
		});
		
	}
	
	// 가운데 정렬시키기
	private void tableCellAlign(JTable tbl) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = tbl.getColumnModel();
		
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);;
		}
	}

	// 조건검색항목 선택 -> 조건 입력필드에서 조건 입력 -> enter누르거나 '조건버튼'을 클릭하면 수행할 내용
	@SuppressWarnings("unchecked")
	protected void getConditionProcess() {
		String cbCondi = cbCondition.getSelectedItem().toString();
		String txtCondi = txtCondition.getText();
		
		if(txtCondi.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
			txtCondition.requestFocus();
			return;
		}
		if(cbCondi.equals("성명")) vData = dao.getConditionSearch("name",txtCondi);
		else if(cbCondi.equals("나이")) {
			if(!Pattern.matches("^[0-9]*$", txtCondi)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
				txtCondition.requestFocus();
			}
			else vData = dao.getConditionSearch("age",txtCondi); 						
		}
		else if(cbCondi.equals("성별")) vData = dao.getConditionSearch("gender", txtCondi);
		else if(cbCondi.equals("입사일")) vData = dao.getConditionSearch("ipsail", txtCondi);
			
		
		dtm.setDataVector(vData, title);
		
		////////////////////////////////////
		tableCellAlign(tbl);
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
	}

}
