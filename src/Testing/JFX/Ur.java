package Testing.JFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ur extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static Scene getScene(Scene[] sceneHandler, int sceneIndex) {
        return sceneHandler[sceneIndex];
    }

    private static Scene createMainMenuScene(Stage stage, Scene[] sceneHandler, int width, int height) {
        // Creating start button
        Button start = new Button("Start");
        // Start button navigates to the game scene, using the scene handler
        start.setOnAction(e -> stage.setScene(getScene(sceneHandler, 1)));

        // Creating exit button
        Button exit = new Button("Exit");
        exit.setOnAction(e -> System.exit(0));

        // Initializing pane for menu objects to exist in
        VBox menuRoot = new VBox();
        // Adding menu objects to the pane
        menuRoot.getChildren().add(start);
        menuRoot.getChildren().add(exit);

        // Initializing and returning the completed scene
        return new Scene(menuRoot, width, height);
    }

    private static Scene createGameScene(Stage stage, Scene[] sceneHandler, int width, int height) {
        // Creating back button
        Button toMenu = new Button("Back");
        // toMenu button navigates to the mainMenu scene using the scene handler
        toMenu.setOnAction(e -> stage.setScene(getScene(sceneHandler, 0)));

        // Initializing pane for game objects to exist in
        VBox gameRoot = new VBox();
        // Adding game objects to the pane
        gameRoot.getChildren().add(toMenu);

        // Initializing and returning the completed scene
        return new Scene(gameRoot, width, height);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Initializing constants
        final int width = 500;
        final int height = 500;

        // Initializing scene handler
        // The handler allows the user to navigate to separate scenes
        Scene[] sceneHandler = new Scene[2];

        // Initializing scenes
        Scene mainMenu = createMainMenuScene(stage, sceneHandler, width, height);
        Scene game = createGameScene(stage, sceneHandler, width, height);

        // Adding scenes to the scene handler
        sceneHandler[0] = mainMenu;
        sceneHandler[1] = game;

        // Staging the scene and showing
        stage.setTitle("");
        stage.getIcons().add(new Image(Ur.class.getResourceAsStream("UrLogo.png")));
        stage.setScene(mainMenu);
        stage.show();
    }
}
