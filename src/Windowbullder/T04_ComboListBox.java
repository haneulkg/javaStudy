package Windowbullder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class T04_ComboListBox extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T04_ComboListBox frame = new T04_ComboListBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public T04_ComboListBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 284, 291);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("직업선택을 선택하세요");
		lblNewLabel.setBackground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 260, 40);
		pn1.add(lblNewLabel);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"회사원", "학 생", "군 인", "의 사", "판 사 ", "변호사", "프리랜서", "기 타"}));
		comboJob.setBackground(new Color(250, 250, 210));
		comboJob.setBounds(12, 58, 260, 29);
		pn1.add(comboJob);
		
		JList listFood = new JList();
		listFood.setBackground(new Color(250, 235, 215));
		listFood.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 16));
		listFood.setModel(new AbstractListModel() {
			String[] values = new String[] {"짜장면", "떡볶이", "피 자", "초콜릿", "돈까스", "제육덮밥", "탕수육", "도시락", "김 밥", "샐러드", "음료수"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFood.setBounds(12, 132, 260, 149);
		pn1.add(listFood);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(296, 0, 284, 291);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 84, 226, 197);
		pn2.add(scrollPane);
		
		JList listFood2 = new JList();
		listFood2.setBackground(new Color(250, 235, 215));
		listFood2.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 16));
		listFood2.setModel(new AbstractListModel() {
			String[] values = new String[] {"짜장면", "떡볶이", "피 자", "초콜릿", "돈까스", "제육덮밥", "탕수육", "도시락", "김 밥", "샐러드", "음료수", "커 피", "라 면", "찐 빵"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listFood2);
		
		JLabel lblFood = new JLabel("좋아하는 음식을 선택하세요");
		lblFood.setBackground(new Color(211, 211, 211));
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 20));
		lblFood.setBounds(12, 21, 260, 34);
		pn2.add(lblFood);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(176, 196, 222));
		pn3.setBounds(10, 370, 562, 81);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("출 력 창");
		lblMsg.setBounds(12, 10, 205, 61);
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 15));
		pn3.add(lblMsg);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(258, 10, 281, 61);
		pn3.add(scrollPane_1);
		
		JTextArea txtaMsg = new JTextArea();
		txtaMsg.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 16));
		scrollPane_1.setViewportView(txtaMsg);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(10, 301, 562, 69);
		contentPane.add(pn4);
		pn4.setLayout(null);
		
		JButton btnCombo = new JButton("콤보출력");
		btnCombo.setBackground(new Color(119, 136, 153));
		btnCombo.setBounds(0, 10, 109, 49);
		btnCombo.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 16));
		pn4.add(btnCombo);
		
		JButton btnList3 = new JButton("리스트출력3");
		btnList3.setBackground(new Color(119, 136, 153));
		btnList3.setBounds(347, 10, 118, 49);
		btnList3.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 16));
		pn4.add(btnList3);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setBackground(new Color(119, 136, 153));
		btnExit.setBounds(459, 10, 91, 49);
		btnExit.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		pn4.add(btnExit);
		
		JButton btnList1 = new JButton("리스트출력1");
		btnList1.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 16));
		btnList1.setBackground(new Color(119, 136, 153));
		btnList1.setBounds(108, 10, 125, 49);
		pn4.add(btnList1);
		
		JButton btnList2 = new JButton("리스트출력2");
		btnList2.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 16));
		btnList2.setBackground(new Color(119, 136, 153));
		btnList2.setBounds(231, 10, 118, 49);
		pn4.add(btnList2);
		
		///////////////////////////////////////////////////////////////////////////////
		
		// 리스트박스의 내용 하나 선택 후 출력하는 버튼
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods = listFood2.getSelectedValuesList().toArray();
				String food = "";
				for(Object f : foods) food += f + "/";
				
				lblMsg.setText(food);
 			}
		});

		// 리스트박스의 내용을 TextArea에 출력하는 버튼
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods = listFood2.getSelectedValuesList().toArray();
//				String food = "";
//				for(Object f : foods) food += f + "\n";
//				
//				txtaMsg.setText(food);
				for(Object f : foods) {
					txtaMsg.append(f.toString() + "\n");
				}
			}
		});
		
		// 리스트박스의 내용을 출력하는 버튼
		btnList3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMsg.append(listFood2.getSelectedValue().toString() + "\n");
			}
		});
	
		// 콤보박스 선택내용 출력처리하기 (Button)
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString();
				lblMsg.setText(msg);
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
