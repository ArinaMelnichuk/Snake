package Snake.GUI;

import Snake.Engine.Engine;

import javax.swing.*;

/**
 * Created by Arina Melnichuk on 12/17/2016.
 */
public class Game extends JFrame {
    private Engine engine;
    private Timer timer;

    public Game(int mapSizeX, int mapSizeY, int cellSize) {
        this.setBounds(200, 150, mapSizeX * cellSize, mapSizeY * cellSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.engine = new Engine(mapSizeX, mapSizeY);
        this.timer = new Timer(60, event -> {
            engine.moveOnTick();
            timerStop();
            this.repaint();
            this.revalidate();
            System.out.println(engine.level.score);
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
