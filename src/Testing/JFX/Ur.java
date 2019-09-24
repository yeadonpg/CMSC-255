package Testing.JFX;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ur extends Application {
    private static int WIDTH = 500;
    private static int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    private static Scene createMainMenuScene(Stage stage) {
        final int buttonWidth = 75;
        // Start button; navigates to the game scene
        Button start = new Button("Start");
        start.setMinWidth(buttonWidth);
        start.setOnAction(e -> stage.setScene(createGameScene(stage)));

        // Exit button
        Button exit = new Button("Exit");
        exit.setMinWidth(buttonWidth);
        exit.setOnAction(e -> System.exit(0));

        // Title label
        Label title = new Label("Ur");

        // Subtitle label
        Label subTitle = new Label("Press start to begin");

        // Initializing pane for menu objects to exist in
        GridPane menuRoot = new GridPane();
        menuRoot.setGridLinesVisible(true);
        // Adding menu objects to the pane
        TilePane buttonBox = new TilePane(Orientation.VERTICAL);
        buttonBox.setMinSize(WIDTH, HEIGHT);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(title, subTitle, start, exit);

        menuRoot.add(buttonBox, 0, 1);

        // Returning the completed scene
        return new Scene(menuRoot, WIDTH, HEIGHT);
    }

    private static Scene createGameScene(Stage stage) {
        // Initializing pane for game objects to exist in
        GridPane gameRoot = new GridPane();

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

            }
        });

        // Back button; navigates to the main menu
        Button toMenu = new Button("Back");
        toMenu.setOnAction(e -> stage.setScene(createMainMenuScene(stage)));

        // Adding game objects to the pane
        gameRoot.setGridLinesVisible(true);
        gameRoot.add(toMenu, 0, 0);
        gameRoot.add(testBtn, 1, 0);
        gameRoot.add(canvas, 0, 1, 2, 1);

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
