package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

import ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.GUI.GameWindow;
import ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Logics.Game;

public class Main {
    public static void main(String[] args) {
      Game game = new Game();
      game.start(); //начинаем игру
        GameWindow gameWindow = new GameWindow();
        gameWindow.init(); //устанавливаем графическую оболочку
    }
}
