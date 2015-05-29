package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

import javax.swing.*;

public class GameController {
    public enum playerShoot {МИМО, ПОПАЛ, НЕТ_ВЫСТРЕЛА} //перечисление выстрелов

    public static boolean isWinner = false;

    //синглетон
    private static GameController instance;

    private GameController() {
    }

    public static synchronized GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

public static void setShootPlayer(int x, int y, ActionButton actionButton) throws InterruptedException {
        Cell shootCell = new Cell(x, y);//получаем координаты выстрела, введееного игроком
        printField(Game.cellsComputer);

        if (!isWinner)
        //TODO вместо isShoot сделать засыпание и просыпангие потоков
        {

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

            printField(Game.cellsPlayer); // показываем поле игрока

            isWinner = isExit(Game.cellsComputer);// проверка на конец игры


        }
        if (isWinner) //конец игры
        {
            String str = "";
            Player.score *= 2.5;
            if (Player.score > Game.scoreComputer)
                str = "Поздравляю, Вы победили! У Вас " + Player.score + " очков. У противника " + Game.scoreComputer + " очков";
            else if (Player.score == Game.scoreComputer)
                str = "Ничья, У вас и компьютера " + Game.scoreComputer + "очков";
            else
                str = "К сожалению, Вы проиграли...У Вас " + Player.score + " очков. У противника " + Game.scoreComputer + " очков";
            System.out.println();

            GameWindow.jtxtResult.setText(str);
            System.out.println("Корабли были расположены так: (X - корабль, 0 - ореол вокруг корабля, - - не попавшие выстрелы, + - попавшие выстрелы )");
            printField(Game.cellsComputer); //выводим поле компьютера
        //    thread.join(1000);
            JOptionPane.showMessageDialog(null, str, "Кто выиграл", JOptionPane.INFORMATION_MESSAGE);



        }
    }


    public static Boolean isExit(Cell[][] cells) { //если игра закончилась
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j].value == 'X') {
                    i = 11;
                    return false;
                }
        }
        return true;
    }

    public static void printField(Cell[][] cells) { // печатаем поле в консоль
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

