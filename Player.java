package ru.knaur.lesson.geekbrainsjava.java1.seabattle;


public class Player {
    private String name;
    public static int score = 0;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Player() {
    }
