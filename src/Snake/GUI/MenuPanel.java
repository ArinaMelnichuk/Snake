package Snake.GUI;

import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/20/2016.
 */
public class MenuPanel extends JPanel {
    private JButton newGame;
    private JButton exit;
    private int width, height;

    public MenuPanel(int width, int height) {
//        newGame.setBackground(Color.GREEN);
//        exit = new JButton("Exit");
//        add(newGame);
//        add(exit);
        this.width = width;
        this.height = height;
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        newGame = new JButton("New Game");
        newGame.setBackground(Color.GREEN);
        newGame.setLayout(layout);
        this.setLayout(layout);
    }
}
