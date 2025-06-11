package jogo;

import static java.lang.Thread.sleep;

public class MainAudio {
    public static void main(String[] args) throws InterruptedException {
        Audio.playMusic("AudioFiles/dark-exitement.wav");

        sleep(3000);

        Audio.playMusic("AudioFiles/dark-exitement.wav");

        sleep(3000);

        System.out.println("Obrigado");
    }
}

