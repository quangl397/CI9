package players;

import bases.GameObject;
import bases.ImageRenderer;
public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0,-10);
    }
}