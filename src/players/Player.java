package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Player extends GameObject {

    private PlayerMove playerMove;
    private PlayerShoot playerShoot;

    public Player(int x, int y){
        super(x,y);
        renderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        boxCollider = new BoxCollider(x,y,60,60);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.shoot();
    }

    void move() {
        this.playerMove.run(position);
    }

    void shoot() {
        this.playerShoot.run(this);
    }

    public void getHit() {
        this.destroy();
    }
}
