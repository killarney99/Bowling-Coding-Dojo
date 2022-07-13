public class Roll {
    private String scores;
    private int frames;



    public Roll(String scores){
        this.scores = scores;
        this.frames = 0;
    }
    public int isNumber(char roll){
        int roll_int = Character.getNumericValue(roll);
        if(roll_int > 0 && roll_int < 10){
            return roll_int;
        }
        return -1;
    }
    public int processChar(int i,boolean b) {
        char turn = scores.charAt(i);
        if (isNumber(turn) > 0) {
            //System.out.println(isNumber(turn));
            if(!b) {
                frames++;
            }
            return isNumber(turn);
        } else {
            switch (turn) {
                case 'X':
                    if(b) {
                        return 10;
                    }
                    frames = frames + 2;
                    return checkStrike(i);
                case '/':
                    if(b) {
                        return processChar(i-1,false);
                    }
                    frames++;
                    return checkSpare(i);
                case '-':
                    frames++;
                    return 0;
                default:
                    System.out.println("Ungültiges Zeichen an Position " + (i+1));
                    return -1;

            }
        }
        // switch(a):

    }

    public int checkStrike(int i){
        if(frames < 20){
            return 10 + processChar(i+1,true) + processChar(i+2,true);
        }
        return 10;
    }

    public int checkSpare(int i){
        if(frames < 20){
            return 10-processChar(i-1,true) + processChar(i+1,true);
        }
        return 10-processChar(i-1,false);

    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }


}
