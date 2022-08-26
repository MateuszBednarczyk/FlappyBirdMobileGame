package com.matthew.flappy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import static com.matthew.flappy.WorldConfiguration.windowHeight;

public class Obstacle {
    Sprite bodyTexture;
    Vector2 position;
    Player player;
    float clock = 0;

    public Obstacle(Texture obstacleImage, Player player) {
        this.player = player;
        bodyTexture = new Sprite(obstacleImage);
        position = new Vector2();
        bodyTexture.setScale(1);
    }

    public void draw(SpriteBatch batch) {
        update();
        bodyTexture.draw(batch);
    }

    public void update() {
        if (player.isPlayerAlive) {
            spawnObstacle();
        }
    }

    private void spawnObstacle() {
        clock = clock + Gdx.graphics.getDeltaTime();
        int start = 0;
        int end = 10;
        float topOrBottomObstacle = MathUtils.random(start, end);
        System.out.println(topOrBottomObstacle);
        if (clock > 5) {
            if (topOrBottomObstacle % 2 == 0) {
                position.y = 0;
            } else {
                bodyTexture.setRotation(180);
                position.y = windowHeight;
            }
        }
        clock = 0;
    }
}
