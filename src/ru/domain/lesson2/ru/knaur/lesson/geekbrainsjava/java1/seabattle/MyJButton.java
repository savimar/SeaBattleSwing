package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

import javax.swing.*;
import java.awt.*;


public class MyJButton extends JButton {
    boolean isBoxButton = false;

    public MyJButton(String title) {
        super.setText(title);
    }


    public MyJButton(String title, int width, int height) {
        this(title);
        super.setSize(width, height);
    }

    public MyJButton(String text, boolean isBoxButton) {
        super(text);
        this.isBoxButton = isBoxButton;

        Font f = new Font("Courier", Font.BOLD, 14);
        this.setFont(f);
        this.setBackground(Color.CYAN);
        this.setForeground(Color.darkGray);
        super.setMinimumSize(new Dimension(10, 10));
        super.setSize(25, 25);

    }

    public MyJButton() {
    }

    public MyJButton(Icon icon) {
        super(icon);
    }
}

