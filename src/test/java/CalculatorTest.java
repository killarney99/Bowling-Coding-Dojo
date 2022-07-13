import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testgetResult1() {
        String scores = "12341234123412341234";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(50,c.getResult(scores));
    }

    @Test
    public void testgetResult2() {
        String scores = "XXXXXXXXXXXX";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(300,c.getResult(scores));
    }

    @Test
    public void testgetResult3() {
        String scores = "5/5/5/5/5/5/5/5/5/5/5";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(150,c.getResult(scores));
    }

    @Test
    public void testgetResult4() {
        String scores = "9-9-9-9-9-9-9-9-9-9-";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(90,c.getResult(scores));
    }

    @Test
    public void testgetResult5() {
        String scores = "1234432112344321123/3";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(56,c.getResult(scores));
    }

    @Test
    public void testgetResult6() {
        String scores = "12X4321123443211234";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(60,c.getResult(scores));
    }

    @Test
    public void testgetResult7() {
        String scores = "12X43211234432112X-4";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(67,c.getResult(scores));
    }

    @Test
    public void testgetResult8() {
        String scores = "X23717/5-3344XX12";
        Roll r = new Roll(scores);
        Calculator c = new Calculator(r);
        assertEquals(99,c.getResult(scores));
    }





}