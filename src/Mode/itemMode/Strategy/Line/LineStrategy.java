package Mode.itemMode.Strategy.Line;
import Item.BaseLine;
import Item.Object.Port;

public interface LineStrategy {
    BaseLine createLine(Port fromPort, Port toPort);
}