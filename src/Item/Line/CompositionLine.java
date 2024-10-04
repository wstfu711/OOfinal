package Item.Line;

import Item.BaseLine;
import Item.Object.Port;

import java.awt.*;

public class CompositionLine extends BaseLine {
    public CompositionLine(Port fromPort, Port toPort) {
        super(fromPort, toPort);
        arrowWidth = 12;
        arrowHeight = 36;
    }

    @Override
    public void paintArrow(Graphics g) {
        Point relayPoint = getRelayPoint();
        Point portPoint = new Point();
        portPoint.x = toPort.x1;
        portPoint.y = toPort.y1;
        Point[] trianglePoints = getTrianglePoint(relayPoint, portPoint);
        Point [] triangleReverse = getTrianglePoint(portPoint, relayPoint);
        for(int i = 0; i < 2; i++) {
            trianglePoints[i].x = (trianglePoints[i].x + triangleReverse[i].x) / 2;
            trianglePoints[i].y = (trianglePoints[i].y + triangleReverse[i].y) / 2;
        }

        int[] xPoints = {trianglePoints[0].x, toPort.x1, trianglePoints[1].x, relayPoint.x};
        int[] yPoints = {trianglePoints[0].y, toPort.y1, trianglePoints[1].y, relayPoint.y};
        g.fillPolygon(xPoints, yPoints, 4);
    }
}
