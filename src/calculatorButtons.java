import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

/**
 * 
 */

/**
 * @author michaelberezanich@gmail.com
 *
 */
public class calculatorButtons extends JPanel{
	public calculatorButtons(final JTextField text){
		super();
	
		GridBagLayout gbl = new GridBagLayout();
		Insets insets = new Insets(1,1,1,1);
		setLayout(gbl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.insets = insets;
		
		final JButton button1 = new JButton("1");
		add (button1, gbc);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button1.getText());
			}
		});
		
		gbc.gridx = 1;
		final JButton button2 = new JButton("2");
		add (button2, gbc);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button2.getText());
			}
		});
		
		gbc.gridx = 2;
		final JButton button3 = new JButton("3");
		add (button3, gbc);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button3.getText());
			}
		});
		
		gbc.gridx = 3;
		final JButton buttonPlus = new JButton("+");
		add (buttonPlus, gbc);
		buttonPlus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + buttonPlus.getText());
			}
		});
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		final JButton button4 = new JButton("4");
		add (button4, gbc);
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button4.getText());
			}
		});
		
		gbc.gridx = 1;
		final JButton button5 = new JButton("5");
		add (button5, gbc);
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button5.getText());
			}
		});
		
		gbc.gridx = 2;
		final JButton button6 = new JButton("6");
		add (button6, gbc);
		button6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button6.getText());
			}
		});
		
		gbc.gridx = 3;
		gbc.fill = gbc.HORIZONTAL;
		final JButton buttonMinus = new JButton("-");
		add (buttonMinus, gbc);
		buttonMinus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + buttonMinus.getText());
			}
		});
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		final JButton button7 = new JButton("7");
		add (button7, gbc);
		button7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button7.getText());
			}
		});
		
		gbc.gridx = 1;
		final JButton button8 = new JButton("8");
		add (button8, gbc);
		button8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button8.getText());
			}
		});
		
		gbc.gridx = 2;
		final JButton button9 = new JButton("9");
		add (button9, gbc);
		button9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button9.getText());
			}
		});
		
		gbc.gridx = 3;
		gbc.fill = gbc.HORIZONTAL;
		final JButton buttonMultiply = new JButton("*");
		add (buttonMultiply, gbc);
		buttonMultiply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + buttonMultiply.getText());
			}
		});
		
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.fill = gbc.HORIZONTAL;
		final JButton button0 = new JButton("0");
		add (button0, gbc);
		button0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + button0.getText());
			}
		});
	
		gbc.gridx = 0;
		final JButton buttonPoint = new JButton(".");
		add (buttonPoint, gbc);
		buttonPoint.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + buttonPoint.getText());
			}
		});
		
		gbc.gridx = 2;
		final JButton buttonClear = new JButton("C");
		add (buttonClear, gbc);
		buttonClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText("");
			}
		});
		
		gbc.gridx = 3;
		final JButton buttonDivide = new JButton("/");
		add (buttonDivide, gbc);
		buttonDivide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				text.setText(text.getText() + buttonDivide.getText());
			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		final JButton buttonEquals = new JButton("=");
		add (buttonEquals, gbc);
		buttonEquals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				ScriptEngineManager mgr = new ScriptEngineManager();
			    ScriptEngine engine = mgr.getEngineByName("JavaScript");
			    try {
					String answer = engine.eval(text.getText()).toString();
					//This is to shorten any answers that won't fit well within the text field
					if (answer.length() > 9)
						answer = answer.substring(0, 9);
					//These next few lines are just to clean up the answers produced by the ScriptEngine
					char[] answerArray = answer.toCharArray();
					int numbersToKeep = answer.length();
					CharSequence s = ".";
					if(answer.contains(s)){
					for (int index = answer.length() - 1; answerArray[index] == '0' && answerArray[index] != '.'; index--)
						numbersToKeep--;
					}
					numbersToKeep--; //This is because the loop above stops at the decimal
					answer = answer.substring(0, numbersToKeep);
					text.setText(answer);
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		button1.setPreferredSize(new Dimension(60,60));
		button2.setPreferredSize(new Dimension(60,60));
		button3.setPreferredSize(new Dimension(60,60));
		button4.setPreferredSize(new Dimension(60,60));
		button5.setPreferredSize(new Dimension(60,60));
		button6.setPreferredSize(new Dimension(60,60));
		button7.setPreferredSize(new Dimension(60,60));
		button8.setPreferredSize(new Dimension(60,60));
		button9.setPreferredSize(new Dimension(60,60));
		button0.setPreferredSize(new Dimension(60,60));
		buttonPlus.setPreferredSize(new Dimension(60,60));
		buttonMinus.setPreferredSize(new Dimension(60,60));
		buttonMultiply.setPreferredSize(new Dimension(60,60));
		buttonDivide.setPreferredSize(new Dimension(60,60));
		buttonPoint.setPreferredSize(new Dimension(60,60));
		buttonClear.setPreferredSize(new Dimension(60,60));
		buttonEquals.setPreferredSize(new Dimension(240,60));
	}
}
