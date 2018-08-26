import java.awt.*;

public class PlayerBullet {
    Vector2D position;
    Image image;

    PlayerBullet(int x, int y) {
        position = new Vector2D(x, y);
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }

    void render(Graphics g) {
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }

    void run() {
        Vector2D velocity = new Vector2D();
        velocity.y -= 10;
        this.position.addUp(velocity);
    }
}