package ru.domain.lesson2;

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
        cells = setShips4(cells);
        cells = setShips3(cells);
        cells = setShips2(cells);
        cells = setShips1(cells);
///
        return cells;
    }

    public Cell[][] setShips4(Cell[][] cells) {
        Ship ship = setShip(4);
        int i = 1;
        while (i <= COUNTSHIPS4) {
            cells = setOutside(cells, ship);
            Cell cell = ship.getCell();
            if (cells[cell.getX()][cell.getY()].value == 'X') i++;

        }
        return cells;
    }

    public Cell[][] setShips3(Cell[][] cells) {
        int i = 1;
        while (i <= COUNTSHIPS3) {
            Ship ship = setShip(3);
            cells = setOutside(cells, ship);
            Cell cell = ship.getCell();
            if (cells[cell.getX()][cell.getY()].value == 'X') i++;

        }
        return cells;
    }

    public Cell[][] setShips2(Cell[][] cells) {
        int i = 1;
        while (i <= COUNTSHIPS2) {
            Ship ship = setShip(2);
            cells = setOutside(cells, ship);
            Cell cell = ship.getCell();
            if (cells[cell.getX()][cell.getY()].value == 'X') i++;

        }
        return cells;
    }


    public Cell[][] setShips1(Cell[][] cells) {
        int i = 1;
        while (i <= COUNTSHIPS1) {
            Ship ship = setShip(1);
            cells = setOutside(cells, ship);
            Cell cell = ship.getCell();
            if (cells[cell.getX()][cell.getY()].value == 'X') i++;

        }
        return cells;
    }


    public Ship setShip(int desk) {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        boolean isRoute = random.nextBoolean();
        if (x > 6 && desk == 4) isRoute = false;
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
        Cell cell = ship.getCell();

        boolean isRoute = ship.isRoute();
        int x = cell.getX();
        int y = cell.getY();


        if (isRoute == true) {
            setRouteTrue(cells, x, ship.getDesk(), y);

        } else {
            setRouteFalse(cells, x, ship.getDesk(), y);
        }


        return cells;
    }


    public Cell[][] setRouteTrue(Cell[][] cells, int x, int desks, int y) {
        for (int i = 0; i < desks; i++) {
            if (x > 6 && y > 6 && desks == 4) break;
            if (x > 7 && y > 7 && desks == 3) break;
            if (x > 8 && y > 8 && desks == 2) break;
            if (cells[x][y].value != '*') break;
            for (int h = 0; h < desks; h++) {
                int z = x + h;
                if (z > 9) z = 9;
                if (cells[z][y].value != '*') break;
                cells[z][y].value = 'X';
            }


            for (int j = 0; j < desks; j++) {


                for (int f = x + j - 1; f <= x + j + 1; f++) {
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

    public Cell[][] setRouteFalse(Cell[][] cells, int x, int desks, int y) {
        for (int i = 0; i < desks; i++) {
            if (x > 6 && y > 6 && desks == 4) break;
            if (x > 7 && y > 7 && desks == 3) break;
            if (x > 8 && y > 8 && desks == 2) break;
            if (cells[x][y].value != '*') break;
            for (int h = 0; h < desks; h++) {
                int z = y + h;
                if (z > 9) z = 9;
                if (cells[x][z].value != '*') break;
                cells[x][z].value = 'X';


            }


            for (int j = 0; j < desks; j++) {


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

}



