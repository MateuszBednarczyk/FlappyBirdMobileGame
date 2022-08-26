package com.matthew.flappy;

import static com.matthew.flappy.WorldConfiguration.basePlayerX;
import static com.matthew.flappy.WorldConfiguration.basePlayerY;
import static com.matthew.flappy.WorldConfiguration.gravity;
import static com.matthew.flappy.WorldConfiguration.playerMovementSpeed;
import static com.matthew.flappy.WorldConfiguration.windowHeight;
import static com.matthew.flappy.WorldConfiguration.windowWidth;

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
    private final static float JUMP_TIME = 5;
    boolean isPlayerAlive;
    int killPosition = 0;
    boolean directionLeft;

    public Player(Texture avatarImage, boolean isPlayerAlive) {
        avatar = new Sprite(avatarImage);
        avatar.setScale(1);
        position = new Vector2(basePlayerX, basePlayerY);
        this.isPlayerAlive = isPlayerAlive;
        directionLeft = true;
    }

    public void draw(SpriteBatch batch) {
        update(Gdx.graphics.getDeltaTime());
        avatar.setPosition(position.x, position.y);
        avatar.draw(batch);
    }

    public void update(float deltaTime) {
        if (isPlayerAlive) {
            goAhead();
            jump();
            changeDirection();
            kill();
            setGravity(deltaTime);
        } else {
            revive();
        }
    }

    private void changeDirection() {
        if (position.x == windowWidth) {
            directionLeft = false;
        } else if (position.x == 0) {
            directionLeft = true;
        }
    }

    private void goAhead() {
        if (directionLeft) {
            position.x = position.x + playerMovementSpeed;
        } else {
            position.x = position.x - playerMovementSpeed;
        }
    }

    public void jump() {
        if (Gdx.input.isTouched()) {
            position.y = position.y + 10;
        }
    }

    public void kill() {
        if (position.y <= killPosition) {
            setPlayerAlive(false);
        } else if (position.y >= windowHeight) {
            setPlayerAlive(false);
        } else {
//            System.out.println("ALIVE");
        }
    }

    private void revive() {
        position.x = basePlayerX;
        position.y = basePlayerY;
        setPlayerAlive(true);
    }

    public void setGravity(float deltaTime) {
        position.y -= gravity * deltaTime;
    }

    public void setPlayerAlive(boolean playerAlive) {
        isPlayerAlive = playerAlive;
    }

    public Vector2 getPlayerPosition() {
        return position;
    }
}
