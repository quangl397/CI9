package bloodcells;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

public class BloodCell extends GameObject {
    public BloodCell(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/blood cells/blood-cell2.png");
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
}
