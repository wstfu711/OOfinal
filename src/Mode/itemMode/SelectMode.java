package Mode.itemMode;

import Item.Item;
import Item.Object.GroupObject;
import Mode.Mode;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectMode extends Mode{
    private Point prevPoint;

    public void mousePressed(MouseEvent e) {
        prevPoint = e.getPoint();
        ArrayList<Item> items = canva.getItemsByPoint(prevPoint);
        if (!items.isEmpty()) {
            canva.setSelected(items.get(0));
        } else {
            canva.setSelected(null);
            canva.selectedArea = new Rectangle();
        }
        canva.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        if (canva.getSelected() != null) {
            int dx = e.getX() - prevPoint.x;
            int dy = e.getY() - prevPoint.y;
            moveItem(canva.getSelected(), dx, dy); // 移動選中的物件或群組
            prevPoint = e.getPoint();
            canva.repaint();
        } else if (canva.selectedArea != null) {
            int x = Math.min(prevPoint.x, e.getX());
            int y = Math.min(prevPoint.y, e.getY());
            int width = Math.abs(e.getX() - prevPoint.x);
            int height = Math.abs(e.getY() - prevPoint.y);
            canva.selectedArea.setBounds(x, y, width, height);
            canva.repaint();
        }
    }

    private void moveItem(Item item, int dx, int dy) {
        if (item.isGroup()) {
            GroupObject group = (GroupObject) item;
            for (Item subItem : group.getGroupItems()) {
                moveItem(subItem, dx, dy); // 遞迴地移動群組內的每個物件或子群組
            }
        }
        item.reLocate(dx, dy); // 移動當前物件
    }



    public void mouseReleased(MouseEvent e) {
        if (canva.getSelected() == null) {
            ArrayList<Item> items = canva.getItemsByRect(canva.selectedArea);
            if (items.size() < 2) {
                canva.selectedArea = null;
                canva.repaint();
            }
        }
    }
}
