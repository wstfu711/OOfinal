package Item.Line;

import Item.BaseLine;
import Item.Object.Port;

import java.awt.*;

public class GeneralizationLine extends BaseLine {
    public GeneralizationLine(Port fromPort, Port toPort) {
        super(fromPort, toPort);
    }

    @Override
    public void paintArrow(Graphics g) {
        Point relayPoint = getRelayPoint();
        Point portPoint = new Point();
        portPoint.x = toPort.x1;
        portPoint.y = toPort.y1;
        Point[] trianglePoints = getTrianglePoint(relayPoint, portPoint);

        int[] xPoints = {trianglePoints[0].x, trianglePoints[1].x, toPort.x1};
        int[] yPoints = {trianglePoints[0].y, trianglePoints[1].y, toPort.y1};

        g.drawPolygon(xPoints, yPoints, 3);
    }
}
