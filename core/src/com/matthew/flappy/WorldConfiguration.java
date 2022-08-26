package com.matthew.flappy;

import com.badlogic.gdx.Gdx;

public class WorldConfiguration {
    //window configuration
    static int windowWidth = Gdx.graphics.getWidth();
    static int windowHeight = Gdx.graphics.getHeight();
    //player configuration
    static float basePlayerX = windowWidth / 2;
    static float basePlayerY = windowHeight / 2;
    //world configuration
    static float gravity = 60;
    //obstacle configuration
    static float topObstacleY = windowHeight;
    static float bottomObstacleY = 0;
}
