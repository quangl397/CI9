package background;

import bases.GameObject;
import bases.ImageRenderer;

public class BackGround extends GameObject {

    public BackGround(int x, int y) {
        super(x,y);
        renderer = new ImageRenderer("images/background/background.png");
    }
}
