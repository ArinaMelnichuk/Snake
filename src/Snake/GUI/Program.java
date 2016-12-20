package Snake.GUI;

import javax.swing.*;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class Program {
    public static void main(String[] args) {
        int width = 50;
        int height = 40;
        int cellSize = 10;

        Game game = new Game(width, height, cellSize);
        GamePanel gamePanel = new GamePanel(width, height, cellSize, game.getEngine());
        ScorePanel scorePanel = new ScorePanel(width / 2, height, cellSize, game.getEngine().level);
        JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        panel.setDividerLocation(width * cellSize + 2);
//        panel.setDividerSize(0);
        panel.setEnabled(false);
        panel.add(gamePanel);
        panel.add(scorePanel);
        game.add(panel);
        game.addKeyListener(new MyKeyAdapter(game.getEngine()));
    }
}
