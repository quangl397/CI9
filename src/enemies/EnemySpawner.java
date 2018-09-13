package enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject{
    FrameCounter frameCounter;
    Random random = new Random();

    public EnemySpawner() {
        super(0,0);
        this.frameCounter = new FrameCounter(100);
    }

    public void run() {
        super.run();
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            Enemy newEnemy = GameObject.recycleEnemy(random.nextInt(600), 0);
        }
    }
}
