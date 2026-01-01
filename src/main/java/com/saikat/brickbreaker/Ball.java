package com.saikat.brickbreaker;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

    public double x;
    public double y;
    public double radius = 8;

    public double vx = 250; // velocity x (px/sec)
    public double vy = -250; // velocity y (px/sec)

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(double dt) {
        x += vx * dt;
        y += vy * dt;

        // Left & right walls
        if (x - radius <= 0 || x + radius >= GameApp.WIDTH) {
            vx *= -1;
        }

        // Top wall
        if (y - radius <= 0) {
            vy *= -1;
        }
    }

    public void bounceFromPaddle(Paddle paddle) {
        // Simple AABB collision
        if (x + radius > paddle.x &&
                x - radius < paddle.x + paddle.width &&
                y + radius > paddle.y &&
                y - radius < paddle.y + paddle.height) {

            vy *= -1;
            y = paddle.y - radius; // prevent sticking
        }
    }

    public boolean isOutOfBounds() {
        return y - radius > GameApp.HEIGHT;
    }

    public boolean bounceFromBrick(Brick brick) {
        if (brick.destroyed) return false;

        if (x + radius > brick.x &&
                x - radius < brick.x + brick.width &&
                y + radius > brick.y &&
                y - radius < brick.y + brick.height) {

            vy *= -1;
            brick.destroyed = true;
            return true;
        }
        return false;
    }

    public void reset(double x, double y) {
        this.x = x;
        this.y = y;
        this.vx = 250;
        this.vy = -250;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
