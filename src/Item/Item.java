package Item;

import java.awt.*;

import Item.Object.Port;

public abstract class Item {
    protected int x1, y1;
    private boolean isSelected = false;
    private boolean isGroup = false;
    private final boolean isInside = false;
    public boolean isInside(Point p){
        return isInside;
    }

    public void setSelected(boolean selected){
        isSelected = selected;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public void setGroup(boolean group){
        isGroup = group;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void reLocate(int x, int y){
        x1 += x;
        y1 += y;
    }

    public void showPort(Graphics g) {}

    public abstract Point[] getItemPoint();

    public abstract void draw(Graphics g);

    public Port getClosetPort(int x, int y) {
        return null;
    }

    public void setObjectName(String itemName) {
    }
}
