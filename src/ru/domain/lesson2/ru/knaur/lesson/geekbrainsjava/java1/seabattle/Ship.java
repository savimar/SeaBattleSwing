package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

public class Ship {
    private int desk; //количество палуб
    private Cell leftUp; //левая верхняя точка корабля
    private Cell rightDown; //правая нижняя точка корабля
    private boolean isRoute;// горизонтальное положение корабля = истина
    public boolean isShipDelivered; //корабль есть на поле

    public Ship(int desk, Cell cell, boolean isRoute) {
        this.desk = desk;
        this.leftUp = cell;
        this.isRoute = isRoute;
        if (isRoute) {
            rightDown = new Cell(leftUp.getX() + desk - 1, leftUp.getY());
        } else { //
            rightDown = new Cell(leftUp.getX(), leftUp.getY() + desk - 1);
        }
    }

    public Cell getRightDown() {
        return rightDown;
    }

    public void setRightDown(Cell rightDown) {
        this.rightDown = rightDown;
    }

    public Cell getLeftUp() {
        return leftUp;
    }

    public void setLeftUp(Cell leftUp) {
        this.leftUp = leftUp;
    }

    public boolean isRoute() {
        return isRoute;
    }

    public void setIsRoute(boolean isRoute) {
        this.isRoute = isRoute;
    }

    public int getDesk() {
        return desk;
    }

    public void setDesk(int desk) {
        this.desk = desk;
    }
}

