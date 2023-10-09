package snake_and_ladder_game;

import java.util.UUID;

public class Player {
    private String name;
    private String id;
    private int position ;
    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.position =0;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
}
