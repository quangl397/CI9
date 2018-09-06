package bloodcells;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class BloodCell extends GameObject {
    BloodSpawner bloodSpawn;
    public BloodCell(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/blood cells/blood-cell2.png");
        bloodSpawn = new BloodSpawner();
    }

    public void run() {
        super.run();
        position.addUp(10,10);
        this.move();
    }

    public void move() {
        Vector2D velocity = new Vector2D();
        velocity.y += 2;
        position.addUp(velocity);
    }

    public void spawn() {
        this.bloodSpawn.run();
    }

    public void render(Graphics g) {
        imageRenderer.render(g, position);
    }
}
