package Mode.itemMode.Strategy.Line;

import Item.BaseLine;
import Item.Line.GeneralizationLine;
import Item.Object.Port;

public class GeneralizationStrategy implements LineStrategy {
    @Override
    public BaseLine createLine(Port fromPort, Port toPort) {
        return new GeneralizationLine(fromPort, toPort);
    }
}
