package enemies;

import bases.FrameCounter;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(100);
    public void run(Enemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            enemy.enemyBullets.add(new EnemyBullet((int)enemy.position.x, (int)enemy.position.y));
            frameCounter.reset();
        }
    }
}
