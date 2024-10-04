package Editor;

import Item.Item;
import Item.Object.GroupObject;

import java.awt.*;
import java.util.ArrayList;

public class GroupManager {
    public void groupItems(Rectangle selectedArea) {
        ArrayList<Item> tempList = Canva.getInstance().getItemsByRect(selectedArea);
        if (tempList.size() > 1) {
            Canva.getInstance().addItem(new GroupObject(selectedArea, tempList));
            Canva.getInstance().getItems().removeAll(tempList);
        }
        Canva.getInstance().selectedArea = null;
        Canva.getInstance().repaint();
    }

    public void ungroupItems(Item selectedItem) {
        if (selectedItem != null && selectedItem.isGroup()) {
            GroupObject temp = (GroupObject) selectedItem;
            Canva.getInstance().getItems().addAll(temp.getGroupItems());
            Canva.getInstance().getItems().remove(temp);
        }
        Canva.getInstance().selectedArea = null;
        Canva.getInstance().repaint();
    }
}
