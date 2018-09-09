package enemies;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import players.Player;

public class EnemyBullet extends GameObject {

    public EnemyBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet2.png");
        this.boxCollider = new BoxCollider(x,y,20,20);
    }

    @Override
    public void run() {
        super.run();
        move();
        hitPlayer();
    }

    private void hitPlayer() {
        Player player = GameObject.checkCollisionPlayer(this.boxCollider);
        if (player != null) {
            player.destroy();
        }
    }

    public void move() {
        this.position.addUp(0,10);
    }
}
