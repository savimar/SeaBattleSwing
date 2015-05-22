package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

import java.util.Random;

public class Field {
    final int COUNTSHIPS1 = 4;
    final int COUNTSHIPS2 = 3;
    final int COUNTSHIPS3 = 2;
    final int COUNTSHIPS4 = 1;


    public Cell[][] setCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell('*');
            }
        }
        return cells;
    }

    public Cell[][] setShips(Cell[][] cells) {
        cells = setShips(cells, COUNTSHIPS4, 4); // устанавливаем 4-палубный корабль
        cells = setShips(cells, COUNTSHIPS3, 3); // 3-палубный и.т.п.
        cells = setShips(cells, COUNTSHIPS2, 2);
        cells = setShips(cells, COUNTSHIPS1, 1);

        return cells;
    }

    public Cell[][] setShips(Cell[][] cells, int countShip, int countDecks) { //установка корабля на поле

        int i = 1;
        while (i <= countShip) {
            Ship ship = setShip(countDecks);
            ship.isShipDelivered = true;
            cells = setOutside(cells, ship);
            Cell cellL = ship.getLeftUp();
            Cell cellR = ship.getRightDown();
            if (cells[cellL.getX()][cellL.getY()].value == 'X' && cells[cellR.getX()][cellR.getY()].value == 'X' && ship.isShipDelivered) {
                i++;
            }
        }
        return cells;
    }

    public Ship setShip(int desk) {
        Random random = new Random(); //получаем рандомные координаты корабля
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        boolean isRoute = random.nextBoolean();
        if (x > 6 && desk == 4) isRoute = false; // если корабль выходит за пределы поля, меняем направление
        if (y > 6 && desk == 4) isRoute = true;
        if (x > 7 && desk == 3) isRoute = false;
        if (y > 7 && desk == 3) isRoute = true;
        if (x > 8 && desk == 2) isRoute = false;
        if (y > 8 && desk == 2) isRoute = true;

        Cell cell = new Cell(x, y);
        Ship ship = new Ship(desk, cell, isRoute);

        return ship;
    }

    public Cell[][] setOutside(Cell[][] cells, Ship ship) {
        Cell cell = ship.getLeftUp();

        boolean isRoute = ship.isRoute();
        int x = cell.getX();
        int y = cell.getY();


        if (isRoute) {
            setRouteTrue(cells, x, ship, y);

        } else {
            setRouteFalse(cells, x, ship, y);
        }
        return cells;
    }


    public Cell[][] setRouteTrue(Cell[][] cells, int x, Ship ship, int y) { //установка горизонтального корабля
        int desks = ship.getDesk();
        for (int i = 0; i < desks; i++) {
            if (x > 6 && y > 6 && desks == 4) { // если корабль выходит за пределы поля
                ship.isShipDelivered = false;
                break;
            }
            if (x > 7 && y > 7 && desks == 3) {
                ship.isShipDelivered = false;
                break;
            }
            if (x > 8 && y > 8 && desks == 2) {
                ship.isShipDelivered = false;
                break;
            }
            if (cells[x][y].value != '*') {
                //              ship.isShipDelivered = false;
                break;
            }
            for (int h = 0; h < desks; h++) {
                int z = x + h;
                if (z > 9) z = 9;
                if (cells[z][y].value != '*') {
                    ship.isShipDelivered = false;
                    break;
                }

                cells[z][y].value = 'X'; //устанавливаем корабль
            }


            for (int j = 0; j < desks; j++) {


                for (int f = x + j - 1; f <= x + j + 1; f++) { //устанавливаем ореол вокруг корабля
                    if (f < 0) f = 0;
                    for (int k = y - 1; k <= y + 1; k++) {
                        if (k < 0) k = 0;
                        if (k > 9 || f > 9) {
                            if (k > 9) k = 9;
                            if (f > 9) f = 9;
                            if (cells[f][k].value != 'X')
                                cells[f][k].value = '0';

                        }
                        if (cells[f][k].value != 'X')
                            cells[f][k].value = '0';
                        if (k == 9) k = 10;
                        if (f == 9) f = 10;
                    }
                }
            }
        }

        return cells;
    }

    public Cell[][] setRouteFalse(Cell[][] cells, int x, Ship ship, int y) { // установка вертикального корабля
        int desks = ship.getDesk();
        for (int i = 0; i < desks; i++) {
            if (x > 6 && y > 6 && desks == 4) { //если корабль выходит за пределы поля
                ship.isShipDelivered = false;
                break;
            }
            if (x > 7 && y > 7 && desks == 3) {
                ship.isShipDelivered = false;
                break;
            }
            if (x > 8 && y > 8 && desks == 2) {
                ship.isShipDelivered = false;
                break;
            }
            if (cells[x][y].value != '*') {
                break;
            }
            for (int h = 0; h < desks; h++) {
                int z = y + h;
                if (z > 9) z = 9;
                if (cells[x][z].value != '*') {
                    ship.isShipDelivered = false;
                    break;
                }
                cells[x][z].value = 'X'; //устанавливаем корабль
            }


            for (int j = 0; j < desks; j++) { //устанавливаем ореол вокруг корабля


                for (int f = x - 1; f <= x + 1; f++) {
                    if (f < 0) f = 0;

                    for (int k = y + j - 1; k <= y + j + 1; k++) {
                        if (k < 0) k = 0;
                        if (k > 9 || f > 9) {
                            if (k > 9) k = 9;
                            if (f > 9) f = 9;
                            if (cells[f][k].value != 'X')
                                cells[f][k].value = '0';
                        }
                        if (cells[f][k].value != 'X')
                            cells[f][k].value = '0';
                        if (k == 9) k = 10;
                        if (f == 9) f = 10;
                    }
                }

            }
        }

        return cells;

    }

    public Cell shootCell(String s) { //получаем координы ячейки, которые ввел игрок
        String subS1 = s.substring(0, 1);
        int x = 0;
        int y;

        switch (subS1) {
            case "А":
                y = 0;
                break;
            case "Б":
                y = 1;
                break;
            case "В":
                y = 2;
                break;
            case "Г":
                y = 3;
                break;
            case "Д":
                y = 4;
                break;
            case "Е":
                y = 5;
                break;
            case "Ж":
                y = 6;
                break;
            case "З":
                y = 7;
                break;
            case "И":
                y = 8;
                break;
            case "К":
                y = 9;
                break;
            default:
                y = 10;
        }

        String subS2 = s.substring(1, 2);
        if (s.length() == 3) subS2 = s.substring(1, 3);
        try {
            x = Integer.parseInt(subS2);
            if (x <= 10) x--;
            else x = 10;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Cell(x, y);
    }
}
