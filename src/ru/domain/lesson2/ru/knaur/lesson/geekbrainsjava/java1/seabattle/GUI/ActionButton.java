package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.GUI;

import ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Grafics.MyJButton;
import ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Logics.Game;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ActionButton implements ActionListener {
    public int x = -1;
    public int y = -1;
    boolean isStart = false;
    public static String getShoot = GameController.playerShoot.НЕТ_ВЫСТРЕЛА.name();
    public static String shipShoot = GameController.shipShoot.МИМО.name();


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Прервать")) {
           /* Thread thread = Thread.currentThread();
            if (thread.isAlive()) {
                thread.interrupt();
            }*/
        } else {
            if (!isStart) {


                String str = "";
                String buttonText = "";
                Color color = null;
                String path = "";


                try {
                    GameController.setShootPlayer(this.x, this.y, this); //игровой цикл получения координат игрок
                } catch (Exception e1) {
                    e1.printStackTrace();
                }


                if (getShoot.equals("МИМО")) {
                    str = "Мимо!";
                    buttonText = "-";
                    color = Color.RED;
                    path = "c://orchhit.wav";

                } else if (getShoot.equals("ПОПАЛ")) {
                    GameController.getWounded(this.x, this.y, this);
                    if (this.shipShoot.equals("РАНЕН")) {
                        str = "Ранен";
                        path = "c://44.wav";
                        buttonText = "+";
                        color = Color.BLUE;
                    } else {
                        str = "Убит";
                        buttonText = "+";
                        color = Color.BLUE;
                        path = "c://sdwin.wav";
                    }
                }

                if (!GameController.isWinner) {

                    File wavFile = new File(path);
                    AudioClip sound = null;
                    try {

                        sound = Applet.newAudioClip(wavFile.toURL());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    sound.play();
                }
                JOptionPane.showMessageDialog(null, str, "выстрел", JOptionPane.PLAIN_MESSAGE);


                if (!GameController.isWinner) GameWindow.jtxtResult.setText(str);
                if (e.getSource() instanceof JButton && !GameController.isWinner) {
                    MyJButton btn = (MyJButton) e.getSource();
                    Font f = new Font("Courier", Font.BOLD, 18);

                    btn.setFont(f);
                    btn.setForeground(color);
                    btn.setText(buttonText);

                } else if (isStart && (Game.cellsComputer[0][0] == null)) { //если нажата кнопка старта
                    Game game = new Game();
                    game.start(); //начинаем игру
                }
            }
        }
    }


    public ActionButton(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ActionButton() {
    }

    public ActionButton(boolean isStart) {
        this.isStart = isStart;
    }


}
