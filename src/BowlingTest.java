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
		assertEquals(1,input.c.evaluateFirst(testField, 0));
	}
	@Test
	public void test_evaluate_second0() {
		String[] scores = {"1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(2,input.c.evaluateSecond(testField, 0, 1));
	}
	@Test
	public void test_evaluate_first1() {
		String[] scores = {"1","2","3","4","5","1","X","-","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(10,input.c.evaluateFirst(testField, 3));
	}
	@Test
	public void test_evaluate_second1() {
		String[] scores = {"1","2","3","4","5","1","5","6","4","5","1","2","3","4","5","1","2","3","4","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(6,input.c.evaluateSecond(testField, 3, 5));
	}
	@Test
	public void test_evaluate_first2() {
		String[] scores = {"1","2","3","4","5","1","X","-","4","5","1","2","3","4","5","1","2","3","/","5","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(-1,input.c.evaluateFirst(testField, 9));
	}
	@Test
	public void test_evaluate_second2() {
		String[] scores = {"1","2","3","4","5","1","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(6,input.c.evaluateSecond(testField, 9, input.c.evaluateFirst(testField,9)));
	}
	@Test
	public void test_evaluate_throw0() {
		String[] scores = {"1","2","3","4","5","1","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(3,input.c.evaluateThrow(testField, 0));
	}
	@Test
	public void test_evaluate_throw1() {
		String[] scores = {"X","-","X","-","X","-","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(25,input.c.evaluateThrow(testField, 1));
	}
	@Test
	public void test_evaluate_throw2() {
		String[] scores = {"X","-","X","-","X","-","5","6","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(-1,input.c.evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw3() {
		String[] scores = {"X","-","X","-","X","-","5","4","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(19,input.c.evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw4() {
		String[] scores = {"X","-","X","-","X","-","5","/","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(20,input.c.evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw5() {
		String[] scores = {"X","-","X","-","-","-","5","/","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(0,input.c.evaluateThrow(testField, 2));
	}
	@Test
	public void test_evaluate_throw6() {
		String[] scores = {"X","-","X","-","-","-","5","/","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(14,input.c.evaluateThrow(testField, 3));
	}
	@Test
	public void test_evaluate_throw7() {
		String[] scores = {"X","-","X","-","X","-","5","4","4","5","1","2","3","4","5","1","2","3","4","/","1","2"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(25,input.c.evaluateThrow(testField, 1));
	}
	@Test
	public void test_evaluate_throw8() {
		String[] scores = {"X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","X"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(30,input.c.evaluateThrow(testField, 5));
	}
	@Test
	public void testComplete0() {
		String[] scores = {"9","-","9","-","9","-","9","-","9","-","9","-","9","-","9","-","9","-","9","-","-","-"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("90",input.c.evaluate(testField));
	}
	@Test
	public void testComplete1() {
		String[] scores = {"5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","/","5","-","-"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("150",input.c.evaluate(testField));
	}
	@Test
	public void testComplete2() {
		String[] scores = {"1","2","3","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","3","4","","",""};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("50",input.c.evaluate(testField));
	}
	@Test
	public void testComplete3() {
		String[] scores = {"1","2","3","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","3","/","3",""};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("56",input.c.evaluate(testField));
	}
	@Test
	public void testComplete4() {
		String[] scores = {"1","2","X","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","3","4","",""};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("60",input.c.evaluate(testField));
	}
	@Test
	public void testComplete5() {
		String[] scores = {"1","2","X","4","4","3","2","1","1","2","3","4","4","3","2","1","1","2","X","-","4","4"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("71",input.c.evaluate(testField));
	}
	@Test
	public void testComplete6() {
		String[] scores = {"1","2","X","4","4","9","2","1","1","2","3","4","4","3","2","1","1","2","X","-","4","4"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals("Ungültig!",input.c.evaluate(testField));
	}
	
	@Test
	public void test_evaluate_strikeseries() {
		String[] scores = {"X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","-","X","X"};
		JTextField[][] testField = testTextField(scores);
		Input input = new Input();
		assertEquals(30,input.c.evaluateThrow(testField, 9));
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
