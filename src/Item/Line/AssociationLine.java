package Item.Line;

import Item.BaseLine;
import Item.Object.Port;

import java.awt.*;

public class AssociationLine extends BaseLine {
    public AssociationLine(Port fromPort, Port toPort) {
        super(fromPort, toPort);
    }

    @Override
    public void paintArrow(Graphics g) {
        Point relayPoint = getRelayPoint();
        Point portPoint = new Point();
        portPoint.x = toPort.x1;
        portPoint.y = toPort.y1;
        Point[] trianglePoints = getTrianglePoint(relayPoint, portPoint);

        g.drawLine(trianglePoints[0].x, trianglePoints[0].y, toPort.x1, toPort.y1);
        g.drawLine(trianglePoints[1].x, trianglePoints[1].y, toPort.x1, toPort.y1);
        g.drawLine(relayPoint.x, relayPoint.y, toPort.x1, toPort.y1);
    }
}
