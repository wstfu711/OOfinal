package Mode.itemMode.Strategy.Object;

import Item.RectObject;
import Item.Object.Class;

public class ClassStrategy implements ObjectStrategy{
    @Override
    public RectObject createObject(int x, int y) {
        return new Class(x, y);
    }
}
