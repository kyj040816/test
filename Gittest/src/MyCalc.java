

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyCalc extends JFrame {
	private String exp="";//공통 변수 (버튼을 누르면 거기에 적힌 문자나 숫자가 입력되도록 하기 위해)
	private int i=0;  
	private Stack<Character> stack = new Stack<>();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCalc frame = new MyCalc();
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
	public MyCalc() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("^(제곱)");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"^";
				stack.push('^');
				textField.setText(exp);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("0");
		textField.setEditable(false);
		panel.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Status (음수취급을 할려면 괄호를 사용해주세요)         ");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(5, 4, 10, 5));
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"7";
				stack.push('7');
				textField.setText(exp);
			}
		});
		
		JButton btnNewButton_16 = new JButton("(");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"(";
				stack.push('(');
				textField.setText(exp);
				i=i+1;
			}
		});
		panel_2.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton(")");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i!=0) {
					exp=exp+")";
					stack.push(')');
					textField.setText(exp);
					i=i-1;
				}
				
			}
		});
		panel_2.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton(".");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+".";
				stack.push('.');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("<-");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!stack.isEmpty()) {
			        char last = stack.peek(); 
			        if(last == '(') {
			            i = i - 1;
			        }
			        else if(last == ')') {
			            i = i + 1;
			        }
			        stack.pop(); 
			        
			        StringBuilder sb = new StringBuilder();
			        for (Character ch : stack) {
			            sb.append(ch);
			        }
			        exp = sb.toString();
			        textField.setText(exp); 
			    }
			}
		});
		panel_2.add(btnNewButton_19);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"8";
				stack.push('8');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"9";
				stack.push('9');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"/";
				stack.push('/');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"4";
				stack.push('4');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"5";
				stack.push('5');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"6";
				stack.push('6');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("*");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"*";
				stack.push('*');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("1");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"1";
				stack.push('1');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("2");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"2";
				stack.push('2');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("3");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"3";
				stack.push('3');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("-");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"-";
				stack.push('-');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("0");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"0";
				stack.push('0');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_13);
		
		JButton btnNewButton_12 = new JButton("C");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp="";
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_14 = new JButton("=");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String postfix = Infix2Postfix.convert(exp);
					double value = Cale.eval(postfix);
					textField.setText(String.valueOf(value));
				}catch(Exception ex) {
					textField.setText("현재 이곳에서 계산이 불가한 수식입니다");
				}
			}
		});
		panel_2.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("+");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp=exp+"+";
				stack.push('+');
				textField.setText(exp);
			}
		});
		panel_2.add(btnNewButton_15);
	}

	public JTextField getTextField() {
		return textField;
	}
}
