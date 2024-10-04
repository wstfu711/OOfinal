package Item.Object;

import Item.Item;

import java.awt.*;
import java.util.ArrayList;

public class GroupObject extends Item{
    private ArrayList<Item> items = new ArrayList<>();
    private int width;
    private int height;

    public GroupObject(Rectangle selectedArea, ArrayList<Item> items) {
        this.items = items;
        calculateBounds();
    }

    private void calculateBounds() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (Item item : items) {
            Point[] points = item.getItemPoint();
            minX = Math.min(minX, points[0].x);
            minY = Math.min(minY, points[0].y);
            maxX = Math.max(maxX, points[1].x);
            maxY = Math.max(maxY, points[1].y);
        }
        x1 = (minX + maxX) / 2;
        y1 = (minY + maxY) / 2;
        width = maxX - minX;
        height = maxY - minY;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(111, 65, 182, 64));
        g.fillRect(x1 - width / 2, y1 - height / 2, width, height);
        g.setColor(Color.BLACK);
        for (Item item : items) {
            item.draw(g);
        }
    }

    @Override
    public boolean isInside(Point p) {
        return p.x >= x1 - width / 2 && p.x <= x1 + width / 2 &&
                p.y >= y1 - height / 2 && p.y <= y1 + height / 2;
    }

    @Override
    public Point[] getItemPoint() {
        return new Point[] {
                new Point(x1 - width / 2, y1 - height / 2),
                new Point(x1 + width / 2, y1 + height / 2)
        };
    }

    @Override
    public boolean isGroup() {
        return true;
    }

    public ArrayList <Item> getGroupItems(){
        return items;
    }
}
