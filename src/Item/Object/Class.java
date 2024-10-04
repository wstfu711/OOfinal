package Item.Object;

import Item.RectObject;

import java.awt.*;

public class Class extends RectObject {
    public Class(int x1, int y1) {
        super(x1, y1, 150, 200, "Class");
    }

    @Override
    public void paintObject(Graphics g) {
        System.out.println("x1:" + x1 + "y1:" + y1);
        g.setColor(Color.WHITE);
        g.fillRect(x1 - width / 2, y1 - height / 2, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x1 - width / 2, y1 - height / 2, width, height);
        g.drawLine(x1 - width / 2, y1 - height / 4, x1 + width / 2, y1 - height / 4);
        g.drawLine(x1 - width / 2, y1, x1 + width / 2, y1);
    }

    @Override
    public boolean isInside(Point p) {
        Rectangle rect = new Rectangle(x1 - width / 2, y1 - height / 2, width, height);
        return rect.contains(p);
    }

    public void draw(Graphics g) {
        paintObject(g);
        paintObjectName(g, new Rectangle(x1 - 150 / 2, y1 - 7 * 200 / 8, 150, 200));
    }
}
