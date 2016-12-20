package Snake.Engine;

import java.awt.Point;
import java.awt.event.KeyEvent;

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
        level = Generator.createNewInstance(mapSizeX, mapSizeY).generateLevel();
        direction = new Point(0, 1);
    }
    // TODO the same with hedge

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (!direction.equals(new Point(0, 1)))
                    direction = new Point(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                if (!direction.equals(new Point(0, -1)))
                    direction = new Point(0, 1);
                break;
            case KeyEvent.VK_RIGHT:
                if (!direction.equals(new Point(-1, 0)))
                    direction = new Point(1, 0);
                break;
            case KeyEvent.VK_LEFT:
                if (!direction.equals(new Point(1, 0)))
                    direction = new Point(-1, 0);
                break;
        }
    }

    public void moveOnTick(){
        level.snake.setDirection(direction);
        checkCollisions();
        if (level.snake.isAlive)
            level.snake.move(this.mapWidth, this.mapHeight);
        level.rearrangeFieldElements();
    }

    private void checkCollisions() {
        Point snakeLocation = level.snake.getLocation(this.mapWidth, this.mapHeight);
        level.field.objects[snakeLocation.y][snakeLocation.x].applyEffect(level);
    }
}
