import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class AgeCalculator {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Age Calculator");
		// set layout as 'FlowLayout.CENTER'
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setSize(700,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel.setPreferredSize(new Dimension(800, 70));
		panel1.setPreferredSize(new Dimension(800, 100));
		
		JLabel label = new JLabel("Age Calculator");
		label.setFont(new Font("Verdana",1,20));
		JLabel label1 = new JLabel("Enter your date of birth (YYYY-MM-DD) : " );
		label.setFont(new Font("Verdana",1,20));
		
		frame.add(panel);
		panel.add(label);
		panel1.add(label1);
		frame.add(panel1);
		
		JTextField text = new JTextField("",20);		
		panel1.add(text);
		//Create button components
		JButton btn = new JButton("Calculate!!");
		panel1.add(btn);			
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					LocalDate currentDate = LocalDate.now();
					LocalDate date = LocalDate.parse(text.getText());
					if (date.isAfter(currentDate)) {
						JOptionPane.showMessageDialog(frame, "Error Message: Please enter valid Birth date.");
					} else {
						Period difference = Period.between(date, currentDate);
						int age = difference.getYears();
						JOptionPane.showMessageDialog(frame, "You are " + age + " years old.");
					}					
				}catch(DateTimeParseException e){
					JOptionPane.showMessageDialog(frame, "Error Message: Your date format is invalid.");
				}
			}
		});		
		frame.setVisible(true);
	}
}