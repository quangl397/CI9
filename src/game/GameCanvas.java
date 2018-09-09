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
    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    FrameCounter frameCounter;

    Random random;
    BloodCell bloodCell;

    public GameCanvas() {
        frameCounter = new FrameCounter(60);
        random = new Random();

        bloodCell = new BloodCell(random.nextInt(600),random.nextInt(800));
        GameObject.add(new BackGround(300,400));
        GameObject.add(new Player(300, 700));
        GameObject.add(new Enemy(random.nextInt(600), -64));
//        GameObject.add(player2);
        GameObject.add(new BloodSpawner());
        GameObject.add(new EnemySpawner());

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

