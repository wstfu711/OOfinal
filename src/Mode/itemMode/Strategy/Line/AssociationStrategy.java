package Mode.itemMode.Strategy.Line;

import Item.BaseLine;
import Item.Line.AssociationLine;
import Item.Object.Port;

public class AssociationStrategy implements LineStrategy {
    @Override
    public BaseLine createLine(Port fromPort, Port toPort) {
        return new AssociationLine(fromPort, toPort);
    }
}
