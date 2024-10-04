package Mode.itemMode.Strategy.Line;

import Item.BaseLine;
import Item.Line.CompositionLine;
import Item.Object.Port;

public class CompositionStrategy implements LineStrategy {
    @Override
    public BaseLine createLine(Port fromPort, Port toPort) {
        return new CompositionLine(fromPort, toPort);
    }
}
