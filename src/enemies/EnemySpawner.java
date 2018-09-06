package enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject{
    FrameCounter frameCounter = new FrameCounter(50);
    Random random = new Random();

    public EnemySpawner() {
        super(0,0);
    }

    public void run() {
        super.run();
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            Enemy newEnemy = new Enemy(random.nextInt(600), -64);
            GameObject.add(newEnemy);
        }
    }
}
