package GUI;
import Engine.Engine;
import javax.swing.*;

/**
 * Created by Arina Melnichuk on 12/17/2016.
 */
public class Game extends JFrame {

    public Game() {
        this.setBounds(200, 150, 500, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Engine engine = new Engine(500, 400);
    }

    public static void main(String[] args) {
        Game app = new Game();
        app.setVisible(true);
    }
}
