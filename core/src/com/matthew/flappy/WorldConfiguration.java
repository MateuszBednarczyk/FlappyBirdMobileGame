package com.matthew.flappy;

import com.badlogic.gdx.Gdx;

public class WorldConfiguration {
    //window configuration
    static int windowWidth = Gdx.graphics.getWidth();
    static int windowHeight = Gdx.graphics.getHeight();
    //player configuration
    static float basePlayerX = windowWidth / 2;
    static float basePlayerY = windowHeight / 2;
    static int playerMovementSpeed = 10;
    //world configuration
    static float gravity = 120;
    //obstacle configuration
    static float topObstacleY = 0;
    static float bottomObstacleY = windowHeight;
}
