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

    int enemySpawnCount;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    ArrayList<PlayerBullet> bs;
    ArrayList<Enemy> es;
    Random random;

    InputManager inputManager;
    Player player;
    public GameCanvas() {
        bs = new ArrayList<>();
        es = new ArrayList<>();
        random = new Random();
        inputManager = new InputManager();
        player = new Player(268,660);
        player.inputManager = inputManager;

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }

    void run() {
        player.run(bs);
        for (PlayerBullet b: bs) {
            b.run();
        }
        //enemy
        for (Enemy e: es) {
            e.y += 3;
        }
        enemySpawnCount++;
        if (enemySpawnCount > 60) {
            enemySpawnCount = 0;
            Enemy newE = new Enemy(random.nextInt(600), -64);
            es.add(newE);
        }
    }

    void render() {
        backBufferGraphics.drawImage(background,0,0,null);
        player.render(backBufferGraphics);
        for (PlayerBullet b: bs) {
            b.render(backBufferGraphics);
        }
        for (Enemy e: es) {
            e.render(backBufferGraphics);
        }
        this.repaint();
    }
}

