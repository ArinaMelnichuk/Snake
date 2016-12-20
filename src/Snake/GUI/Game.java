package Snake.GUI;

import Snake.Engine.Engine;

import javax.swing.*;

/**
 * Created by Arina Melnichuk on 12/17/2016.
 */
public class Game extends JFrame {
    private Engine engine;
    private Timer timer;

    public Game(int width, int height, int cellSize) {
        // это не костыли, это погрешности
        this.setBounds(200, 150, width * 3 / 2 * cellSize + 5, (height + 3) * cellSize + 2);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.engine = new Engine(width, height);
        this.timer = new Timer(60, event -> {
            engine.moveOnTick();
            timerStop();
            this.repaint();
            this.revalidate();
        });
        this.timer.start();
    }

        public Engine getEngine() {
        return this.engine;
    }

    private void timerStop(){
        if (!engine.level.snake.isAlive)
            timer.stop();
    }
}
