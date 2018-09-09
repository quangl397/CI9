package enemies;

import java.util.Random;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import players.Player;

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
        this.boxCollider = new BoxCollider(x,y,30,30);
    }

    public void run() {
        super.run();
        this.move();
        this.shoot();
        touchPlayer();
    }

    private void touchPlayer() {
        Player player = GameObject.checkCollisionPlayer(this.boxCollider);
        if (player != null) {
            this.enemyMove = null;
        }
    }

    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

    public void getHit() {
        this.destroy();
    }
}