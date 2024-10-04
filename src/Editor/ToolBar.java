package Editor;

import javax.swing.*;

import Mode.itemMode.LineMode;
import Mode.itemMode.ObjectMode;
import Mode.itemMode.SelectMode;
import Mode.itemMode.Strategy.Line.AssociationStrategy;
import Mode.itemMode.Strategy.Line.CompositionStrategy;
import Mode.itemMode.Strategy.Line.GeneralizationStrategy;
import Mode.itemMode.Strategy.Object.ClassStrategy;
import Mode.itemMode.Strategy.Object.UsecaseStrategy;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar{
    private JButton selectButton;
    private JButton associationButton;
    private JButton generalizationButton;
    private JButton compositionButton;
    private JButton classButton;
    private JButton useCaseButton;

    private boolean mouseListenerActive = false;

    Canva canva = Canva.getInstance();

    public ToolBar() {
        selectButton = new JButton(new ImageIcon("resources/select.jpg"));
        associationButton = new JButton(new ImageIcon("resources/association_line.jpg"));
        generalizationButton = new JButton(new ImageIcon("resources/generalization_line.jpg"));
        compositionButton = new JButton(new ImageIcon("resources/composition_line.jpg"));
        classButton = new JButton(new ImageIcon("resources/class.jpg"));
        useCaseButton = new JButton(new ImageIcon("resources/use_case.jpg"));

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //canva.getInstance().getMode().setCurrentMode(new SelectMode());
                canva.setMode(new SelectMode());
                resetButtonBackground();
                selectButton.setBackground(Color.gray);
            }
        });
        associationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //canva.getInstance().getMode().setCurrentMode(new LineMode(new AssociationStrategy()));
                canva.setMode(new LineMode(new AssociationStrategy()));
                resetButtonBackground();
                associationButton.setBackground(Color.gray);
            }
        });
        compositionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //canva.getInstance().getMode().setCurrentMode(new LineMode(new CompositionStrategy()));
                canva.setMode(new LineMode(new CompositionStrategy()));
                resetButtonBackground();
                compositionButton.setBackground(Color.gray);
            }
        });
        generalizationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //canva.getInstance().getMode().setCurrentMode(new LineMode(new GeneralizationStrategy()));
                canva.setMode(new LineMode(new GeneralizationStrategy()));
                resetButtonBackground();
                generalizationButton.setBackground(Color.gray);
            }
        });
        classButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //canva.getInstance().getMode().setCurrentMode(new ObjectMode(new ClassStrategy()));
                canva.setMode(new ObjectMode(new ClassStrategy()));
                resetButtonBackground();
                classButton.setBackground(Color.gray);
            }
        });
        useCaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //canva.getInstance().getMode().setCurrentMode(new ObjectMode(new UsecaseStrategy()));
                canva.setMode(new ObjectMode(new UsecaseStrategy()));
                resetButtonBackground();
                useCaseButton.setBackground(Color.gray);
            }
        });

        setFloatable(false);
        setLayout(new GridLayout(0, 1));
        add(selectButton);
        add(associationButton);
        add(generalizationButton);
        add(compositionButton);
        add(classButton);
        add(useCaseButton);
    }

    public void resetButtonBackground() {
        for (Component c : getComponents()) {
            c.setBackground(Color.white);
        }
    }
}
