package Snake.Engine;

import java.util.List;
import java.util.Queue;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Field {
    public ICell[][] objects;
    public List<Hedge> hedges;
    public Queue<Bonus> bonuses;

    public Field(ICell[][] entities, List<Hedge> hedges, Queue<Bonus> bonuses) {
        this.objects = entities;
        this.hedges = hedges;
        this.bonuses = bonuses;
    }

    public void bonusesRestart() {
        if (!bonuses.isEmpty() && bonuses.peek().isCatched)
            bonuses.poll();
    }
}