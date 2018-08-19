import java.awt.*;

public class Enemy {
    int x;
    int y;
    Image image;

    Enemy( int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    void render(Graphics g) {
        g.drawImage(image, x, y,null);
    }
}