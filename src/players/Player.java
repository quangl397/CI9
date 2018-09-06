package players;

import java.awt.*;

import bases.GameObject;
import bases.ImageRenderer;

public class Player extends GameObject {

    private PlayerMove playerMove;
    private PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x,y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
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
