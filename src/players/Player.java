package players;

import java.awt.*;
import java.util.ArrayList;
import bases.Vector2D;
import inputs.InputManager;
import bases.ImageRenderer;

public class Player {
    Vector2D position;
    public ArrayList<PlayerBullet> bullets;
    ImageRenderer imageRenderer;
    PlayerMove playerMove;
    PlayerShoot playerShoot;

    public Player(int x, int y) {
        position = new Vector2D(x,y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
    }

    public void run() {
        this.move();
        this.shoot();
    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }

    void move() {
        this.playerMove.run(position);
    }

    void shoot() {
        this.playerShoot.run(this);
    }
}
