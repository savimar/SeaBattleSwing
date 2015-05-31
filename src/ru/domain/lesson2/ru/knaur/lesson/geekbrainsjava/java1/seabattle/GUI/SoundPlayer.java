package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle.GUI;


import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundPlayer  {
    public String path;

    public SoundPlayer(String path) {
        this.path = path;
        try {
            AudioPlayer.player.start(new AudioStream(getClass().getResourceAsStream(path)));
        } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
