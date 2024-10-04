package Editor;

import Item.Item;
import Item.Object.GroupObject;
import Mode.Mode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

public class Canva extends JPanel {
    public static Canva instance = new Canva();
    private ArrayList<Item> itemList = new ArrayList<>();
    private Item selectedItem;
    public Rectangle selectedArea;

    private Mode currentMode;
    private GroupManager groupManager;
    public Canva(){
        groupManager = new GroupManager();
    }

    public void setMode(Mode mode) {
        selectedItem = null;
        if (currentMode != null) {
            removeMouseListener(currentMode);
            removeMouseMotionListener(currentMode);
        }
        currentMode = mode;
        addMouseListener(currentMode);
        addMouseMotionListener(currentMode);
        System.out.println("setMode");
        if(Objects.equals(currentMode, mode)){
            System.out.println("setClass");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Item item : itemList) {
            item.draw(g);
        }
        if (selectedArea != null) {
            g.setColor(new Color(74, 55, 114, 64));
            g.fillRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);
            g.setColor(Color.BLACK);
            g.drawRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);
        }
        if (selectedItem != null && selectedItem.isGroup()) {
            for (Item item : ((GroupObject) selectedItem).getGroupItems()) { //related problem?
                item.showPort(g);
            }
        } else if (selectedItem != null) {
            selectedItem.showPort(g);
        }

        if (selectedItem != null) {
            selectedItem.showPort(g);
        }
    }

    public static Canva getInstance(){
        return instance;
    }

    public ArrayList<Item> getItems() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void setSelected(Item item) {
        selectedItem = item;
        repaint();
    }

    public Item getSelected() {
        return selectedItem;
    }

    public ArrayList<Item> getItemsByPoint(Point p) {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = itemList.size() - 1; i >= 0; i--) {
            if (itemList.get(i).isInside(p)) {
                result.add(itemList.get(i));
            }
        }
        return result;
    }

    public ArrayList<Item> getItemsByRect(Rectangle r) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : itemList) {
            int isInside = 0;
            for (Point p : item.getItemPoint()) {
                if (r != null && r.contains(p)) {
                    isInside++;
                }
            }
            if (isInside > 1) {
                result.add(item);
            }
        }
        return result;
    }

    public void groupItem() {
        groupManager.groupItems(selectedArea);
    }

    public void unGroupItem() {
        groupManager.ungroupItems(selectedItem);
    }

    public void changeItemName() {
        if (selectedItem != null && !selectedItem.isGroup()) {
            String itemName = JOptionPane.showInputDialog("請輸入 Class 名稱");
            if (itemName != null) {
                selectedItem.setObjectName(itemName);
                repaint();
            }
        }
    }
}
