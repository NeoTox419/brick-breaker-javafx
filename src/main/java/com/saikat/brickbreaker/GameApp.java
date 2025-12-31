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

        timer.start();
    }

    private void update(double dt) {
        paddle.update(dt, moveLeft, moveRight);

        ball.update(dt);
        ball.bounceFromPaddle(paddle);

        if (ball.isOutOfBounds()) {
            ball.reset(WIDTH / 2, HEIGHT / 2);
        }
    }

    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        paddle.render(gc);
        ball.render(gc);
        gc.fillText("Brick Breaker", 20, 20);
    }

}
