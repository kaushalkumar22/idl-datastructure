package com.lowlevelsystemdesign.snake_and_ladder_game;

public class SnakeAndLadderMain {
    public static void main(String[] args) {
        SnakeLadderGame game = new SnakeLadderGame();
        game.joinGame(new Player("p1"));
        game.joinGame(new Player("p2"));
        game.joinGame(new Player("p3"));
        game.start();
    }
}
