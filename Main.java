package ru.knaur.lesson.geekbrainsjava.java1.seabattle;

public class Main {
    public static void main(String[] args) {


        GameWindow gameWindow = new GameWindow();
        gameWindow.init(); //устанавливаем графическую оболочку
        Game game = new Game();
        game.start(); //начинаем игру

    }
}
