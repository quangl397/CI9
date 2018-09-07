package enemies;

import java.util.Random;

import bases.FrameCounter;
import bases.GameObject;
import bases.ImageRenderer;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    Random random;
    EnemyShoot enemyShoot;

    public Enemy(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        enemyShoot = new EnemyShoot();
        random = new Random();
        enemyMove = new EnemyMove();
    }

    public void run() {
        super.run();
        this.move();
        this.shoot();
    }

    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

}