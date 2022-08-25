package com.matthew.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyCore extends ApplicationAdapter {
    SpriteBatch batch;
    Texture avatarImage;
    Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = createPlayer(new Texture("planeRed1.png"));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        player.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        avatarImage.dispose();
    }

    public Player createPlayer(Texture avatarImage) {
        return new Player(avatarImage);
    }
}
