package Engine;
import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Engine {
    private Level level;
    private Timer timer;
    private Point direction;

    public Engine(int mapSizeX, int mapSizeY) {
        level = Generator.generateLevel(mapSizeX, mapSizeY);
        direction = new Point(0, 0);
        timer = new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.snake.move(direction);
            }
        }).start();
    }
    // TODO processor
    // TODO level.move(SnakeDirection direction) on tick
    // TODO handling bonus interaction with snake
    // TODO the same but with hedge

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Snake snake = level.snake;
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
        bonuses.forEach(bonus -> { if (bonus.location == snake.location)
        bonus.applyEffect(level);
            ICell[][] objects = level.field.objects;
            int x = bonus.location.x;
            int y = bonus.location.y;
            objects[y][x] = null;
        });
    }


}
