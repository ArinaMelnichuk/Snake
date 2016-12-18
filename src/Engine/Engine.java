package Engine;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Engine {
    public Level level;
    private Point direction;
    private int mapWidth, mapHeight;

    public Engine(int mapSizeX, int mapSizeY) {
        mapWidth = mapSizeX;
        mapHeight = mapSizeY;
        level = Generator.generateLevel(mapSizeX, mapSizeY);
        direction = new Point(0, 0);
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

    public void moveOnTick(){
        level.snake.move(direction, mapWidth, mapHeight);
        loop();
        level.rearrangeFieldElements();
    }

    private void loop() {
        Point location = level.snake.location;
        level.snake.location = new Point((location.x + mapWidth) % mapWidth, (location.y + mapHeight) % mapHeight);
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
