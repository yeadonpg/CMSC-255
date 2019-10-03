package Testing.FinalProject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EndMenu {
    public static boolean DONE = false;
    public static boolean userQuit;
    public static void main() {
        GridPane root = new GridPane();

        // ***********************************************YOUR*CODE*HERE************************************************

        Button btn = new Button("End Menu -> Main Menu");
        Button btnQuit = new Button("End Program");

        btn.setOnAction(e -> sceneDone(false));
        btnQuit.setOnAction(e -> sceneDone(true));

        root.getChildren().add(btn);
        root.getChildren().add(btnQuit);

        // *************************************************************************************************************
        // NOTE: sceneDone() must be called if you want your scene to end properly

        finish(Main.STAGE, root);
    }

    /** You do not need to touch this method **/
    private static void finish(Stage stage, GridPane root) {
        // Creating the scene
        Scene scene = new Scene(root, Main.WIDTH, Main.HEIGHT);
        stage.setScene(scene);
    }

    private static void sceneDone(boolean quitGame) {
        DONE = true;
        // Allowing the scenes to repeat if the user didn't ask to quit
        if (!quitGame) {
            Main.resetScenes();
        } else {
            userQuit = true;
        }
    }
}
