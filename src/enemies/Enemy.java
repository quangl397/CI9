package enemies;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import bases.FrameCounter;
import bases.Vector2D;
import bases.ImageRenderer;
import players.PlayerBullet;

public class Enemy {
    Vector2D position;
    ImageRenderer imageRenderer;
    EnemyMove enemyMove;
    public ArrayList<Enemy> enemies;
    Random random;
    FrameCounter frameCounter;
    public ArrayList<EnemyBullet> enemyBullets;
    EnemyShoot enemyShoot;

    public Enemy(int x, int y) {
        enemyShoot = new EnemyShoot();
        enemyBullets = new ArrayList<>();
        position = new Vector2D(x,y);
        random = new Random();
        imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        enemyMove = new EnemyMove();
        frameCounter = new FrameCounter(100);

    }

    public void run() {
        this.move();
        for (EnemyBullet e: enemyBullets) {
            e.run();
        }
        this.shoot();
    }
    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

    public void spawn() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            Enemy newEnemy = new Enemy(random.nextInt(600), -64);
            enemies.add(newEnemy);
        }
    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
        for (EnemyBullet e: enemyBullets) {
            e.render(g);
        }
    }

}