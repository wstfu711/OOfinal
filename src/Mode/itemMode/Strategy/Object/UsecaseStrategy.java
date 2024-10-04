package Mode.itemMode.Strategy.Object;

import Item.Object.Usecase;
import Item.RectObject;

public class UsecaseStrategy implements ObjectStrategy{
    @Override
    public RectObject createObject(int x, int y) {
        return new Usecase(x, y);
    }
}
