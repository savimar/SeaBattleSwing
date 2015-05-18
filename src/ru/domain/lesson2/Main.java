package ru.domain.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите свое имя: ");
        Scanner scanner = new Scanner(System.in);

        Player player = new Player(scanner.nextLine());
        System.out.println("Здравствуй, " + player.getName() + "!");
        System.out.println("Начинаем игру");

        Field field = new Field();
        Cell[][] cells = new Cell[10][10];
        cells = field.setCells(cells);
        cells = field.setShips(cells);
        System.out.println("Корабли созданы");
        System.out.println();

        Random r = new Random();
        boolean winner = r.nextBoolean();
        if (!winner) System.out.println("Поздравляю, Вы победили!");
        else System.out.println("К сожалению, Вы проиграли...");
        System.out.println();
        System.out.println("Корабли были расположены так: (X - корабль, 0 - ореол вокруг корабля )");
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
