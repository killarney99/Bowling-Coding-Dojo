import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BowlingMain {
    public static void main(String[] args)
            throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String scores = reader.readLine();
            Roll r = new Roll(scores);
            Calculator c = new Calculator(r);
            int e = c.getResult(scores);
            System.out.println(e);
        }
    }
}