package Item.Object;

import Item.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Port extends Item {
    public  int x1, y1;
    private final int size = 10;

    public Port(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x1 - size / 2, y1 - size / 2, size, size);
    }

    public boolean isInside(Point p) {
        return Math.abs(p.x - x1) <= size / 2 && Math.abs(p.y - y1) <= size / 2;
    }
    public void reLocate(int moveX, int moveY) {
        this.x1 += moveX;
        this.y1 += moveY;
    }

    @Override
    public Point[] getItemPoint() {
        return new Point[0];
    }

    public void setPoint(Point p) {
        this.x1 = p.x;
        this.y1 = p.y;
    }
}