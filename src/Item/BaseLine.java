package Item;

import Item.Object.Port;
import Item.RectObject;

import java.awt.*;

public abstract class BaseLine extends Item{
    protected Port fromPort, toPort;
    protected int arrowWidth = 18;
    protected int arrowHeight = 24;

    public BaseLine(Port fromPort, Port toPort) {
        this.fromPort = fromPort;
        this.toPort = toPort;
    }

    @Override
    public void draw(Graphics g) {
        paintLine(g);
        paintArrow(g);
    }

    public void reLocate(int moveX, int moveY) {

    }
    protected void paintLine(Graphics g) {
        Point relayPoint = getRelayPoint();
        g.drawLine(fromPort.x1, fromPort.y1, relayPoint.x, relayPoint.y);
    }

    protected abstract void paintArrow(Graphics g);

    protected Point getRelayPoint() {
        double dx = toPort.x1 - fromPort.x1;
        double dy = toPort.y1 - fromPort.y1;
        double m = Math.sqrt(Math.pow(arrowHeight, 2) / (dx * dx + dy * dy));
        return new Point(
                (int) (toPort.x1 - m * dx),
                (int) (toPort.y1 - m * dy)
        );
    }

    @Override
    public Point[] getItemPoint() {
        return new Point[]{
                new Point(fromPort.x1, fromPort.y1),
                new Point(toPort.x1, toPort.y1)
        };
    }

    public Point [] getTrianglePoint(Point relay, Point end) {

        Point [] result = new Point[2];
        result[0] = new Point();
        result[1] = new Point();

        double x1 = fromPort.x1, y1 = fromPort.y1,
                x2 = toPort.x1, y2 = toPort.y1;

        double dx = x2 - x1;
        double dy = y2 - y1;

        double m = Math.sqrt(Math.pow(arrowWidth, 2) / (Math.pow(dx, 2) + Math.pow(dy, 2)));
        x1 = relay.x + m * dy;
        y1 = relay.y - m * dx;
        x2 = relay.x - m * dy;
        y2 = relay.y + m * dx;

        result[0].x = (int) x1;
        result[0].y = (int) y1;
        result[1].x = (int) x2;
        result[1].y = (int) y2;

        return result;
    }
}
