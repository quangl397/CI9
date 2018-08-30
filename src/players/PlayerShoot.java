package players;
import bases.FrameCounter;
import inputs.InputManager;

public class PlayerShoot {
    boolean shootLock;
    FrameCounter frameCounter = new FrameCounter(20);
    void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock) {
            PlayerBullet newB = new PlayerBullet((int)player.position.x,(int)player.position.y);
            player.bullets.add(newB);
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
