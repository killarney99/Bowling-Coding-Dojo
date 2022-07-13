public class Calculator {
    private Roll r;
    public Calculator(Roll r){
        this.r = r;
    }

    public int getResult(String scores){
        int i = 0;
        int result = 0;
        int frameCounter = 0;
        while(i < scores.length()){
            //System.out.println("Run " + i + "Framecounter" + r.getFrames());
            int currentRoll = r.processChar(i, false);
            if(currentRoll < 0) {
                return -1;
            }
            result = result + currentRoll;
            //System.out.println(result);
            i++;
        }
        return result;
    }



    public Roll getR() {
        return r;
    }

    public void setR(Roll r) {
        this.r = r;
    }
}