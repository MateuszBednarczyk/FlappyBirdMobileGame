package com.matthew.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyCore extends ApplicationAdapter {
    SpriteBatch batch;
    Texture avatarImage;
    Texture obstacleImage;
    Player player;
    Obstacle obstacle;

    @Override
    public void create() {
        batch = new SpriteBatch();
        avatarImage = new Texture("planeRed1.png");
        obstacleImage = new Texture("rock.png");
        player = createPlayer(avatarImage);
        obstacle = new Obstacle(obstacleImage, player);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        player.draw(batch);
        obstacle.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        obstacleImage.dispose();
        avatarImage.dispose();
    }

    public Player createPlayer(Texture avatarImage) {
        return new Player(avatarImage, true);
    }

}
