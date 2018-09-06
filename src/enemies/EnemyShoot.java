package enemies;

import bases.FrameCounter;
import bases.GameObject;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(50);
    public void run(Enemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            GameObject.add(new EnemyBullet((int)enemy.position.x, (int)enemy.position.y));
            frameCounter.reset();
        }
    }
}
