package Engine;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Field {
    public ICell[][] objects;

    public Field(ICell[][] entities) {
        this.objects = entities;
    }

//    public ICell getCell(int x, int y) {
//        return objects[y][x];
//    }
}
