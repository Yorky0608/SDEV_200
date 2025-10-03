package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Programming Exercise 14.1: Display Images
 * This program displays four images in a 2x2 grid pane.
 * If images are not found, colorful placeholders are displayed instead.
 */
public class assignment_14_1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane for 2x2 layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create four image views or placeholders
        StackPane image1 = createImageOrPlaceholder("images/image1.jpg", "Image 1", 200, 150, Color.LIGHTBLUE);
        StackPane image2 = createImageOrPlaceholder("images/image2.jpg", "Image 2", 200, 150, Color.LIGHTGREEN);
        StackPane image3 = createImageOrPlaceholder("images/image3.jpg", "Image 3", 200, 150, Color.LIGHTCORAL);
        StackPane image4 = createImageOrPlaceholder("images/image4.jpg", "Image 4", 200, 150, Color.LIGHTYELLOW);

        // Add images to grid pane (2x2 grid)
        gridPane.add(image1, 0, 0); // Top-left
        gridPane.add(image2, 1, 0); // Top-right
        gridPane.add(image3, 0, 1); // Bottom-left
        gridPane.add(image4, 1, 1); // Bottom-right

        // Create scene and stage
        Scene scene = new Scene(gridPane, 480, 380);
        primaryStage.setTitle("Exercise 14.1: Display Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates an ImageView with the specified image path, or a placeholder if image not found
     */
    private StackPane createImageOrPlaceholder(String imagePath, String placeholderText, 
                                             double width, double height, Color placeholderColor) {
        StackPane container = new StackPane();
        
        try {
            // Try to load the image from resources
            Image image = new Image(getClass().getResourceAsStream("/" + imagePath));
            if (!image.isError()) {
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(width);
                imageView.setFitHeight(height);
                imageView.setPreserveRatio(true);
                imageView.setSmooth(true);
                container.getChildren().add(imageView);
                return container;
            }
        } catch (Exception e) {
            // Image not found, will create placeholder below
        }
        
        // Create placeholder if image not found
        Rectangle placeholder = new Rectangle(width, height);
        placeholder.setFill(placeholderColor);
        placeholder.setStroke(Color.DARKGRAY);
        placeholder.setStrokeWidth(2);
        
        Label label = new Label(placeholderText + "\n[Placeholder]");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(Color.DARKBLUE);
        
        container.getChildren().addAll(placeholder, label);
        return container;
    }

    public static void main(String[] args) {
        launch(args);
    }
}