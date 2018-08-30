package enemies;

import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class EnemyBullet {
    Vector2D position;
    ImageRenderer imageRenderer;

    public EnemyBullet(int x, int y) {
        position = new Vector2D(x,y);
        imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet2.png");
    }

    public void render(Graphics g) {
        imageRenderer.render(g,position);
    }

    public void run() {
        Vector2D velocity = new Vector2D();
        velocity.y += 10;
        position.addUp(velocity);
    }
}
