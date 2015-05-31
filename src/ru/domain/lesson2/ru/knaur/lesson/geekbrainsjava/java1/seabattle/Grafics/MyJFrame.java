package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Grafics;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    public MyJFrame(String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        super.setIconImage(new ImageIcon("boat.png").getImage());
    }

    public MyJFrame(String title, int width, int height, Component comp) {
        this(title, width, height);
        super.getContentPane().add(comp);
    }

    public MyJFrame(String title, int width, int height, LayoutManager layout) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(layout);
        super.setIconImage(new ImageIcon("icon.png").getImage());
    }
}
