package com.saikat.brickbreaker;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle {
    public double x;
    public double y;
    public double width = 120;
    public double height = 20;
    public double speed = 400; // pixels per second

    public Paddle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(double dt, boolean moveLeft, boolean moveRight) {

        if (moveLeft) {
            x -= speed * dt;
        }
        if (moveRight) {
            x += speed * dt;
        }

        // clamp inside screen
        if (x < 0) x = 0;
        if (x + width > GameApp.WIDTH) x = GameApp.WIDTH - width;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillRect(x, y, width, height);
    }
}
