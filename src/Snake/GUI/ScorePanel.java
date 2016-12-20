package Snake.GUI;

import Snake.Engine.Level;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/20/2016.
 */
public class ScorePanel extends JPanel {
    private int mapWidth, mapHeight, cellSize;
    private Level level;


    public ScorePanel(int mapWidth, int mapHeight, int cellSize, Level level) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.cellSize = cellSize;
        this.level = level;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, this.mapWidth * this.cellSize, this.mapHeight * this.cellSize);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(String.format("Score: %s", level.score), mapWidth / 6 * cellSize, mapHeight / 2 * cellSize);
    }
}
