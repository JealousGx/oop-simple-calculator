// * Java Program to design a functional calculator which calculates simple mathematical expressions
// * The output shall be in point form.

// ? AUTHOR: JealousGx 
// ? CODE COURTESY: © 2021 Geeks 4 Geeks.

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
	// create a framework
	static JFrame jFrame;

	// create a textfield
	static JTextField txtField;

	// store operator and operands
	String userInput, userInput1, userInput2;

	// default constructor
	Calculator() {
		userInput = userInput1 = userInput2 = "";
	}

	// main function
	public static void main(String args[]) {
		System.out.println("\n\n------------------------");
		System.out.println("Author: JealousGx");
		// !---- Project Source Code:
		// !---- https://www.geeksforgeeks.org/java-swing-simple-calculator/ ----!
		System.out.println("© 2021 Geeks 4 Geeks - All rights reserved.");
		System.out.println("------------------------\n\n");

		// create a frame
		jFrame = new JFrame("Calculator");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		Calculator calc = new Calculator();

		// create a textfield of 16x16
		txtField = new JTextField(16);

		// set the textfield to non editable
		txtField.setEditable(false);

		// create number buttons and some operators
		JButton butt0, butt1, butt2, butt3, butt4, butt5, butt6, butt7, butt8, butt9, buttAdd, buttSubt, buttDivision,
				buttMult, buttDot, buttCLR, buttEqual;

		// create number buttons
		butt0 = new JButton("0");
		butt1 = new JButton("1");
		butt2 = new JButton("2");
		butt3 = new JButton("3");
		butt4 = new JButton("4");
		butt5 = new JButton("5");
		butt6 = new JButton("6");
		butt7 = new JButton("7");
		butt8 = new JButton("8");
		butt9 = new JButton("9");

		// equals button
		buttEqual = new JButton("=");

		// create operator buttons
		buttAdd = new JButton("+");
		buttSubt = new JButton("-");
		buttDivision = new JButton("/");
		buttMult = new JButton("*");
		buttCLR = new JButton("C"); // Clear button

		// create dot button
		buttDot = new JButton(".");

		// create a panel
		JPanel jPanel = new JPanel();

		// add action listeners
		buttMult.addActionListener(calc);
		buttDivision.addActionListener(calc);
		buttSubt.addActionListener(calc);
		buttAdd.addActionListener(calc);
		butt9.addActionListener(calc);
		butt8.addActionListener(calc);
		butt7.addActionListener(calc);
		butt6.addActionListener(calc);
		butt5.addActionListener(calc);
		butt4.addActionListener(calc);
		butt3.addActionListener(calc);
		butt2.addActionListener(calc);
		butt1.addActionListener(calc);
		butt0.addActionListener(calc);
		buttDot.addActionListener(calc);
		buttCLR.addActionListener(calc);
		buttEqual.addActionListener(calc);

		// add elements to panel
		jPanel.add(txtField);
		jPanel.add(buttAdd);
		jPanel.add(butt1);
		jPanel.add(butt2);
		jPanel.add(butt3);
		jPanel.add(buttSubt);
		jPanel.add(butt4);
		jPanel.add(butt5);
		jPanel.add(butt6);
		jPanel.add(buttMult);
		jPanel.add(butt7);
		jPanel.add(butt8);
		jPanel.add(butt9);
		jPanel.add(buttDivision);
		jPanel.add(buttDot);
		jPanel.add(butt0);
		jPanel.add(buttCLR);
		jPanel.add(buttEqual);

		// set Background of panel
		jPanel.setBackground(Color.DARK_GRAY);

		// add panel to frame
		jFrame.add(jPanel);

		jFrame.setSize(200, 200);
		jFrame.show();
	}

	public void actionPerformed(ActionEvent e) {
		String userInput3 = e.getActionCommand();

		// if the value is a number
		if ((userInput3.charAt(0) >= '0' && userInput3.charAt(0) <= '9') || userInput3.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!userInput1.equals(""))
				userInput2 = userInput2 + userInput3;
			else
				userInput = userInput + userInput3;

			// set the value of text
			txtField.setText(userInput + userInput1 + userInput2);
		} else if (userInput3.charAt(0) == 'C') {
			// clear the one letter
			userInput = userInput1 = userInput2 = "";

			// set the value of text
			txtField.setText(userInput + userInput1 + userInput2);
		} else if (userInput3.charAt(0) == '=') {

			double total;

			// store the value in 1st
			if (userInput1.equals("+"))
				total = (Double.parseDouble(userInput) + Double.parseDouble(userInput2));
			else if (userInput1.equals("-"))
				total = (Double.parseDouble(userInput) - Double.parseDouble(userInput2));
			else if (userInput1.equals("/"))
				total = (Double.parseDouble(userInput) / Double.parseDouble(userInput2));
			else
				total = (Double.parseDouble(userInput) * Double.parseDouble(userInput2));

			// set the value of text
			txtField.setText(userInput + userInput1 + userInput2 + "=" + total);

			// convert it to string
			userInput = Double.toString(total);

			userInput1 = userInput2 = "";
		} else {
			// if there was no operand
			if (userInput1.equals("") || userInput2.equals(""))
				userInput1 = userInput3;
			// else evaluate
			else {
				double total;

				// store the value in 1st
				if (userInput1.equals("+"))
					total = (Double.parseDouble(userInput) + Double.parseDouble(userInput2));
				else if (userInput1.equals("-"))
					total = (Double.parseDouble(userInput) - Double.parseDouble(userInput2));
				else if (userInput1.equals("/"))
					total = (Double.parseDouble(userInput) / Double.parseDouble(userInput2));
				else
					total = (Double.parseDouble(userInput) * Double.parseDouble(userInput2));

				// convert it to string
				userInput = Double.toString(total);

				// place the operator
				userInput1 = userInput3;

				// make the operand blank
				userInput2 = "";
			}

			// set the value of text
			txtField.setText(userInput + userInput1 + userInput2);
		}
	}
}