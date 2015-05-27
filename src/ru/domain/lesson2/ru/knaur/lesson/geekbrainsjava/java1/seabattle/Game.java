package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

public class Game {
    public static Cell[][] cellsComputer = new Cell[10][10];
    public static Cell[][] cellsPlayer = new Cell[10][10];
    public static int scoreComputer = 0;



    public void start() {
    System.out.println("Начинаем игру");

        Field field = new Field();

        cellsComputer = field.setCells(cellsComputer); //вводим игровое поле компьютера
        cellsPlayer = field.setCells(cellsPlayer); //вводим поле игрока

        cellsComputer = field.setShips(cellsComputer); //устанавливаем корабли на поле компьютера

    }


}
