package Testing.FinalProject;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

public class Main extends Application{
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static Stage STAGE;

    public static int userDifficulty;
    public static String userName;
    public static double userScore;
    public static boolean userQuit;

    public static boolean[] firstTimeScene = {true, true, true};

    /** Launches the Main Loop **/
    public static void main(String[] args) {
        launch(args);
    }

    /** Main loop **/
    @Override
    public void start(Stage stage) throws Exception {
        STAGE = stage;

        new AnimationTimer () {
            @Override
            public void handle(long cNT) {
                // Handling scenes in a manner that allows them to complete chronologically
                userQuit = false;
                if (firstTimeScene[0]) {
                    System.out.println("[DEBUG] Starting Main Menu");
                    MainMenu.main();
                    firstTimeScene[0] = false;
                }
                if (MainMenu.DONE) {
                    userDifficulty = MainMenu.userDifficulty;
                    userName = MainMenu.userName;
                    if (firstTimeScene[1]) {
                        System.out.println("[DEBUG] Starting Run Game");
                        RunGame.main();
                        firstTimeScene[1] = false;
                    }
                    if (RunGame.DONE) {
                        userScore = RunGame.userScore;
                        if (firstTimeScene[2]) {
                            System.out.println("[DEBUG] Starting End Menu");
                            storeToFile(userName, userScore);
                            EndMenu.main();
                            firstTimeScene[2] = false;
                        }
                        if (EndMenu.DONE) {
                            userQuit = EndMenu.userQuit;
                        }
                    }
                }
                if (userQuit) {
                    stage.close();
                }
            }
        }.start();
        stage.show();
    }

    public static void resetScenes() {
        firstTimeScene = new boolean[] {true, true, true};
        MainMenu.DONE = false;
        RunGame.DONE = false;
        EndMenu.DONE = false;
    }

    /** Stores usernames and scores in a file that can be read from later **/
    private static void storeToFile(String userName, double userScore) {

    }
}
