import java.awt.*;
import java.util.ArrayList;

public class Player {
    Vector2D position;
    Image image;
    InputManager inputManager;
    int count;
    boolean shootLock = false;
    ArrayList<PlayerBullet> bullets;

    Player(int x, int y) {
        position = new Vector2D(x,y);
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    void run() {
        this.move();
        this.shoot();
    }

    void render(Graphics g) {
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }

    void move() {
        Vector2D velocity = new Vector2D();
        if (inputManager.rightPressed && this.position.x < 568) {
            velocity.x += 5;
        }
        if (inputManager.leftPressed && this.position.x > -32) {
            velocity.x -= 5;
        }
        if (inputManager.upPressed && this.position.y > 0) {
            velocity.y -= 5;
        }
        if (inputManager.downPressed && this.position.y < 700) {
            velocity.y += 5;
        }
        this.position.addUp(velocity);
    }

    void shoot() {
        if (inputManager.xPressed && !shootLock) {
            PlayerBullet newB = new PlayerBullet((int)position.x,(int)position.y);
            bullets.add(newB);
            shootLock = true;
        }
        if (shootLock) {
            count++;
            if (count > 10) {
                count = 0;
                shootLock = false;
            }
        }
    }
}
