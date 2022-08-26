package com.matthew.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyCore extends ApplicationAdapter {
    SpriteBatch batch;
    Texture avatarImage;
    Texture obstacleImage;
    Player player;
    Obstacle obstacle;
    OrthographicCamera orthographicCamera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        avatarImage = new Texture("planeRed1.png");
        obstacleImage = new Texture("rock.png");
        player = createPlayer(avatarImage);
        obstacle = new Obstacle(obstacleImage, player);
        orthographicCamera = new OrthographicCamera(player.screenWidth, player.screenHeight);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        orthographicCamera.position.x = player.position.x;
        orthographicCamera.position.y = player.position.y;
        orthographicCamera.update();
        batch.begin();
        player.draw(batch);
        obstacle.draw(batch);
        if (Gdx.input.isTouched()) {
            System.out.println("x " + Gdx.input.getX());
            System.out.println("y " + Gdx.input.getY());
        }
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
