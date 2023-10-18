package snake_and_ladder_game;

public class Dice {
    private int numberOfDice;
    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
    public int roll(){
        int move=0;
        for (int i=0 ;i<numberOfDice;i++){
            move += (int) Math.floor(Math.random()*6 + 1);
        }
        return move;
    }
}
