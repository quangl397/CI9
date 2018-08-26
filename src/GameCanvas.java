import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    Player player;

    int enemySpawnCount;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;
    Random random;
    InputManager inputManager;
    public GameCanvas() {
        inputManager = new InputManager();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        random = new Random();
        player = new Player(268, 660);
        player.inputManager = inputManager;
        player.bullets = this.bullets;
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
        enemySpawnCount++;
        if (enemySpawnCount > 60) {
            enemySpawnCount = 0;
            Enemy enemy = new Enemy(random.nextInt(600), -64);
            enemies.add(enemy);
        }
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

