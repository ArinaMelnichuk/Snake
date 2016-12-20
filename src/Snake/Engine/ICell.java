package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public interface ICell extends IDrawable {
    void applyEffect(Level level);
    Color getColor();
}
