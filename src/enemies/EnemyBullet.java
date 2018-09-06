package enemies;

import bases.GameObject;
import bases.ImageRenderer;

import java.awt.*;

public class EnemyBullet extends GameObject {

    public EnemyBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet2.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0,10);
    }
}
