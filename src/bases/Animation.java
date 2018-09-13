package bases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Animation extends Renderer{
    private boolean oneTime;
    public boolean finished;
    ArrayList<Image> images;
    int imageIndex;
    FrameCounter frameCounter;

    public Animation(Image... imgs) {
        this(5, false, imgs);
    }

    // 1. load anh
    public Animation(int frameDelay, boolean oneTime, Image... imgs) {
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));
        this.oneTime = oneTime;
        this.imageIndex = 0;
        frameCounter = new FrameCounter(frameDelay);
        this.finished = false;
    }

    // 2. ve anh
    public void render(Graphics g, Vector2D position) {
        renderCurrentImage(g,position);
        changeCurrentImage();
    }

    private void changeCurrentImage() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            if (this.imageIndex < this.images.size() - 1) {
                this.imageIndex += 1;
            } else {
                if (this.oneTime) {
                    this.finished = true;
                } else {
                    this.imageIndex = 0;
                }
            }
        }
    }

    public void renderCurrentImage(Graphics g, Vector2D position) {
        Image currentImage = images.get(this.imageIndex);
        int width = currentImage.getWidth(null);
        int height = currentImage.getHeight(null);
        g.drawImage(currentImage,
                (int)(position.x - width / 2),
                (int)(position.y - height / 2),
                null);
    }
}
