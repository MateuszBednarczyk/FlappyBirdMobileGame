package com.matthew.flappy;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowedMode(1200, 600);
        config.setWindowSizeLimits(1200, 800, 1200, 800);
        config.setTitle("Flappy");
        new Lwjgl3Application(new FlappyCore(), config);
    }
}
