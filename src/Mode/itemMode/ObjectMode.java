package Mode.itemMode;

import Editor.Canva;
import Item.Object.Usecase;
import Mode.Mode;
import Item.Object.Class;
import Mode.itemMode.Strategy.Line.LineStrategy;
import Mode.itemMode.Strategy.Object.ObjectStrategy;

import java.awt.event.MouseEvent;

public class ObjectMode extends Mode{
    protected ObjectStrategy objectStrategy;

    public ObjectMode(ObjectStrategy objectStrategy) {
        this.objectStrategy = objectStrategy;
        System.out.println("setStrategy");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed Class");
        Canva canva = Canva.getInstance();
        canva.addItem(objectStrategy.createObject(e.getX(), e.getY()));
        canva.repaint();

    }
}
