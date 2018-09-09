package players;
import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

public class PlayerShoot {
    boolean shootLock;
    FrameCounter frameCounter = new FrameCounter(10);
    void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock) {
            Vector2D bulletPosition = player.position.subtract(0,50);
            PlayerBullet newB = new PlayerBullet((int)bulletPosition.x,(int)bulletPosition.y);
            GameObject.add(newB);
            shootLock = true;
        }

        if (shootLock) {
            frameCounter.run();
            if (frameCounter.expired) {
                frameCounter.reset();
                shootLock = false;
            }
        }
    }
}
