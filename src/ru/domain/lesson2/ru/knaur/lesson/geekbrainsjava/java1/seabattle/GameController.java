package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

public class GameController {
    public volatile static boolean isShoot = false;
    public enum playerShoot {МИМО, ПОПАЛ, НЕТ_ВЫСТРЕЛА}


//синглетон
  private static GameController instance;

  private GameController(){}

  public static synchronized GameController getInstance(){
    if(instance == null){
      instance = new GameController( );
    }
    return instance;
  }



}

