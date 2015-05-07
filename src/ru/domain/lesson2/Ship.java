package ru.domain.lesson2;


public class Ship {
    private int desk;
    private String type;
    private boolean isInjured;
    private boolean isShooted;
    private Cell cell;
    private boolean isRoute;


    public Ship(int desk, Cell cell, boolean isRoute) {
        this.desk = desk;
        this.cell = cell;
        this.isRoute = isRoute;


    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
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


