import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x;
    int y;
    Image image;
    InputManager inputManager;
    int count;
    boolean shootLock = false;
    ArrayList<PlayerBullet> bs;

    Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    void render(Graphics g)  {
        g.drawImage(image,x,y,null);
    }

    void run(ArrayList<PlayerBullet> bs) {
        this.bs = bs;
        if (inputManager.rightPressed) {
            x += 5;
        }
        if (inputManager.leftPressed) {
            x -= 5;
        }
        if (inputManager.upPressed) {
            y -= 5;
        }
        if (inputManager.downPressed) {
            y += 5;
        }
        if (inputManager.xPressed && !shootLock) {
            PlayerBullet newB = new PlayerBullet(this.x, this.y);
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
    }
}
