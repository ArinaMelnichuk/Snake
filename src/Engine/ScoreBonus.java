package Engine;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class ScoreBonus extends Bonus {
    private int points;

    public ScoreBonus(int x, int y) {
        super(x, y);
        points = 5;
    }

    @Override
    public void applyEffect(Level level) {
        super.applyEffect(level);
        level.score += points;
    }
}
