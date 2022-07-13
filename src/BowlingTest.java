import static org.junit.Assert.*;
import javax.swing.*;
import org.junit.Test;

public class BowlingTest {

	Input input;
	
	@Test
	public void test_evaluate_first0() {
		String[] scores = {"1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(1,input.getC().evaluateFirst(testField, 0));
	}
	@Test
	public void test_evaluate_second0() {
		String[] scores = {"1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(2,input.getC().evaluateSecond(testField, 0, 1));
	}
	@Test
	public void test_evaluate_first1() {
		String[] scores = {"1","2","3","4","5","1","X","-","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(10,input.getC().evaluateFirst(testField, 3));
	}
	@Test
	public void test_evaluate_second1() {
		String[] scores = {"1","2","3","4","5","1","5","6","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(6,input.getC().evaluateSecond(testField, 3, 5));
	}
	@Test
	public void test_evaluate_first2() {
		String[] scores = {"1","2","3","4","5","1","X","-","4","5","1","2","3","4","5","1","2","3","/","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(-1,input.getC().evaluateFirst(testField, 9));
	}
	@Test
	public void test_evaluate_second2() {
		String[] scores = {"1","2","3","4","5","1","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(6,input.getC().evaluateSecond(testField, 9, input.getC().evaluateFirst(testField,9)));
	}
	@Test
	public void test_evaluate_throw0() {
		String[] scores = {"1","2","3","4","5","1","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(3,input.getC().evaluateThrow(testField, 0));
	}
	@Test
	public void test_evaluate_throw1() {
		String[] scores = {"X","-","X","-","X","-","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(25,input.getC().evaluateThrow(testField, 1));
	}
	@Test
	public void test_evaluate_throw2() {
		String[] scores = {"X","-","X","-","X","-","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(-1,input.getC().evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw3() {
		String[] scores = {"X","-","X","-","X","-","5","4","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(19,input.getC().evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw4() {
		String[] scores = {"X","-","X","-","X","-","5","/","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(20,input.getC().evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw5() {
		String[] scores = {"X","-","X","-","-","-","5","/","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(0,input.getC().evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw6() {
		String[] scores = {"X","-","X","-","-","-","5","/","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(14,input.getC().evaluateThrow(testField, 3));
	}
	@Test
	public void test_evaluate_throw7() {
		String[] scores = {"X","-","X","-","X","-","5","4","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(25,input.getC().evaluateThrow(testField, 1));
	}
	@Test
	public void test_evaluate_throw8() {
		String[] scores = {"X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","X"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(30,input.getC().evaluateThrow(testField, 5));
	}
	@Test
	public void testComplete0() {
		String[] scores = {"9","-","9","-","9","-","9","-","9","-","9","-","9","-","9","-","9","-","9","-","-","-"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("90",input.getC().evaluate(testField));
	}
	@Test
	public void testComplete1() {
		String[] scores = {"5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","-","-"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("150",input.getC().evaluate(testField));
	}
	@Test
	public void testComplete2() {
		String[] scores = {"1","2","3","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","3","4","","",""};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("50",input.getC().evaluate(testField));
	}
	@Test
	public void testComplete3() {
		String[] scores = {"1","2","3","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","3","/","3",""};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("56",input.getC().evaluate(testField));
	}
	@Test
	public void testComplete4() {
		String[] scores = {"1","2","X","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","3","4","",""};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("60",input.getC().evaluate(testField));
	}
	@Test
	public void testComplete5() {
		String[] scores = {"1","2","X","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","X","-","4","4"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("71",input.getC().evaluate(testField));
	}
	@Test
	public void testComplete6() {
		String[] scores = {"1","2","X","4","4","9","2","1","1","2","3","4","4","3","2","1","1","2","X","-","4","4"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("Ungültig!",input.getC().evaluate(testField));
	}
	
	@Test
	public void test_evaluate_strikeseries() {
		String[] scores = {"X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","X"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(30,input.getC().evaluateThrow(testField, 9));
	}
	
	
	public JTextField[][] testTextField(String[] scores) {
	    JTextField[][] j = new JTextField[11][2];
	    int scoreIndex = 0;
	    for(int i = 0; i < 11; i++) {
	    	for(int k = 0; k < 2; k++) {
	    		j[i][k] = new JTextField(5);
	    		j[i][k].setText(scores[scoreIndex]);
	    		scoreIndex++;
	    	}
	    }
		return j;
	}

}
