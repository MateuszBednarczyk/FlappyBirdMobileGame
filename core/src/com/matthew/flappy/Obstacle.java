package com.matthew.flappy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Obstacle {
    Sprite bodyTexture;
    Vector2 position;
    String bottomObstacleSource = "rockGrass.png";
    String topObstacleSource = "rockGrassDown.png";
    Player player;

    public Obstacle(Player player) {
        position = new Vector2();
        this.player = player;
    }

    public void draw(SpriteBatch batch, float deltaTime) {
        spawnObstacle(deltaTime);
    }

    public void update() {
    }

    private void spawnObstacle(float deltaTime) {
        if (deltaTime < 6) {
            position.y = MathUtils.random(0, 1);
            if (position.y == 0) {
                bodyTexture = new Sprite(new Texture(bottomObstacleSource));
            } else {
                bodyTexture = new Sprite(new Texture(topObstacleSource));
            }
            bodyTexture.setScale(1);
            position.x = MathUtils.random(5, 20) + player.getPlayerPosition().x;
        }
    }
}
