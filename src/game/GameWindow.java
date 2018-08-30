package game;

import inputs.InputManager;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;
    public GameWindow() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                InputManager.instance.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                InputManager.instance.keyReleased(keyEvent);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        this.setSize(600,800);
        this.setResizable(false);
        this.setTitle("Micro-war");
        canvas = new GameCanvas();
        this.setContentPane(canvas);
        this.setVisible(true);
    }

    public void mainLoop() {
        long lastTimeRender = 0;
        long currentTime;
        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                canvas.run();
                canvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}