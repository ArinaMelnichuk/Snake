package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/19/2016.
 */
public interface IDrawable {
    void accept(Visitor visitor, Graphics g, int cellSize);
}
