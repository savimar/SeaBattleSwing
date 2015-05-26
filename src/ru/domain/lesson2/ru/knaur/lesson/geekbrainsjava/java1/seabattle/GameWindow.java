package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;


import com.jtattoo.plaf.mint.MintLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameWindow {

        private MyJButton btnAdd;
        private MyJButton boxBtn;
        private MyJButton btnDivide;
        private MyJButton btnMultiply;
        private JLabel labelChislo1;
        private JLabel labelChislo2;
        private JLabel labelResult;
        private MyJTextField jtxtChislo1;
        private MyJTextField jtxtChislo2;
        private MyJTextField jtxtResult;
        private MyJPanel panel1;
    private MyJPanel panel2;
       private MyJPanel panel3;
        private MyJPanel panelSub1;
        private MyJPanel panelSub1Horizontal;

        private MyJPanel panelSub2;

        private MyJFrame frame;


        public void  init (){

            try {
                UIManager.setLookAndFeel(new MintLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

           /* try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
           GameWindow nCl = new GameWindow();

            nCl.createLabels();
            nCl.createTextFields();
            nCl.createButtons();
            nCl.createPanels();
            nCl.createFrame();

        }
        private void createLabels() {
            labelChislo1 = new JLabel("А Б В Г Д Е Ж З И К");
            //"<html><b>OK</font></b></html>");
            //  String text = "<html>  <<p align=\"justify\"> А Б В Г Д Е Ж З И К </p></html>";
            //    String text = "<html>  <ul> <li>А Б В Г Д Е Ж З И К </li><ul></html>";
            // Font font = new Font()
            //      labelChislo1.setText(text);
            labelChislo2 = new JLabel("Число 2");
            labelResult = new JLabel("Результат");
        }

        private void createTextFields() {
            jtxtChislo1 = new MyJTextField(10);
            jtxtChislo2 = new MyJTextField(10);

            jtxtResult = new MyJTextField(15, Color.RED);
            jtxtResult.setEditable(false);
            jtxtResult.setFocusable(false);

        }

        private void createButtons() {
            String name = "";
            btnAdd = new MyJButton("*");

        }

        private void createPanels() {
            panel1 = new MyJPanel("panel1", 410, 410);
            panel1.setPreferredSize(new Dimension(410, 410));

            panelSub1 = new MyJPanel("Sub1", 400, 400);
            panelSub1.setPreferredSize(new Dimension(400, 400));
            panel1.setLayout(new BorderLayout());
            panel1.add(panelSub1, BorderLayout.CENTER);

       panelSub1Horizontal = new MyJPanel("1", 400, 20);

            panelSub1Horizontal.setLayout(new BoxLayout(panelSub1Horizontal, BoxLayout.X_AXIS));


             panel3 = new MyJPanel("panel3", 50, 15);
             panel3.setPreferredSize(new Dimension(100, 30));
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel3.add(labelResult);
            panel3.add(jtxtResult);





            panelSub1.setLayout(new GridLayout(10,10,2,2));

            Box boxH = Box.createHorizontalBox();
//            boxH.setLayout(new BoxLayout(panelSub1, BoxLayout.X_AXIS));
    //       boxH.setLayout(new BoxLayout(panelSub1, BoxLayout.X_AXIS));
          //  box.setLayout(new FlowLayout(FlowLayout.LEADING));
            // Button buttonA = MyJButton.get
            //    box.add(MyJButton.getB);
            //
            boxH.add(Box.createHorizontalStrut(7));
            boxH.add(Box.createHorizontalGlue());
              boxH.updateUI();
//            boxH.add(Box.createRigidArea(new Dimension(15, 5)));
            boxH.add(new MyJButton(" ", true));
            boxH.add(Box.createGlue());
            boxH.add(new MyJButton("А", true));
            boxH.add(Box.createGlue());
                boxH.add(Box.createHorizontalStrut(7));
            boxH.add(new MyJButton("Б", true));
            boxH.add(Box.createGlue());
                boxH.add(Box.createHorizontalStrut(7));
            boxH.add(new MyJButton("В", true));
            boxH.add(Box.createGlue());
                boxH.add(Box.createHorizontalStrut(7));
            boxH.add(new MyJButton("Г", true));
            boxH.add(Box.createGlue());
            boxH.add(Box.createHorizontalStrut(7));
                      boxH.add(new MyJButton("Д", true));
              boxH.add(Box.createGlue());
              boxH.add(Box.createHorizontalStrut(7));
            boxH.add(new MyJButton("Е", true));
            boxH.add(Box.createGlue());
                boxH.add(Box.createHorizontalStrut(7));
            boxH.add(new MyJButton("Ж", true));
                boxH.add(Box.createHorizontalStrut(7));
              boxH.add(Box.createGlue());
            boxH.add(new MyJButton("З", true));
                boxH.add(Box.createHorizontalStrut(7));
              boxH.add(Box.createGlue());
            boxH.add(new MyJButton("И", true));
            boxH.add(Box.createGlue());
                boxH.add(Box.createHorizontalStrut(7));
            boxH.add(new MyJButton("К", true));
              boxH.add(Box.createGlue());

        panelSub1Horizontal.add(boxH);
           /*Component horizontalGlue = Box.createHorizontalGlue();
            panel1.add(horizontalGlue);
            panel1.setMaximumSize(new Dimension(30, 30));*/
            panel1.add(panelSub1Horizontal, BorderLayout.NORTH);



            Box boxV = Box.createVerticalBox();
            boxV.add(new MyJButton(" 1", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 2", true));
             boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 3", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 4", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 5", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 6", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 7", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 8", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton(" 9", true));
              boxV.add(Box.createGlue());
            boxV.add(new MyJButton("10", true));
              boxV.add(Box.createGlue());


            panel1.add(boxV, BorderLayout.WEST);




        /*
        panel1.add(jtxtChislo1);
        panel1.add(labelChislo2);
        panel1.add(jtxtChislo2);


        panel2.add(btnAdd);
        panel2.add(btnSubtract);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);
        */

            for (int i = 0; i < 100; i++) {
                panelSub1.add(new Button("*"));
            }
       /* for (int i = 0; i < 100; i++) {
            panel2.add(new Button("*"));
              }
               */




        }

        private void createFrame() {
            frame = new MyJFrame("Морской бой", 400, 400, new BorderLayout(2, 2));
            frame.setMinimumSize(new Dimension(200, 200));

            //  frame.setResizable(false);

            frame.getContentPane().add(panel1, BorderLayout.CENTER);
            frame.getContentPane().add(panel3, BorderLayout.NORTH);

//        frame.getContentPane().add(panel2);


            frame.setVisible(true);

        }

    }


