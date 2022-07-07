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
		for(int i = 0; i < 10; i++) {
			try {
				int a = Integer.parseInt(scores[i][0].getText());
				System.out.println(a);
			}catch (Exception e){
				System.out.println("Not a valid Integer");
			}
			
		}
		return "ready";
	}
}
