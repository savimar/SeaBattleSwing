package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.GUI;

import ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Logics.*;

import javax.swing.*;
import java.util.Map;

import static ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.Logics.Game.*;

public class GameController {
    public enum playerShoot {МИМО, ПОПАЛ, НЕТ_ВЫСТРЕЛА} //перечисление выстрелов

    public enum shipShoot {МИМО, УБИТ, РАНЕН} //перечисление выстрелов

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
        printField(cellsComputer);

        if (!isWinner) {
            Cell cell = Game.cellsComputer[x][y];
            switch (cell.value) { //проверка координат, введенных игроком
                case 'X':
                    System.out.println("Попал");
                    Player.score++;
                    cellsComputer[shootCell.getX()][shootCell.getY()].value = '+';
                    cellsPlayer[shootCell.getX()][shootCell.getY()].value = '+';
                    actionButton.getShoot = playerShoot.ПОПАЛ.name();

                    break;
                default:
                    System.out.println("Мимо");
                    cellsComputer[shootCell.getX()][shootCell.getY()].value = '-';
                    cellsPlayer[shootCell.getX()][shootCell.getY()].value = '-';
                    scoreComputer++;
                    actionButton.getShoot = playerShoot.МИМО.name();

                    break;
            }

            printField(cellsPlayer); // показываем поле игрока

            isWinner = isExit(cellsComputer);// проверка на конец игры
        }
        if (isWinner) //конец игры
        {
            String str;
            Player.score *= 2.5;
            if (Player.score > scoreComputer)
                str = "Поздравляю, Вы победили! У Вас " + Player.score + " очков. У противника " + scoreComputer + " очков";
            else if (Player.score == scoreComputer)
                str = "Ничья, У вас и компьютера " + scoreComputer + "очков";
            else
                str = "К сожалению, Вы проиграли...У Вас " + Player.score + " очков. У противника " + scoreComputer + " очков";
            System.out.println();

            GameWindow.jtxtResult.setText(str);
            System.out.println("Корабли были расположены так: (X - корабль, 0 - ореол вокруг корабля, - - не попавшие выстрелы, + - попавшие выстрелы )");
            printField(cellsComputer); //выводим поле компьютера
            //    thread.join(1000);
            JOptionPane.showMessageDialog(null, str, "Кто выиграл", JOptionPane.INFORMATION_MESSAGE);


        }
    }


    public static Boolean isExit(Cell[][] cells) { //если игра закончилась
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j].value == 'X') {
                    i = 11;
                    j = 11;

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

    public static void getWounded(int x, int y, ActionButton actionButton) {
        int shoot = 0;
        for (Map.Entry<String, Ship> pair : Field.ships.entrySet()) {
            String[] s = pair.getKey().split("/");
            if (Integer.parseInt(s[0]) == x && Integer.parseInt(s[1]) == y) {
                Ship ship = pair.getValue();
                if (ship.getDesk() == 1)
                    actionButton.shipShoot = shipShoot.УБИТ.name();
                else {
                    for (String cell : ship.shipCells) {
                        String[] s1 = cell.split("/");
                        if (Game.cellsPlayer[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])].value != '+') {
                            shoot++;
                        }
                    }
                }
            }
        }
        if (shoot > 0) actionButton.shipShoot = shipShoot.РАНЕН.name();
        else actionButton.shipShoot = shipShoot.УБИТ.name();
    }


}






