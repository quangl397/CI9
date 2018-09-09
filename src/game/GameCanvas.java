package game;

import background.BackGround;
import bases.FrameCounter;
import bases.GameObject;
import bloodcells.BloodCell;
import bloodcells.BloodSpawner;
import enemies.Enemy;
import enemies.EnemySpawner;
import players.Player;
import players.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
public class GameCanvas extends JPanel {
    Player player;
    Enemy enemy;
    Player2 player2;
    BackGround background;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    FrameCounter frameCounter;

    Random random;
    BloodCell bloodCell;
    BloodSpawner bloodSpawner;
    EnemySpawner enemySpawner;

    public GameCanvas() {
        frameCounter = new FrameCounter(60);
        random = new Random();

        enemy = new Enemy(random.nextInt(600), -64);
        player = new Player(300, 700);
        player2 = new Player2(400,700);
        background = new BackGround(300,400);
        bloodCell = new BloodCell(random.nextInt(600),random.nextInt(800));
        bloodSpawner = new BloodSpawner();
        enemySpawner = new EnemySpawner();
        GameObject.add(background);
        GameObject.add(player);
//        GameObject.add(player2);
        GameObject.add(bloodSpawner);
        GameObject.add(enemySpawner);

        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }


    void run() {
        GameObject.runAll();
    }

    void render() {
        GameObject.renderAll(backBufferGraphics);
        this.repaint();
    }
}

