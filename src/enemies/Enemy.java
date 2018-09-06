package enemies;

import java.awt.*;
import java.util.Random;

import bases.FrameCounter;
import bases.GameObject;
import bases.ImageRenderer;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    Random random;
    FrameCounter frameCounter;
    EnemyShoot enemyShoot;
    EnemySpawner enemySpawner;

    public Enemy(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        enemyShoot = new EnemyShoot();
        random = new Random();
        enemyMove = new EnemyMove();
        frameCounter = new FrameCounter(100);
        enemySpawner = new EnemySpawner();
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

    public void spawn() {
        this.enemySpawner.run();
    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }
}