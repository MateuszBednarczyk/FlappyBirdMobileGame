package com.matthew.flappy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import static com.matthew.flappy.WorldConfiguration.bottomObstacleY;
import static com.matthew.flappy.WorldConfiguration.topObstacleY;

public class Obstacle {
    Sprite bodyTexture;
    Vector2 position;
    Player player;
    float clock;

    public Obstacle(Texture obstacleImage, Player player) {
        this.player = player;
        position = new Vector2();
        bodyTexture = new Sprite(obstacleImage);
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
        clock += Gdx.graphics.getDeltaTime();
        int start = 0;
        int end = 1;
        if (clock > 2) {
            int topOrBottomObstacle = MathUtils.random(start, end);
            if (topOrBottomObstacle == 1) {
                bodyTexture.setY(bottomObstacleY);
                bodyTexture.setRotation(0);
            } else {
                bodyTexture.setY(topOrBottomObstacle);
                bodyTexture.setY(180);
            }
            clock -= 2;
        }
    }
}
