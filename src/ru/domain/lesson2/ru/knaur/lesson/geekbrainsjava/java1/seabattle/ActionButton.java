package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButton implements ActionListener {
    public int x = -1;
    public int y = -1;
    boolean isStart = false;
    public static String getShoot = GameController.playerShoot.НЕТ_ВЫСТРЕЛА.name();
    public static boolean isWinner = false;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isStart) {
            String s = e.getActionCommand();
            setShootPlayer(this.x, this.y, this); //игровой цикл получения координат игрока
        } else if (isStart && (Game.cellsComputer[0][0] == null)) { //если нажата кнопка старта
            Game game = new Game();
            game.start(); //начинаем игру
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

    public static void setShootPlayer(int x, int y, ActionButton actionButton) {
        Cell shootCell = new Cell(x, y);//получаем координаты выстрела, введееного игроком

        switch (Game.cellsComputer[x][y].value) { //проверка координат, введенных игроком
            case 'X':
                System.out.println("Попал");
                Player.score++;
                Game.cellsComputer[shootCell.getX()][shootCell.getY()].value = '+';
                Game.cellsPlayer[shootCell.getX()][shootCell.getY()].value = '+';

                actionButton.getShoot = GameController.playerShoot.ПОПАЛ.name();

                break;
            default:
                System.out.println("Мимо");
                Game.cellsComputer[shootCell.getX()][shootCell.getY()].value = '-';
                Game.cellsPlayer[shootCell.getX()][shootCell.getY()].value = '-';
                Game.scoreComputer++;
                actionButton.getShoot = GameController.playerShoot.МИМО.name();

                break;
        }
        if (!isWinner)
//TODO вместо isShoot сделать засыпание и просыпангие потоков
        {
            printField(Game.cellsPlayer); // показываем полу игрока
            isWinner = isExit(Game.cellsComputer);// проверка на конец игры

            if (isWinner) //конец игры
            {
                Player.score *= 2.5;
                if (Player.score > Game.scoreComputer)
                    System.out.println("Поздравляю, Вы победили! У Вас " + Player.score + " очков. У противника " + Game.scoreComputer + " очков");
                else if (Player.score == Game.scoreComputer)
                    System.out.println("Ничья, У вас и компьютера " + Game.scoreComputer + "очков");
                else
                    System.out.println("К сожалению, Вы проиграли...У Вас " + Player.score + " очков. У противника " + Game.scoreComputer + " очков");
                System.out.println();
                System.out.println("Корабли были расположены так: (X - корабль, 0 - ореол вокруг корабля, - - не попавшие выстрелы, + - попавшие выстрелы )");
                printField(Game.cellsComputer); //выводим поле компьютера
            }
        }
    }

    public static Boolean isExit(Cell[][] cells) { //если игра закончилась
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j].value == 'X') {
                    j = 11;
                    i = 11;
                    return false;
                }
        }
        return true;
    }

    public static void printField(Cell[][] cells) { // печатаем поле
        System.out.println();
        System.out.println("    А Б В Г Д Е Ж З И К");
        System.out.println();
        int i = 1;
        for (Cell[] cell : cells) {
            if (i == 10) System.out.print((i + "  "));
            else System.out.print(i + "   ");

            for (Cell cell1 : cell) {
                System.out.print(cell1.value + " ");
            }
            System.out.println();
            i++;
        }
    }

}
