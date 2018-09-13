package bases;

import enemies.Enemy;
import enemies.EnemyBullet;
import players.Player;
import players.PlayerBullet;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;
    public static boolean isLiving;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static void add(GameObject g) {
        newGameObjects.add(g);
    }

    public static void runAll() {
        for (GameObject go: gameObjects) {
            if (go.isActive && go.isLiving) {
                go.run();
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        System.out.println(gameObjects.size());
    }

    public static void renderAll(Graphics g) {
        for (GameObject go: gameObjects) {
            if (go.isActive && go.isLiving) {
                go.render(g);
            }
        }
    }

    public static PlayerBullet recycle(int x, int y) {
        PlayerBullet pb = null;
        for (GameObject go: gameObjects) {
            if (!go.isActive) {
                if (go instanceof PlayerBullet) {
                    pb = (PlayerBullet) go;
                }
            }
        }

        if (pb == null) {
            pb = new PlayerBullet(x,y);
            GameObject.add(pb);
        } else {
            pb.isActive = true;
            pb.position.x = x;
            pb.position.y = y;
        }
        return pb;
    }

    public static Enemy recycleEnemy(int x, int y) {
        Enemy e = null;
        for (GameObject go: gameObjects) {
            if (!go.isActive) {
                if (go instanceof Enemy) {
                    e = (Enemy) go;
                }
            }
        }

        if (e == null) {
            e = new Enemy(x,y);
            GameObject.add(e);
        } else {
            e.isActive = true;
            e.position.x = x;
            e.position.y = y;
        }
        return e;
    }

    public static EnemyBullet recycleEnemyB(int x, int y) {
        EnemyBullet eb = null;
        for (GameObject go: gameObjects) {
            if (!go.isActive) {
                if (go instanceof EnemyBullet) {
                    eb = (EnemyBullet) go;
                }
            }
        }

        if (eb == null) {
            eb = new EnemyBullet(x,y);
            GameObject.add(eb);
        } else {
            eb.isActive = true;
            eb.position.x = x;
            eb.position.y = y;
        }
        return eb;
    }
    //generics

    public static <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls) {

        T result = null;
        for (GameObject go: gameObjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go.getClass().equals(cls)) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (T)go;
                    }
                }
            }
        }
        return result;
    }

    public BoxCollider boxCollider;

    public GameObject(int x, int y) {
        this.position = new Vector2D(x,y);
        this.renderer = null; //not yet specified
        this.boxCollider = null;
        this.isActive = true;
        this.isLiving = true;
    }

    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.run();
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
        }
    }
    public void render(Graphics g) {
        if (this.renderer != null) {
            this.renderer.render(g,this.position);
        }

        if (this.boxCollider != null) {
            this.boxCollider.render(g);
        }
    }

    public void destroy() {
        this.isActive = false;
    }

    public void deathPlayer() {
        this.isLiving = false;
    }
}
