import javax.swing.*;

public class Calculator {

	
	JLabel hinweis;
	int ergebnis;
	
	public Calculator(JLabel hinweis) {
		this.hinweis = hinweis;
		this.ergebnis = 0;
	}
	
	public String evaluate(JTextField[][] s) {
		ergebnis = 0;
		for(int i = 0; i < 10; i++) {
			int pins = this.evaluateThrow(s, i);
			if(pins >= 0) {
				this.ergebnis = this.ergebnis + pins;
			}else {
				return "Ungültig!";
			}
		}
		hinweis.setText("");
		return Integer.toString(this.getErgebnis());
	}
	
	public int evaluateThrow(JTextField[][] scores, int i) {
		//int ergebnis_throw = 0;
		int first = evaluateFirst(scores,i);
		switch (first) {
		case 10:
			if(i == 9) {
			 return 10 + evaluateFirst(scores,i+1) + evaluateSecond(scores,i+1,evaluateFirst(scores,i+1));
			}
			return checkStrike(scores,i);		
		case -1:
			return -1;
		default:
			return checkOpen(scores,i,first);
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
	
	public int checkStrike(JTextField[][] scores, int i) {
		int next1 = this.evaluateFirst(scores,i+1);
		if(next1 == 10) {
			int next2 = this.evaluateFirst(scores,i+2);
			if(next2 >= 0) {
				return 10 + next1 + next2;
			}else {
				hinweis.setText("");
				return -1;
			}
		}else {
			int next2 = this.evaluateSecond(scores,i+1,next1);
			if(next1 >= 0 && next2 >= 0 && next1 + next2 <= 10) {
				return 10 + next1 + next2;
			}else {
				hinweis.setText("Error in frame " + Integer.toString(i));
				return -1;
			}
		}
	}
	
	public int checkOpen(JTextField[][] scores, int i, int first) {
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

	public JLabel getHinweis() {
		return hinweis;
	}

	public void setHinweis(JLabel hinweis) {
		this.hinweis = hinweis;
	}

	public int getErgebnis() {
		return ergebnis;
	}

	public void setErgebnis(int ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	
}
