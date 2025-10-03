package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Assignment 16.17: Use ScrollBar and Slider
 * This program uses four horizontal sliders to select colors for text.
 * The sliders control Red, Green, Blue, and Opacity (Alpha) values.
 */
public class assignment_16_17 extends Application {
    
    private Text sampleText;
    private Slider redSlider, greenSlider, blueSlider, opacitySlider;
    private Label redLabel, greenLabel, blueLabel, opacityLabel;
    
    @Override
    public void start(Stage primaryStage) {
        // Create the sample text that will change color
        sampleText = new Text("Sample Text - Color Changes with Sliders");
        sampleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        // Create sliders for RGBA values
        redSlider = createSlider(0, 255, 255); // Red: 0-255, default 255 (full red)
        greenSlider = createSlider(0, 255, 0);   // Green: 0-255, default 0
        blueSlider = createSlider(0, 255, 0);    // Blue: 0-255, default 0
        opacitySlider = createSlider(0, 100, 100); // Opacity: 0-100%, default 100%
        
        // Create labels to show current values
        redLabel = new Label("Red: 255");
        greenLabel = new Label("Green: 0");
        blueLabel = new Label("Blue: 0");
        opacityLabel = new Label("Opacity: 100%");
        
        // Set initial color
        updateTextColor();
        
        // Add event listeners to sliders
        redSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            redLabel.setText("Red: " + newVal.intValue());
            updateTextColor();
        });
        
        greenSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            greenLabel.setText("Green: " + newVal.intValue());
            updateTextColor();
        });
        
        blueSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            blueLabel.setText("Blue: " + newVal.intValue());
            updateTextColor();
        });
        
        opacitySlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            opacityLabel.setText("Opacity: " + newVal.intValue() + "%");
            updateTextColor();
        });
        
        // Create layout
        GridPane controlPanel = new GridPane();
        controlPanel.setHgap(10);
        controlPanel.setVgap(10);
        controlPanel.setPadding(new Insets(20));
        controlPanel.setAlignment(Pos.CENTER);
        
        // Add labels and sliders to grid
        controlPanel.add(new Label("Red:"), 0, 0);
        controlPanel.add(redSlider, 1, 0);
        controlPanel.add(redLabel, 2, 0);
        
        controlPanel.add(new Label("Green:"), 0, 1);
        controlPanel.add(greenSlider, 1, 1);
        controlPanel.add(greenLabel, 2, 1);
        
        controlPanel.add(new Label("Blue:"), 0, 2);
        controlPanel.add(blueSlider, 1, 2);
        controlPanel.add(blueLabel, 2, 2);
        
        controlPanel.add(new Label("Opacity:"), 0, 3);
        controlPanel.add(opacitySlider, 1, 3);
        controlPanel.add(opacityLabel, 2, 3);
        
        // Main layout
        VBox root = new VBox(30);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(sampleText, controlPanel);
        
        // Add instructions
        Label instructions = new Label("Use the sliders below to change the text color:");
        instructions.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        root.getChildren().add(0, instructions);
        
        // Create scene and stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Assignment 16.17: Use ScrollBar and Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Creates a slider with specified min, max, and initial values
     */
    private Slider createSlider(double min, double max, double initialValue) {
        Slider slider = new Slider(min, max, initialValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit((max - min) / 4);
        slider.setMinorTickCount(3);
        slider.setPrefWidth(200);
        return slider;
    }
    
    /**
     *  Updates the text color based on current slider values
     */
    private void updateTextColor() {
        double red = redSlider.getValue() / 255.0;     // Convert to 0-1 range
        double green = greenSlider.getValue() / 255.0; // Convert to 0-1 range
        double blue = blueSlider.getValue() / 255.0;   // Convert to 0-1 range
        double opacity = opacitySlider.getValue() / 100.0; // Convert to 0-1 range
        
        Color color = new Color(red, green, blue, opacity);
        sampleText.setFill(color);
        
        // Add stroke for better visibility when opacity is low or color is light
        if (opacity < 0.5 || (red > 0.8 && green > 0.8 && blue > 0.8)) {
            sampleText.setStroke(Color.BLACK);
            sampleText.setStrokeWidth(0.5);
        } else {
            sampleText.setStroke(null);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

