import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.JTextArea;

import javax.swing.*;
public class Calculator1 extends JFrame{

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenu help;
	private JMenuItem close;
	private JMenuItem copy;
	private JMenuItem view;
	private JMenuItem about;
	
	private JTextArea display;
	
	private JButton clear;
	private JButton equals;
	private JButton zero;
	private JButton decimal;
	private JButton posneg;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	
	private JButton divide;
	private JButton multiply;
	private JButton add;
	private JButton subtract;

	private double temp = 0.0;

	
	private boolean[] operation = new boolean[4];
	
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
				System.out.println("could not load system look.");
			}
		
		new Calculator1();
	}
	
	public Calculator1(){
		super("Calculator");
		sendMenuBar();		
		sendDisplay();
		sendButtons();
		sendUI(this);
	}
	



	private void sendMenuBar() {
		
		
		menuBar = new JMenuBar();
		file = new JMenu(" File ");
		edit = new JMenu(" Edit ");
		help = new JMenu(" Help ");
		close = new JMenuItem("Close");
		copy = new JMenuItem("Copy");
		view = new JMenuItem("View Help");
		about = new JMenuItem("About Calculator");
		setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);}
			});
		copy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String display_c = display.getText();
				StringSelection string = new StringSelection(display_c);
				Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
				system.setContents(string, string);
				
			}
		});
		
		view.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,
			"there are currently no help topics topics to view", "Calculator",
			JOptionPane.OK_OPTION);
				
			}
		});
		
		about.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,
				"Chris's Calculator 2015", "Calculator",
				JOptionPane.OK_OPTION);	
			}
		});
		
		file.add(close);
		edit.add(copy);
		help.add(view);
		help.add(about);
	}

	
	private void sendDisplay() {
		display = new JTextArea("0");
		display.setBounds(10, 10, 274, 45);
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.PLAIN, 32));
		add(display);
		
	}
	
	

	private void sendButtons() {
		add = new JButton("+");
		add.setBounds(219, 70, 65, 55);
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setTemp(Double.parseDouble(display.getText()));
				display.setText("0");
				operation[3] = true;
				System.out.println(getTemp());
			}
		});
		add(add);
		
		subtract = new JButton("-");
		subtract.setBounds(219, 130, 65, 55);
		subtract.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setTemp(Double.parseDouble(display.getText()));
				display.setText("0");
				operation[2] = true;
				System.out.println(getTemp());
			}
		});
		add(subtract);
		
		multiply = new JButton("x");
		multiply.setBounds(219, 190, 65, 55);
		multiply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setTemp(Double.parseDouble(display.getText()));
				display.setText("0");
				operation[1] = true;
				System.out.println(getTemp());
			}
		});
		add(multiply);
		
		divide = new JButton("/");
		divide.setBounds(219, 250, 65, 55);
		divide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setTemp(Double.parseDouble(display.getText()));
				display.setText("0");
				operation[0] = true;
				System.out.println(getTemp());
			}
		});
		add(divide);
		
		clear = new JButton("Clear");
		clear.setBounds(150, 310, 135, 55 );
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			display.setText("0");
			setTemp(0.0);
			for(int i = 0; i <=3; i++){
				operation[i] = false;
			}
			}
		});
		add(clear);
		
		equals = new JButton(" = ");
		equals.setBounds(10, 310, 135, 55 );
		equals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (operation[0]) 
					display.setText(Double.toString(getTemp() / Double.parseDouble(display.getText()) ));
					if (display.getText().endsWith(".0"))
						display.setText(display.getText().replace(".0", ""));
				
					
					
				else if (operation[1]) 
			    	display.setText(Double.toString(getTemp() *  Double.parseDouble(display.getText()) ));
					if (display.getText().endsWith(".0"))
						display.setText(display.getText().replace(".0", ""));
				
					
					else if (operation[2]) 
					display.setText(Double.toString(getTemp() - Double.parseDouble(display.getText()) ));
					if (display.getText().endsWith(".0"))
						display.setText(display.getText().replace(".0", ""));
				
					
					else if (operation[3]) 
					display.setText(Double.toString(getTemp() + Double.parseDouble(display.getText()) ));
					if (display.getText().endsWith(".0"))
						display.setText(display.getText().replace(".0", ""));
					for(int i = 0; i <=3; i++){
						operation[i] = false;
					}
					
			}
		});
		add(equals);
		
		zero = new JButton("0");
		zero.setBounds(10, 250, 65, 55);
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("0");
					return;
				}
				 display.setText(display.getText() + 0);
			}
			
		});
		add(zero);
		 
		decimal = new JButton(".");
		decimal.setBounds(80, 250, 65, 55);
		decimal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (display.getText().contains("."))
					return;
				display.append(".");
				
			}
		});
		add(decimal);
		
		posneg = new JButton("+/-");
		posneg.setBounds(150, 250, 65, 55);
		posneg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			if(display.getText().equalsIgnoreCase("0"))
				return;
display.setText(Double.toString(Double.parseDouble(display.getText()) * (-1)));
			if (display.getText().endsWith(".0"))
				display.setText(display.getText().replace(".0", ""));
			}
			
		});
		add(posneg);
		
		one = new JButton("1");
		one.setBounds(10, 190, 65, 55);
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("1");
					return;
				}
				 display.setText(display.getText() + 1);
			}
			
		});
		add(one);

		
		two = new JButton("2");
		two.setBounds(80, 190, 65, 55);
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("2");
					return;
				}
				 display.setText(display.getText() + 2);
			}
			
		});
		add(two);

		
		three = new JButton("3");
		three.setBounds(150, 190, 65, 55);
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("3");
					return;
				}
				 display.setText(display.getText() + 3);
			}
			
		});
		add(three);

		
		four = new JButton("4");
		four.setBounds(10, 130, 65, 55);
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("4");
					return;
				}
				 display.setText(display.getText() + 4);
			}
			
		});
		add(four);

		
		five = new JButton("5");
		five.setBounds(80, 130, 65, 55);
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("5");
					return;
				}
				 display.setText(display.getText() + 5);
			}
			
		});
		add(five);

		
		six = new JButton("6");
		six.setBounds(150, 130, 65, 55);
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("6");
					return;
				}
				 display.append("6");
			}
			
		});
		add(six);
		
		seven = new JButton("7");
		seven.setBounds(10, 70, 65, 55);
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("7");
					return;
				}
				 display.setText(display.getText() + 7);
			}
			
		});
		
		add(seven);
	   
		eight = new JButton("8");
		eight.setBounds(80, 70, 65, 55);
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("8");
					return;
				}
				 display.append("8");
			}
			
		});
		
		add(eight);
		
		nine = new JButton("9");
		nine.setBounds(150, 70, 65, 55);
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(display.getText().length()>10)
					return;
				if (display.getText().equalsIgnoreCase("0")){
					display.setText("9");
					return;
				}
				 display.setText(display.getText() + 9);
			}
			
		});
		add(nine);
		
	
	}
	
	private void sendUI(Calculator1 app){
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(300, 430);
		app.setResizable(false);
		app.setLayout(null);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		
	}
	public double getTemp(){
		return temp;
	}
	
	public void setTemp(double temp){
		this.temp = temp;
	}

	
	
	
	}

