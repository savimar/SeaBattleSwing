package ru.knaur.lesson.geekbrainsjava.java1.seabattle;


import com.jtattoo.plaf.mint.MintLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameWindow {
    //элементы графической оболочки
    private MyJButton start;
    public MyJButton btnPlay;
    private MyJTextField jtxtResult;
    private MyJPanel panel1;
    // private MyJPanel panel2;
    private MyJPanel panel3;
    private MyJPanel panelSub1;
    private MyJPanel panelSub1Horizontal;
    private MyJPanel panelSub1Vertical;
    public MyJButton[] myJButtons = new MyJButton[100]; //массив мгровых кнопок

//    private MyJPanel panelSub2;

    private MyJFrame frame;


    public void init() {

        try {
            UIManager.setLookAndFeel(new MintLookAndFeel()); //выбор скрина из библиотеки
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

           /* try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // выбор скрина из стиля ОС
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        GameWindow nCl = new GameWindow();//старт заполнения графической оболочки
        //   nCl.createLabels();
        nCl.createTextFields();
        nCl.createButtons();
        nCl.createPanels();
        nCl.createFrame();

    }

   /* private void createLabels() { //надписи

    }*/

    private void createTextFields() {
        jtxtResult = new MyJTextField(15, Color.RED); // текстовое поле для отображения ответов компьютера
        jtxtResult.setEditable(false);
        jtxtResult.setFocusable(false);

    }

    private void createButtons() {
        start = new MyJButton("Старт");// кнопка старт
        start.setSize(new Dimension(200, 50));
        start.addActionListener(new ActionButton(true));
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {// кнопки игрового поля
                btnPlay = new MyJButton("*");
                myJButtons[k] = btnPlay;
                k++;
                ActionButton actionButton = new ActionButton(i, j);
                btnPlay.addActionListener(actionButton);
                if (actionButton.getShoot.equals(GameController.playerShoot.ПОПАЛ)) btnPlay.setText("+");
                else if (actionButton.getShoot.equals(GameController.playerShoot.МИМО)) btnPlay.setText("-");

            }
        }


    }

    private void createPanels() {
        panel1 = new MyJPanel("panel1", 410, 410);//основная панель
        panel1.setPreferredSize(new Dimension(410, 410));

        panelSub1 = new MyJPanel("Sub1", 400, 400);//панель игрового поля
        panelSub1.setPreferredSize(new Dimension(400, 400));
        panelSub1.setLayout(new GridLayout(10, 10, 2, 2));
        for (MyJButton myJButton : myJButtons) { //заполнение игрового поля кнопками
            panelSub1.add(myJButton);
        }

        panel1.setLayout(new BorderLayout());
        panel1.add(panelSub1, BorderLayout.CENTER);

        panelSub1Horizontal = new MyJPanel("1", 400, 20); //панель горизонтальных кнопок

        panelSub1Horizontal.setLayout(new GridLayout(1, 11, 2, 2));//панель букв
        MyJButton btn = new MyJButton(); //
        btn.setIcon(new ImageIcon("boat.png"));

        panelSub1Horizontal.add(btn); //заполняем поле буквами
        panelSub1Horizontal.add(new MyJButton("A", true));
        panelSub1Horizontal.add(new MyJButton("Б", true));
        panelSub1Horizontal.add(new MyJButton("В", true));
        panelSub1Horizontal.add(new MyJButton("Г", true));
        panelSub1Horizontal.add(new MyJButton("Д", true));
        panelSub1Horizontal.add(new MyJButton("Е", true));
        panelSub1Horizontal.add(new MyJButton("Ж", true));
        panelSub1Horizontal.add(new MyJButton("З", true));
        panelSub1Horizontal.add(new MyJButton("И", true));
        panelSub1Horizontal.add((new MyJButton("К", true)));


        panel3 = new MyJPanel("panel3", 50, 15);
        panel3.setPreferredSize(new Dimension(100, 30));
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT)); //панель для кнопки старт
        //  panel3.add(labelResult);
        panel3.add(start); //добавление кнопки старт
        //  panel3.add(jtxtResult);


        panel1.add(panelSub1Horizontal, BorderLayout.NORTH);


        panelSub1Vertical = new MyJPanel("1", 400, 20); //панель для цифр

        panelSub1Vertical.setLayout(new GridLayout(10, 1, 2, 2));
        // panelSub1Vertical.add(new MyJButton(" ", true));
        panelSub1Vertical.add(new MyJButton("1", true));//заполняем цифрами
        panelSub1Vertical.add(new MyJButton("2", true));
        panelSub1Vertical.add(new MyJButton("3", true));
        panelSub1Vertical.add(new MyJButton("4", true));
        panelSub1Vertical.add(new MyJButton("5", true));
        panelSub1Vertical.add(new MyJButton("6", true));
        panelSub1Vertical.add(new MyJButton("7", true));
        panelSub1Vertical.add(new MyJButton("8", true));
        panelSub1Vertical.add(new MyJButton("9", true));
        panelSub1Vertical.add((new MyJButton("10", true)));

        panel1.add(panelSub1Vertical, BorderLayout.WEST);


        panel1.add(jtxtResult, BorderLayout.SOUTH);

        /*
        panel1.add(jtxtChislo1); //2 панель для случая ручного ввода
        panel1.add(labelChislo2);
        panel1.add(jtxtChislo2);


        panel2.add(btnAdd);
        panel2.add(btnSubtract);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);
        */


       /* for (int i = 0; i < 100; i++) {
            panel2.add(new Button("*"));
              }
               */


    }

    private void createFrame() {//основная рамка
        frame = new MyJFrame("Морской бой", 400, 400, new BorderLayout(2, 2));
        frame.setMinimumSize(new Dimension(200, 200));

        //  frame.setResizable(false);

        frame.getContentPane().add(panel1, BorderLayout.CENTER);
        frame.getContentPane().add(panel3, BorderLayout.NORTH);

//        frame.getContentPane().add(panel2);

        frame.setVisible(true);

    }

}

