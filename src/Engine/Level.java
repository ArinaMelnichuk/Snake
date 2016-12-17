package Engine;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Level {
    public Snake snake;
    public int score;
    public Field field;

    public Level(Field field)
    {
        this.field = field;
    }
}
