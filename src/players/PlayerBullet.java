package players;

import java.awt.*;

import bases.ImageRenderer;
import bases.Vector2D;
public class PlayerBullet {
    Vector2D position;
    ImageRenderer imageRenderer;

    PlayerBullet(int x, int y) {
        position = new Vector2D(x, y);
        imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
    }

    public void render(Graphics g) {
        imageRenderer.render(g,position);
    }

    public void run() {
        Vector2D velocity = new Vector2D();
        velocity.y -= 10;
        this.position.addUp(velocity);
    }
}