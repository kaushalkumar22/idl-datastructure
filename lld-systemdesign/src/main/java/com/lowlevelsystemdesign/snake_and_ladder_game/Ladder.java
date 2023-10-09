package com.lowlevelsystemdesign.snake_and_ladder_game;

public class Ladder {
    private int bottom;
    private int top;

    public Ladder(int bottom, int top) {
        this.bottom = bottom;
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public int getTop() {
        return top;
    }
}
