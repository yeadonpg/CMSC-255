package Testing.JFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ur extends Application {
    private static int WIDTH = 500;
    private static int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    private static Scene createMainMenuScene(Stage stage) {
        // Start button; navigates to the game scene
        Button start = new Button("Start");
        start.setOnAction(e -> stage.setScene(createGameScene(stage)));

        // Exit button
        Button exit = new Button("Exit");
        exit.setOnAction(e -> System.exit(0));

        // Initializing pane for menu objects to exist in
        VBox menuRoot = new VBox();
        // Adding menu objects to the pane
        menuRoot.getChildren().add(start);
        menuRoot.getChildren().add(exit);

        // Returning the completed scene
        return new Scene(menuRoot, WIDTH, HEIGHT);
    }

    private static Scene createGameScene(Stage stage) {
        // Initializing canvas and graphics context
        final int canvasWidth = 150;
        final int canvasHeight = 150;
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Test button; draws an oval on the canvas
        Button testBtn = new Button("Test");
        testBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gc.setFill(Color.WHITE);
                gc.fillRect(0, 0, canvasWidth, canvasHeight);
                gc.setStroke(Color.BLACK);
                gc.strokeOval(20, 20, canvasWidth - 40, canvasHeight - 40);
            }
        });

        // Back button; navigates to the main menu
        Button toMenu = new Button("Back");
        toMenu.setOnAction(e -> stage.setScene(createMainMenuScene(stage)));

        // Initializing pane for game objects to exist in
        VBox gameRoot = new VBox();
        // Adding game objects to the pane
        gameRoot.getChildren().add(toMenu);
        gameRoot.getChildren().add(testBtn);
        gameRoot.getChildren().add(canvas);

        // Initializing and returning the completed scene
        return new Scene(gameRoot, WIDTH, HEIGHT);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Staging the scene and showing the stage
        stage.setTitle("");
        stage.getIcons().add(new Image(Ur.class.getResourceAsStream("UrLogo.png")));
        stage.setScene(createMainMenuScene(stage));
        stage.show();
    }
}
