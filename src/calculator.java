import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 */

/**
 * @author michaelberezanich@gmail.com
 *
 */
public class calculator extends JFrame{

	public calculator(){
		super ("calculator");
		setSize(260,400);
		setResizable(false);
		
		final JTextField text = new JTextField();
		Dimension dimension = new Dimension(260, 60);
		Font font = new Font("Purisa", Font.BOLD, 32);
		
		text.setPreferredSize(dimension);
		text.setFont(font);
		
		getContentPane().add(text, BorderLayout.NORTH);
		getContentPane().add(new calculatorButtons(text), BorderLayout.CENTER);
		
		this.setTitle("Calculator");
		
		setVisible(true);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		calculator calc = new calculator();

		
	}

}
