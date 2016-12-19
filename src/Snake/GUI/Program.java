package Snake.GUI;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class Program {
    public static void main(String[] args) {
        int mapSizeX = 50;
        int mapSizeY = 40;
        int cellSize = 10;

        Game game = new Game(mapSizeX, mapSizeY, cellSize);
        GamePanel panel = new GamePanel(mapSizeX, mapSizeY, cellSize, game.getEngine());
        game.add(panel);
        game.addKeyListener(new MyKeyAdapter(game.getEngine()));
    }
}
