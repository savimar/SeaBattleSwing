package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

import java.util.Scanner;



public class Game {
    public void start() {
        System.out.println("Введите свое имя: ");
        Scanner scanner = new Scanner(System.in);

        Player player = new Player(scanner.nextLine());
        System.out.println("Здравствуй, " + player.getName() + "!");
        System.out.println("Начинаем игру");

        Field field = new Field();
        Cell[][] cells = new Cell[10][10];
        cells = field.setCells(cells); //вводим игровое поле компьютера


        System.out.println("Корабли созданы");
        System.out.println();
        System.out.println("Поле расположено так:");

        printField(cells);

        cells = field.setShips(cells); //устанавливаем корабли на поле компьютера
        System.out.println();
        System.out.println("Введите координаты выстрела: (сначала буква, потом цифра)");
        boolean isWinner = false;
        int scoreComputer = 0;
        Cell[][] cellsPlayer = field.setCells(new Cell[10][10]); //вводим поле игрока
        while (!isWinner)

        {
            Scanner scanner1 = new Scanner(System.in);
            String s = scanner1.nextLine();
            Cell shootCell = field.shootCell(s);//получаем координаты выстрела, введееного игроком
            if (shootCell.getY() > 9 || shootCell.getY() > 9) {
                System.out.println("Вы ввели неправильные координаты, введите еще раз");
                isWinner = false;
                continue;
            }
            switch (cells[shootCell.getX()][shootCell.getY()].value) { //проверка координатЮ введенных игроком
                case 'X':
                    System.out.println("Попал");
                    player.score++;
                    cells[shootCell.getX()][shootCell.getY()].value = '+';
                    cellsPlayer[shootCell.getX()][shootCell.getY()].value = '+';
                    break;
                default:
                    System.out.println("Мимо");
                    cells[shootCell.getX()][shootCell.getY()].value = '-';
                    cellsPlayer[shootCell.getX()][shootCell.getY()].value = '-';
                    scoreComputer++;
                    break;
            }

            printField(cellsPlayer); // показываем полу игрока
            isWinner = isExit(cells);// проверка на конец игры

            if (!isWinner) {
                System.out.println();
                System.out.println("Введите координаты выстрела еще раз");
            }
        }


        if (isWinner) //конец игры
        {
            if (player.score > scoreComputer)
                System.out.println("Поздравляю, Вы победили! У Вас " + player.score + " очков. У противника " + scoreComputer + " очков");
            else  if(player.score == scoreComputer) System.out.println("Ничья, У вас и компьютера " + scoreComputer + "очков");
            else
                System.out.println("К сожалению, Вы проиграли...У Вас " + player.score + " очков. У противника " + scoreComputer + " очков");
            System.out.println();
            System.out.println("Корабли были расположены так: (X - корабль, 0 - ореол вокруг корабля, - - не попавшие выстрелы, + - попавшие выстрелы )");
            printField(cells); //выводим поле компьютера
        }
    }

    public void printField(Cell[][] cells) { // печатаем поле
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

    public Boolean isExit(Cell[][] cells) { //если игра закончилась
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
}
