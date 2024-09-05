package com.example.calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

public class CalculatorGUI extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private String input;
	private Calculator cal = new Calculator();
	
	public CalculatorGUI() {
		// Set up GUI panel
		setSize(500,500);
		
		Container container = this.getContentPane();
		JPanel panel = new JPanel();
		textField = new JTextField(50);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.LEFT);
		textField.setPreferredSize(new Dimension(200,50));
		container.add(textField, BorderLayout.NORTH);
		
		input = ""; // set initial input as ""
		
		// Set labels of buttons, and add them into the panel
		String[] labels= {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
		panel.setLayout(new GridLayout(4,4,1,1));
		
		for(int i=0;i<labels.length;i++) {
			JButton button = new JButton(labels[i]);
			button.addActionListener(this);
			panel.add(button);
		}
		container.add(panel, BorderLayout.CENTER);
	}
	
	//Listen input commands
	@Override
	public void actionPerformed(ActionEvent e) {
		int InputCount=0;
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("*")
				|| actionCommand.equals("/")) {
			input += " " + actionCommand + " ";
		}
		else if(actionCommand.equals("C")) {
			input = "";
		} 
		else if(actionCommand.equals("=")) {
			try {
				input+= "="+ cal.calculate(input);
			} catch (Exception ex) {
				if(ex.getMessage().equals("Infinity"))
					input+= "=" + ex.getMessage();
				else
					input = ex.getMessage();
			}
			textField.setText(input);
			input="";
			InputCount = 1;
		}
		else {
			input += actionCommand;
		}
		
		if(InputCount == 0) {
			textField.setText(input);
		}
	}

	public static void main(String[] args) {
		CalculatorGUI calGUI = new CalculatorGUI();
		calGUI.setVisible(true);
		calGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}