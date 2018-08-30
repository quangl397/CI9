package game;

import enemies.Enemy;
import enemies.EnemyBullet;
import inputs.InputManager;
import players.Player;
import players.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import bases.ImageUtil;
public class GameCanvas extends JPanel {
    Image background;
    Player player;
    Enemy enemy;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;

    Random random;

    public GameCanvas() {

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        random = new Random();
        player = new Player(268, 660);
        enemy = new Enemy(random.nextInt(600), -64);
        player.bullets = this.bullets;
        enemy.enemies = this.enemies;

        background = ImageUtil.load("images/background/background.png");
        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }


    void run() {
        player.run();
        for (PlayerBullet b: bullets) {
            b.run();
        }
        for (Enemy e: enemies) {
            e.run();
        }
        enemy.spawn();
        enemy.run();
    }

    void render() {
        backBufferGraphics.drawImage(background,0,0, null);
        player.render(backBufferGraphics);
        for (PlayerBullet b: bullets) {
            b.render(backBufferGraphics);
        }
        for (Enemy e: enemies) {
            e.render(backBufferGraphics);
        }

        this.repaint();
    }
}

