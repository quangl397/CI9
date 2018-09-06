package players;

import bases.GameObject;
import bases.ImageRenderer;

import java.awt.*;

public class Player2 extends GameObject {

    public Player2(int x, int y) {
        super(x,y);
        imageRenderer = new ImageRenderer("images/player/MB-70/player1.png");
    }

    public void run() {

    }

    public void render(Graphics g) {
        imageRenderer.render(g,position);
    }
}
