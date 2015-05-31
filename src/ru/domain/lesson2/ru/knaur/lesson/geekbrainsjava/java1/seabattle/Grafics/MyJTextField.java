package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Grafics;

import javax.swing.*;
import java.awt.*;

public class MyJTextField extends JTextField {

    public MyJTextField(String text, int columns) {
        this(columns);
        super.setText(text);
    }

    public MyJTextField(int columns) {
        super.setColumns(columns);
        Font font = new Font("Courier", Font.PLAIN, 12);
        super.setFont(font);
        super.setForeground(Color.BLACK);
    }

    public MyJTextField(int columns, Color textColor) {
        super.setColumns(columns);
        Font font = new Font("Courier", Font.PLAIN, 12);
        super.setFont(font);
        super.setForeground(textColor);
    }

}

