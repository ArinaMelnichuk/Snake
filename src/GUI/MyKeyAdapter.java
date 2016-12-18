package GUI;

import Engine.Engine;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class MyKeyAdapter extends KeyAdapter {
    private Engine engine;

    public MyKeyAdapter(Engine engine) {
        this.engine = engine;
    }

    public void keyPressed(KeyEvent e) {
        this.engine.keyPressed(e);
    }
}
