package com.matthew.flappy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    Sprite avatar;
    Vector2 position;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();

    public Player(Texture avatarImage) {
        avatar = new Sprite(avatarImage);
        avatar.setScale(1);
        position = new Vector2(screenWidth / 2, screenHeight / 2);
    }

    public void draw(SpriteBatch batch) {
        avatar.setPosition(position.x, position.y);
        avatar.draw(batch);
    }

}
