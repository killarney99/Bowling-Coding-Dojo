import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input extends JFrame implements ActionListener{

	/**
	 
	 */
	JTextField[][] scores;
	JButton submit;
	JLabel ergebnis;
	private static final long serialVersionUID = 1L;

	public Input() {
		
		this.setSize(1500, 100);
		this.setTitle("Bowling Coding Dojo");
		JLabel label = new JLabel();
		label.setText("Please insert your Bowling Scores:     ");
		this.add(label);
		scores = new JTextField[10][2];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 2; j++) {
			scores[i][j] = new JTextField(5);
			this.add(scores[i][j]);	
		}
		}
		submit = new JButton("Submit");
		this.add(submit);
		submit.addActionListener(this);
		
		ergebnis = new JLabel();
		ergebnis.setText("Ergebnis: ");
		this.add(ergebnis);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.submit){
			
            ergebnis.setText(this.evaluate());
        }
		
	}
	
	public String evaluate() {
		int ergebnis = 0;
		for(int i = 0; i < 10; i++) {
			int pins = this.evaluateThrow(scores, i);
			if(pins >= 0) {
				ergebnis = ergebnis + pins;
			}else {
				return "Ungültig";
			}
		}
		return Integer.toString(ergebnis);
	}
	
	public int evaluateThrow(JTextField[][] scores, int i) {
		int ergebnis = 0;
		int first = evaluateFirst(scores,i);
		switch (first) {
		case 10:
			int next1 = evaluateFirst(scores,i+1);
			int next2 = evaluateSecond(scores,i+1,next1);
			if(next1 >= 0 && next2 >= 0) {
				ergebnis = ergebnis + 10 + next1 + next2;
				return ergebnis;
			}else {
				return -1;
			}
		case -1:
			return -1;
		default:
			int second = evaluateSecond(scores,i,first);
			if(second >= 0) {
				return first + second;
			}else {
				return -1;
			}
		}
	}
	
	public int evaluateFirst(JTextField[][] scores, int i) {
		try {
			int a = Integer.parseInt(scores[i][0].getText());
			if(a > -1 && a < 11) {
				return a;
			}else {
				return -1;
			}
			
		}catch (Exception e){
			String s = scores[i][0].getText().toUpperCase();
			switch(s) {
			case ("X"):
				System.out.println("Strike");
				return 10;
			case ("-"):
				return 0;
			case ("/"):
				System.out.println("First Throw cannot be a spare!");
				return -1;
			default:
				System.out.println("Invalid Input");
				return -1;
			
			}	
		}
	}
	
	public int evaluateSecond(JTextField[][] scores, int i, int first) {
		try{
			int a = Integer.parseInt(scores[i][1].getText());
			if(a > -1 && a < 11) {
				return a;
			}else {
				System.out.println("Invalid Input < 0 or > 10");
				return -1;
			}
		}catch (Exception e) {
			String s = scores[i][0].getText();
			switch(s) {
			case ("-"):
				return 0;
			case ("/"):
				return 10-first;
			default:
				System.out.println("Invalid Input");
				break;
			
			}
			
		}
		return -1;
	}
	
}
