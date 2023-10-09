package snake_and_ladder_game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int numberOfcells;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<Integer,Integer> snakeHeadVsTail;
    private Map<Integer,Integer> ladderBottomVsTop;

    public Board(int numberOfcells, List<Snake> snakes, List<Ladder> ladders) {
        this.numberOfcells = numberOfcells;
        this.snakes = snakes;
        this.ladders = ladders;
        this.snakeHeadVsTail = new HashMap<>();
        this.ladderBottomVsTop = new HashMap<>();
        addToMap();
    }
    //for better performance map is require
    private void addToMap(){
        for (Snake snake : snakes){
            snakeHeadVsTail.put(snake.getHead(),snake.getTail());
        }
        for (Ladder snake : ladders){
            ladderBottomVsTop.put(snake.getBottom(),snake.getTop());
        }
    }

    public int getNumberOfcells() {
        return numberOfcells;
    }

    public boolean isSnake(int head) {
        return snakeHeadVsTail.containsKey(head);
    }

    public int getSnakeTail(int head) {
        return snakeHeadVsTail.get(head);
    }

    public boolean isLadder(int buttom) {
        return ladderBottomVsTop.containsKey(buttom);
    }

    public int getLadderTop(int buttom) {
        return ladderBottomVsTop.get(buttom);
    }
}
