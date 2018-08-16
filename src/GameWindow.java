import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas canvas;

    public GameWindow() {

        //setup game window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                canvas.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                canvas.keyReleased(keyEvent);
            }
        });
        this.setSize(600,800);
        this.setResizable(false);
        this.setTitle("Micro-war");

        //setup game canvas
        canvas = new GameCanvas();
        this.setContentPane(canvas);

        this.setVisible(true);
    }

    long lastTimeRender = 0;

    void mainLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                canvas.run();
                canvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}