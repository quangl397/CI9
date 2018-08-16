import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
    Image player;
    int x = 300 - 32;
    int y = 700 - 40;

    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean xPressed = false;

    int count;
    boolean shootLock = false;
    int amountEnemy;
    Random rd = new Random();

    // Buffer image
    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    //arraylist
    ArrayList<PlayerBullet> bs; //null
    ArrayList<Enemy> es;

    public GameCanvas() {
        //create array list Player bullet
        bs = new ArrayList<>();
        es = new ArrayList<>();
        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }

    void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_X:
                xPressed = true;
                break;
        }
    }

    void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_X:
                xPressed = false;
                break;
        }
    }

    void run() {
        if (rightPressed) {
            x += 5;
        }
        if (leftPressed) {
            x -= 5;
        }
        if (upPressed) {
            y -= 5;
        }
        if (downPressed) {
            y += 5;
        }

        //Bullet
        for (PlayerBullet b: bs) {
            b.bulletY -= 10;
        }
        if (xPressed && !shootLock) {
            PlayerBullet newB = new PlayerBullet();
            newB.bulletX = x;
            newB.bulletY = y;
            try {
                newB.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bs.add(newB);
            shootLock = true;
        }
        if (shootLock) {
            count++;
            if (count > 10) {
                shootLock = false;
                count = 0;
            }
        }

        //ENEMY
        for (Enemy e: es) {
            e.enemyY += 2;
            if (e.enemyY > 800) {
                e.enemyX = rd.nextInt(550);
                e.enemyY = -400 + rd.nextInt(100);
            }
        }
        if (amountEnemy < 5) {
            Enemy newE = new Enemy();
            newE.enemyX = rd.nextInt(550);
            newE.enemyY = -400 + rd.nextInt(100);
            try {
                newE.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            amountEnemy++ ;
            es.add(newE);
        }
    }

    void render() {
        backBufferGraphics.drawImage(background,0,0,null);
        backBufferGraphics.drawImage(player,x, y,null);

        for (PlayerBullet b: bs) {
            backBufferGraphics.drawImage(b.image,b.bulletX,b.bulletY,null);
        }
        for (Enemy e: es) {
            backBufferGraphics.drawImage(e.image,e.enemyX,e.enemyY,null);
        }

        this.repaint();
    }
}

