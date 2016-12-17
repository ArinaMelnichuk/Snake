package Engine;
import javax.swing.Timer;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Engine {
    private Level level;
    private Point direction;

    public Engine(int mapSizeX, int mapSizeY) {
//        level = Generator.generateLevel(mapSizeX, mapSizeY);
        ICell[][] objects = new ICell[40][50];
        objects[20][25] = new SnakePart(new Point(200, 250));
        objects[20][26] = new SnakePart(new Point(200, 251));
        level = new Level(new Field(objects));
        direction = new Point(0, 0);
        new Timer(17, event -> level.snake.move(direction)).start();
    }
    // TODO the same with hedge

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                direction = new Point(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                direction = new Point(0, 1);
                break;
            case KeyEvent.VK_RIGHT:
                direction = new Point(1, 0);
                break;
            case KeyEvent.VK_LEFT:
                direction = new Point(-1, 0);
                break;
        }
    }

    private void checkCollisions(Snake snake, List<Bonus> bonuses) {
        bonuses.forEach(bonus -> { if (bonus.location == snake.location) {
            bonus.applyEffect(level);
            ICell[][] objects = level.field.objects;
            int x = bonus.location.x;
            int y = bonus.location.y;
            objects[y][x] = null;
        }});
    }


}
