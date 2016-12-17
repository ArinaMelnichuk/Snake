package Engine;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Generator {

    // TODO do!
    public static Level generateLevel(int x, int y) {
        ICell[][] entities = new ICell[y][x];
        Field field = new Field(entities);
        return new Level(field);
    }
}
