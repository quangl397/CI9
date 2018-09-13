package enemies;

import java.util.Random;

import bases.*;
import players.Player;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    Random random;
    EnemyShoot enemyShoot;

    public Enemy(int x, int y)  {
        super(x,y);
        this.renderer = new Animation(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png")
        );
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
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (this.position.y > 800) {
            this.isActive = false;
        }
    }

    private void touchPlayer() {
        Player player = GameObject.checkCollision(this.boxCollider, Player.class);
        if (player != null) {
            player.deathPlayer();
        }
    }


    public void shoot()  {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

    public void getHit() {
        this.destroy();
        EnemyExplosion explosion = new EnemyExplosion(
                (int)this.position.x,
                (int)this.position.y
        );
        GameObject.add(explosion);
    }
}