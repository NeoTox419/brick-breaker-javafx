package com.saikat.brickbreaker;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick {

    public double x, y;
    public double width, height;
    public boolean destroyed = false;

    public Brick(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(GraphicsContext gc) {
        if (destroyed) return;

        gc.setFill(Color.ORANGE);
        gc.fillRect(x, y, width, height);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, width, height);
    }
}
