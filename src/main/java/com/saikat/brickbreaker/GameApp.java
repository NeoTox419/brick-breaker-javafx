package com.saikat.brickbreaker;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameApp extends Application {

    private Paddle paddle;
    private Ball ball;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private long lastTime = 0L;
    private Brick[] bricks;
    private int score = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Brick Breaker");

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT, A -> moveLeft = true;
                case RIGHT, D -> moveRight = true;
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case LEFT, A -> moveLeft = false;
                case RIGHT, D -> moveRight = false;
            }
        });

        stage.setScene(scene);
        stage.show();

        paddle = new Paddle(WIDTH / 2 - 60, HEIGHT - 40);
        ball = new Ball(WIDTH / 2, HEIGHT / 2);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastTime == 0L) lastTime = now;
                double dt = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                update(dt);
                render(gc);
            }
        };

        int rows = 5;
        int cols = 10;
        double brickWidth = 70;
        double brickHeight = 25;
        double padding = 10;
        // total width of brick grid
        double totalBrickWidth =
                cols * brickWidth + (cols - 1) * padding;

        // center the grid horizontally
        double offsetX = (WIDTH - totalBrickWidth) / 2;
        double offsetY = 50;

        bricks = new Brick[rows * cols];
        int index = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                double x = offsetX + col * (brickWidth + padding);
                double y = offsetY + row * (brickHeight + padding);
                bricks[index++] = new Brick(x, y, brickWidth, brickHeight);
            }
        }

        timer.start();
    }

    private void update(double dt) {
        paddle.update(dt, moveLeft, moveRight);

        ball.update(dt);
        ball.bounceFromPaddle(paddle);

        for (Brick brick : bricks) {
            if (ball.bounceFromBrick(brick)) {
                score += 10;
                break; // only hit one brick per frame
            }
        }
        if (ball.isOutOfBounds()) {
            ball.reset(
                    paddle.x + paddle.width / 2,
                    paddle.y - 10
            );
        }
    }

    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        for (Brick brick : bricks) {
            brick.render(gc);
        }
        paddle.render(gc);
        ball.render(gc);
        gc.fillText("Score: " + score, 20, 20);
    }

}
