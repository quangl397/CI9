package bases;

import enemies.Enemy;
import players.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    public boolean isActive;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static void add(GameObject g) {
        newGameObjects.add(g);
    }

    public static void runAll() {
        for (GameObject go: gameObjects) {
            if (go.isActive) {
                go.run();
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (GameObject go: gameObjects) {
            if (go.isActive) {
                go.render(g);
            }
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static Enemy checkCollision(BoxCollider boxCollider) {

        Enemy result = null;
        for (GameObject go: gameObjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go instanceof Enemy) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (Enemy)go;
                    }
                }
            }
        }
        return result;
    }

    public static Player checkCollisionPlayer(BoxCollider boxCollider) {
        Player result = null;

        for (GameObject go: gameObjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go instanceof Player) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (Player)go;
                    }
                }
            }
        }
        return result;
    }

    public BoxCollider boxCollider;

    public GameObject(int x, int y) {
        this.position = new Vector2D(x,y);
        this.imageRenderer = null; //not yet specified
        this.boxCollider = null;
        this.isActive = true;
    }

    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.run();
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
        }
    }
    public void render(Graphics g) {
        if (this.imageRenderer != null) {
            this.imageRenderer.render(g,this.position);
        }

        if (this.boxCollider != null) {
            this.boxCollider.render(g);
        }
    }

    public void destroy() {
        this.isActive = false;
    }

}
