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
	JLabel hinweis;
	Calculator c;
	private static final long serialVersionUID = 1L;

	public Input() {
		
		this.setSize(1500, 100);
		this.setTitle("Bowling Coding Dojo");
		JLabel label = new JLabel();
		label.setText("Please insert your Bowling Scores:     ");
		this.add(label);
		scores = new JTextField[11][2];
		for(int i = 0; i < 10; i++) {
			JLabel label_i = new JLabel();
			label_i.setText("Frame " + Integer.toString(i+1) + " :");
			this.add(label_i);
			for(int j = 0; j < 2; j++) {
			scores[i][j] = new JTextField(5);
			this.add(scores[i][j]);	
		}
		}
		JLabel label1 = new JLabel();
		label1.setText("if last one was strike or spare: ");
		this.add(label1);
		scores[10][0] = new JTextField(5);
		this.add(scores[10][0]);
		
		JLabel label2 = new JLabel();
		label2.setText("if last one was strike: ");
		this.add(label2);
		scores[10][1] = new JTextField(5);
		this.add(scores[10][1]);
		
		submit = new JButton("Submit");
		this.add(submit);
		submit.addActionListener(this);
		
		ergebnis = new JLabel();
		ergebnis.setText("Ergebnis: ");
		this.add(ergebnis);
		
		hinweis = new JLabel();
		this.add(hinweis);
		
		c = new Calculator(hinweis);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.submit){
			
            ergebnis.setText(c.evaluate(scores));
        }
		
	}

	public JTextField[][] getScores() {
		return scores;
	}

	public void setScores(JTextField[][] scores) {
		this.scores = scores;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JLabel getErgebnis() {
		return ergebnis;
	}

	public void setErgebnis(JLabel ergebnis) {
		this.ergebnis = ergebnis;
	}

	public JLabel getHinweis() {
		return hinweis;
	}

	public void setHinweis(JLabel hinweis) {
		this.hinweis = hinweis;
	}

	public Calculator getC() {
		return c;
	}

	public void setC(Calculator c) {
		this.c = c;
	}
	
	/*
	public String evaluate(JTextField[][] s) {
		int ergebnis = 0;
		for(int i = 0; i < 10; i++) {
			int pins = c.evaluateThrow(s, i);
			if(pins >= 0) {
				ergebnis = ergebnis + pins;
			}else {
				return "Ungültig!";
			}
		}
		hinweis.setText("");
		return Integer.toString(ergebnis);
	}
	
	public int evaluateThrow(JTextField[][] scores, int i) {
		int ergebnis = 0;
		int first = evaluateFirst(scores,i);
		switch (first) {
		case 10:
			if(i == 9) {
				ergebnis = ergebnis + 10 + evaluateFirst(scores,i+1) + evaluateSecond(scores,i+1,evaluateFirst(scores,i+1));
				return ergebnis;
			}
			int next1 = evaluateFirst(scores,i+1);
			if(next1 == 10) {
				int next2 = evaluateFirst(scores,i+2);
				if(next2 >= 0) {
					ergebnis = ergebnis + 10 + next1 + next2;
					return ergebnis;
				}else {
					hinweis.setText("");
					return -1;
				}
			}else {
				int next2 = evaluateSecond(scores,i+1,next1);
				if(next1 >= 0 && next2 >= 0 && next1 + next2 <= 10) {
					ergebnis = ergebnis + 10 + next1 + next2;
					return ergebnis;
				}else {
					hinweis.setText("Error in frame " + Integer.toString(i));
					return -1;
				}
			}	
		case -1:
			return -1;
		default:
			int second = evaluateSecond(scores,i,first);
			if(second >= 0) {
				if(first + second == 10) {
					return first + second + evaluateFirst(scores,i+1);
				}
				if(first + second < 10) {
					return first + second;
				}else {
					hinweis.setText("Sum in Frame " + Integer.toString(i+1) + " is more than 10");
					return -1;
				}
				
			}else {
				hinweis.setText("Second Value in Frame " + Integer.toString(i+1) + " is invalid!");
				return -1;
			}
		}
	}
	
	public int evaluateFirst(JTextField[][] scores, int i) {
		try {
			int a = Integer.parseInt(scores[i][0].getText());
			if(a > -1 && a < 10) {
				return a;
			}else {
				hinweis.setText("Invalid Input < 0 or > 10 in Frame " + Integer.toString(i));
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
				hinweis.setText("First Throw in Frame " + Integer.toString(i) + " cannot be a spare!");
				return -1;
			default:
				hinweis.setText("Invalid Input in first field of frame " + Integer.toString(i));
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
				hinweis.setText("Invalid Input < 0 or > 10 in frame " + Integer.toString(i+1));
				return -1;
			}
		}catch (Exception e) {
			String s = scores[i][1].getText().toUpperCase();
			switch(s) {
			case ("X"):
				if(i == 10) {
					return 10;
				}else {
					return -1;
				}
			case ("-"):
				return 0;
			case ("/"):
				return 10-first;
			default:
				hinweis.setText("Invalid Input in second field of frame " + Integer.toString(i+1));
				break;
			
			}
			
		}
		return -1;
	}
	*/
}
