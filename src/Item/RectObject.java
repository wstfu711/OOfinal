package Item;

import Item.Object.Port;

import java.awt.*;

public abstract class RectObject extends Item{
    protected int width, height, portSize;
    protected String objectName;
    protected Port[] ports = new Port[4];

    public RectObject(int x1, int y1, int width, int height, String objectName) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        this.objectName = objectName;
        initPorts();
    }

    @Override
    public void draw(Graphics g) {

    }

    protected void initPorts() {
        portSize = 10; // You can define this value based on your needs
        ports[0] = new Port(x1, y1 - height / 2 - portSize / 2); // top
        ports[1] = new Port(x1 + width / 2 + portSize / 2, y1); // right
        ports[2] = new Port(x1, y1 + height / 2 + portSize / 2); // bottom
        ports[3] = new Port(x1 - width / 2 - portSize / 2, y1); // left
    }

    @Override
    public void reLocate(int moveX, int moveY) {
        System.out.println("move");
        super.reLocate(moveX, moveY);
        for (Port port : ports) {
            port.reLocate(moveX, moveY);
        }
    }

    @Override
    public void showPort(Graphics g) {
        for (Port port : ports) {
            port.draw(g);
        }
    }

    @Override
    public Port getClosetPort(int x, int y) {
        Port closestPort = ports[0];
        double closetDisance = getDistance(this.ports[0].x1, this.ports[0].y1, x, y);
        for(int i = 1; i < 4; i++) {
            if(closetDisance > getDistance(this.ports[i].x1, this.ports[i].y1, x, y)) {
                closetDisance = getDistance(this.ports[i].x1, this.ports[i].y1, x, y);
                closestPort = ports[i];
            }
        }
        return closestPort;
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) +  Math.pow(y1 - y2, 2));
    }


    @Override
    public Point[] getItemPoint() {
        return new Point[]{
                new Point(x1 - width / 2, y1 - height / 2),
                new Point(x1 + width / 2, y1 + height / 2)
        };
    }

    protected void paintObjectName(Graphics g, Rectangle rect) {
        FontMetrics metrics = g.getFontMetrics();
        int x = rect.x + (rect.width - metrics.stringWidth(objectName)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(objectName, x, y);
    }

    public abstract void paintObject(Graphics g);

    @Override
    public void setObjectName(String itemName){
        objectName = itemName;
    }
}
