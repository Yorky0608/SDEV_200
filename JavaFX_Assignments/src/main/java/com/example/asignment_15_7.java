package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *  Assignment 15.7: Change Color Using a Mouse
 * This program displays a circle that changes color when the mouse is pressed/released.
 * - Black when mouse button is pressed
 * - White when mouse button is released
 */
public class asignment_15_7 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the circle
        Pane pane = new Pane();
        
        // Create a circle at the center of the pane
        Circle circle = new Circle(200, 150, 50); // x=200, y=150, radius=50
        circle.setFill(Color.WHITE); // Initial color is white
        circle.setStroke(Color.BLACK); // Black border for visibility
        circle.setStrokeWidth(2);
        
        // Add mouse event handlers to the circle
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK); // Change to black when pressed
        });
        
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE); // Change to white when released
        });
        
        // Add the circle to the pane
        pane.getChildren().add(circle);
        
        // Create scene and stage
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Assignment 15.5: Change Color Using Mouse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

