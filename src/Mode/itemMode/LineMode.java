package Mode.itemMode;

import Editor.Canva;
import Item.Item;
import Mode.Mode;
import Item.Object.Port;
import Item.BaseLine;
import Mode.itemMode.Strategy.Line.LineStrategy;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LineMode extends Mode{
    protected Item fromItem, toItem;
    protected Port fromPort, toPort;
    protected Port tempPort;
    protected BaseLine tempLine;
    protected ArrayList <Item> itemList;
    protected LineStrategy lineStrategy;  // 使用策略模式

    public LineMode(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    protected void getFromPort(Point p) {
        ArrayList<Item> itemList = canva.getItemsByPoint(p);
        if (!itemList.isEmpty() && !itemList.get(0).isGroup()) {
            canva.setSelected(itemList.get(0));
            fromPort = canva.getSelected().getClosetPort(p.x, p.y);
        } else {
            canva.setSelected(null);
        }
    }

    protected void reset() {
        fromItem = toItem = null;
        fromPort = toPort = tempPort = null;
        tempLine = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        getFromPort(e.getPoint());
        if (fromPort != null) {
            tempPort = new Port(e.getX(), e.getY());
            tempLine = lineStrategy.createLine(fromPort, tempPort);  // 使用策略模式創建線條
            Canva.getInstance().addItem(tempLine);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (tempPort != null) {
            tempPort.setPoint(e.getPoint());
            Canva.getInstance().repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(canva.getSelected() != null) {
            canva.getItems().remove(tempLine);
            itemList = canva.getItemsByPoint(e.getPoint());
            if(!itemList.isEmpty() && !itemList.get(0).isGroup()) {
                if(itemList.get(0) != canva.getSelected()) {
                    toPort = itemList.get(0).getClosetPort(e.getPoint().x, e.getPoint().y);
                    canva.addItem(lineStrategy.createLine(fromPort, toPort));
                }
            }
            reset();
            canva.repaint();
        }
    }
}
