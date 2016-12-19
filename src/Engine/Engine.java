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
        level.snake.move(direction, this.mapWidth, this.mapHeight);
        level.rearrangeFieldElements();
    }

    private void checkCollisions() {
        Point snakeLocation = level.snake.snakeParts.getFirst().location;
        level.field.objects[snakeLocation.y][snakeLocation.x].applyEffect(level);
    }


}
