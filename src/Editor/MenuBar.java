package Editor;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenuItem groupItem = new JMenuItem("Group");
    private JMenuItem unGroupItem = new JMenuItem("UnGroup");
    private JMenuItem changeItemName = new JMenuItem("Change Object Name");
    public MenuBar(){
        //groupItem.addActionListener();
        groupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Canva.getInstance().groupItem();
            }
        });

        unGroupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Canva.getInstance().unGroupItem();
            }
        });

        changeItemName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Canva.getInstance().changeItemName();
            }
        });


        editMenu.add(groupItem);
        editMenu.add(unGroupItem);
        editMenu.add(changeItemName);

        add(fileMenu);
        add(editMenu);
    }
}
