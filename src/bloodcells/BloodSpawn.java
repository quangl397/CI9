package bloodcells;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class BloodSpawn extends GameObject{
    FrameCounter frameCounter = new FrameCounter(60);
    Random random = new Random();

    public BloodSpawn() {
        super(0,0);
    }

    public void run() {
        super.run();
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            BloodCell newBloodCell = new BloodCell(-5 + random.nextInt(5), random.nextInt(800));
            GameObject.add(newBloodCell);
        }
    }
}
