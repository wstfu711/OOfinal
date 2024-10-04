package Item.Object;

import Item.RectObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Usecase extends RectObject {
    public Usecase(int x1, int y1) {
        super(x1, y1, 150, 100, "UseCase");
    }

    @Override
    public void paintObject(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x1 - width / 2, y1 - height / 2, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x1 - width / 2, y1 - height / 2, width, height);
    }

    @Override
    public boolean isInside(Point p) {
        Rectangle rect = new Rectangle(x1 - width / 2, y1 - height / 2, width, height);
        return rect.contains(p);
    }

    public void draw(Graphics g) {
        paintObject(g);
        paintObjectName(g, new Rectangle(x1 - 150 / 2, y1 - 7 * 100 / 8, 150, 100));
    }
}
