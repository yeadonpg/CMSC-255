package Testing.JFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJFX extends Application{
    public static void main(String[] args) {
        // This method is called for all JavaFX Applications
        launch(args);
    }

    // This method is created for every JavaFX Application
    @Override
    public void start(Stage stage) throws Exception {
        // Creating buttons
        Button btn = new Button("Click Me");
        Button exit = new Button("Exit");

        // Assigning the buttons an action with lambda expressions
        btn.setOnAction(e -> System.out.println("Hello World"));
        exit.setOnAction(e -> System.exit(0));

        // Creating a pane for visual objects to exist in
        VBox root = new VBox();
        root.getChildren().add(btn);
        root.getChildren().add(exit);

        // Creating the scene
        int width = 300;
        int height = 300;
        Scene scene = new Scene(root, width, height);

        // Staging the scene and showing
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }
}