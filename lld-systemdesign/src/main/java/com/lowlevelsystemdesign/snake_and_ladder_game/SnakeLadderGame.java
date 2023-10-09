package com.lowlevelsystemdesign.snake_and_ladder_game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeLadderGame {
    Board board;
    Dice dice;
    Queue<Player> players;
    GameStatus status;

    public SnakeLadderGame() {
        prepareForStart();
        this.players = new LinkedList<>();
        this.status = GameStatus.NOT_STARTED;
    }
    //this should not expose to client, its internal properties can be set by admin
    public void prepareForStart() {
        List<Snake> snakes = Arrays.asList( new Snake(12, 28), new Snake(34, 78),
                new Snake(6, 69), new Snake(65, 84));
        List<Ladder> ladders = Arrays.asList( new Ladder(24, 56),  new Ladder(43, 83),
                new Ladder(3, 31), new Ladder(72, 91));
        this.board = new Board(100,snakes,ladders);
        this.dice = new Dice(1);
    }
    public void start() {
        System.out.println("Game Started");
        this.status = GameStatus.RUNNING;
        // Run until we have only 1 player left on the board
        while(players.size() > 1) {
            Player player = players.poll();
            move(player);
            if(player.getPosition() == board.getNumberOfcells()) {
                System.out.println(player.getName() + " has completed the game!");
            }else {
                players.offer(player);
            }
        }
        System.out.println(players.poll().getName() + " can't complete the game!");
        this.status = GameStatus.FINISHED;
        System.out.println("Game "+ status);
    }

    private void move(Player player) {
        System.out.println(player.getName()+"'s turn.");
        int currPosition = player.getPosition();
        int rollValue = dice.roll();
        int targetPosition = currPosition + rollValue;
        if(targetPosition > board.getNumberOfcells()){
            System.out.println("Out of Move");
            return;
        }
        if(board.isSnake(targetPosition)) {
            targetPosition = board.getSnakeTail(targetPosition) ;
        }else if(board.isLadder(targetPosition)){
            targetPosition = board.getLadderTop(targetPosition) ;
        }
        player.setPosition(targetPosition);
    }
    public void joinGame(Player player) {
        if(this.status == GameStatus.NOT_STARTED) {
            this.players.add(player);
        } else {
            throw new RuntimeException("Player can't join the game after start");
        }
    }
}

