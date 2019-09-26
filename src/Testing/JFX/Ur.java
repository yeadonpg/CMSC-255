package Testing.JFX;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Ur extends Application {
    // Window width and height
    private static int WIDTH = 800;
    private static int HEIGHT = 600;
    private static int BOARD_WIDTH = 8;
    private static int BOARD_HEIGHT = 3;

    // Getting images
    private static Image ROSETTE = new Image(Ur.class.getResourceAsStream("rosette_space.png"));
    private static Image EMPTY = new Image(Ur.class.getResourceAsStream("empty_space.png"));
    private static Image WHITE = new Image(Ur.class.getResourceAsStream("white_piece.png"));
    private static Image BLACK = new Image(Ur.class.getResourceAsStream("black_piece.png"));

    // Declaring the game board
    private static char[][] board = {
            /*
            'r' = Rosette Space
            'e' = Empty (Plain) Space
            'n' = Not part of the board
             */
            {'r', 'e', 'r'},
            {'e', 'e', 'e'},
            {'e', 'e', 'e'},
            {'e', 'r', 'e'},
            {'n', 'e', 'n'},
            {'n', 'e', 'n'},
            {'r', 'e', 'r'},
            {'e', 'e', 'e'}
    };

    // Declaring game piece paths
    private static int[][] blackPath = {
            // Path that black pieces follow
            {3, 0}, {2, 0}, {1, 0}, {0, 0},
            {0, 1}, {1, 1}, {2, 1}, {3, 1},
            {4, 1}, {5, 1}, {6, 1}, {7, 1},
            {7, 0}, {6, 0}
    };
    private static int[][] whitePath = {
            // Path that white pieces follow
            {3, 2}, {2, 2}, {1, 2}, {0, 2},
            {0, 1}, {1, 1}, {2, 1}, {3, 1},
            {4, 1}, {5, 1}, {6, 1}, {7, 1},
            {7, 2}, {6, 2}
    };

    // Initializing class-wide variables
    private static boolean[][] blackOnBoard = new boolean[8][3]; // Coordinates of each white piece on the board
    private static boolean[][] whiteOnBoard = new boolean[8][3]; // Coordinates of each black piece on the board

    public static void main(String[] args) {
        launch(args);
    }

    private static int findPositionInPath(int[][] path, int[] positionToFind) {
        for (int i = 0; i < path.length; i++) {
            if (path[i][0] == positionToFind[0] && path[i][1] == positionToFind[1]) {
                System.out.println("[UR] Found starting position: " + path[i][0] + ", " + path[i][1]);
                return i;
            }
        }
        System.out.println("[UR] Board position " + positionToFind[0] + ", " + positionToFind[1] + " not found");
        return -1;
    }

    private static void movePiece(int[] currentSpace, int numSpaces) {
        int[] nextSpace;
        int nextSpaceIndex;
        if (whiteOnBoard[currentSpace[0]][currentSpace[1]]) { // Moving white piece
            System.out.println("[UR] Attempting to move WHITE piece by " + numSpaces);
            // Declaring the desired space to move to
            nextSpaceIndex = findPositionInPath(whitePath, currentSpace);
            if (nextSpaceIndex == -1) {
                System.out.println("-----------------------------------");
                return;
            }
            nextSpaceIndex += numSpaces;
            nextSpace = whitePath[nextSpaceIndex];
            System.out.println("[UR] Found landing position: " + nextSpace[0] + ", " + nextSpace[1]);
            System.out.println("[WHITE] Attempting to move...");
            if (blackOnBoard[nextSpace[0]][nextSpace[1]]) {
                if (board[nextSpace[0]][nextSpace[1]] == 'r') {
                    System.out.println("[WHITE] Cannot land on occupied rosette");
                    System.out.println("-----------------------------------");
                    return;
                }
                System.out.println("[WHITE] Landing on BLACK");

                // Kicking the piece off the board
                blackOnBoard[nextSpace[0]][nextSpace[1]] = false;
                System.out.println("[WHITE] Kicking BLACK off the board!");

            } else if (whiteOnBoard[nextSpace[0]][nextSpace[1]]) {
                System.out.println("[WHITE] Cannot land on same team");
                System.out.println("-----------------------------------");
                return;
            }

            // Performing the action of moving the piece
            whiteOnBoard[currentSpace[0]][currentSpace[1]] = false;
            whiteOnBoard[nextSpace[0]][nextSpace[1]] = true;
            System.out.println("[WHITE] Completed jump successfully");

        } else if (blackOnBoard[currentSpace[0]][currentSpace[1]]) { // Moving black piece
            System.out.println("[UR] Attempting to move BLACK piece by " + numSpaces);
            // Declaring the desired space to move to
            nextSpaceIndex = findPositionInPath(blackPath, currentSpace);
            if (nextSpaceIndex == -1) {
                System.out.println("-----------------------------------");
                return;
            }
            nextSpaceIndex += numSpaces;
            nextSpace = blackPath[nextSpaceIndex];
            System.out.println("[UR] Found landing position: " + nextSpace[0] + ", " + nextSpace[1]);
            System.out.println("[BLACK] Attempting to move...");
            if (whiteOnBoard[nextSpace[0]][nextSpace[1]]) {
                if (board[nextSpace[0]][nextSpace[1]] == 'r') {
                    System.out.println("[BLACK] Cannot land on occupied rosette");
                    System.out.println("-----------------------------------");
                    return;
                }
                System.out.println("[BLACK] Landing on WHITE");

                // Kicking the piece off the board
                whiteOnBoard[nextSpace[0]][nextSpace[1]] = false;
                System.out.println("[BLACK] Kicking WHITE off the board!");

            } else if (blackOnBoard[nextSpace[0]][nextSpace[1]]) {
                System.out.println("[BLACK] Cannot land on same team");
                System.out.println("-----------------------------------");
                return;
            }

            // Performing the action of moving the piece
            blackOnBoard[currentSpace[0]][currentSpace[1]] = false;
            blackOnBoard[nextSpace[0]][nextSpace[1]] = true;
            System.out.println("[BLACK] Completed jump successfully");
        }
        System.out.println("-----------------------------------");
    }

    private static void drawBoard(GraphicsContext gc, double[] boardPos, double boardScale, char[][] board, boolean[][] whiteOnBoard, boolean[][] blackOnBoard) {
        for (int j = 0; j < BOARD_HEIGHT; j++) {
            for (int i = 0; i < BOARD_WIDTH; i++) {
                switch (board[i][j]) {
                    case 'e':
                        gc.drawImage(EMPTY, boardPos[0] + (i * boardScale), boardPos[1] + (j * boardScale), boardScale, boardScale);
                        break;
                    case 'r':
                        gc.drawImage(ROSETTE, boardPos[0] + (i * boardScale), boardPos[1] + (j * boardScale), boardScale, boardScale);
                        break;
                }
                if (whiteOnBoard[i][j]) {
                    gc.drawImage(WHITE, boardPos[0] + (i * boardScale), boardPos[1] + (j * boardScale), boardScale, boardScale);
                } else if (blackOnBoard[i][j]) {
                    gc.drawImage(BLACK, boardPos[0] + (i * boardScale), boardPos[1] + (j * boardScale), boardScale, boardScale);
                }
            }
        }
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

        // Offset of the canvas in the scene
        final double[] offset = {0, -25}; // x, y

        // Setting up a method to record the mouse position
        final double[] mousePos = {0, 0}; // x, y
        // Configuring mouse position events
        gameRoot.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Adding offsets to fit game canvas
                mousePos[0] = mouseEvent.getSceneX() + offset[0];
                mousePos[1] = mouseEvent.getSceneY() + offset[1];
            }
        });
        gameRoot.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Adding offsets to fit game canvas
                mousePos[0] = mouseEvent.getSceneX() + offset[0];
                mousePos[1] = mouseEvent.getSceneY() + offset[1];
            }
        });

        // Setting up a method to record mouse clicks
        final boolean[] mouseButtons = {false, false, false}; // Primary, Middle, Secondary
        // Configuring mouse button events
        gameRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseButtons[0] = mouseEvent.isPrimaryButtonDown();
                mouseButtons[1] = mouseEvent.isMiddleButtonDown();
                mouseButtons[2] = mouseEvent.isSecondaryButtonDown();
            }
        });
        gameRoot.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseButtons[0] = mouseEvent.isPrimaryButtonDown();
                mouseButtons[1] = mouseEvent.isMiddleButtonDown();
                mouseButtons[2] = mouseEvent.isSecondaryButtonDown();
            }
        });

        // Initializing canvas and graphics context
        final int canvasWidth = WIDTH + (int) offset[0];
        final int canvasHeight = HEIGHT + (int) offset[1];
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Resetting board pieces
        blackOnBoard = new boolean[8][3];
        whiteOnBoard = new boolean[8][3];


        // BEGIN-GAME-LOOP----------------------------------------------------------------------------------------------

        /*
         MOVING PIECES:

         To simply place a piece on the board, use the following:
         whiteOnBoard[x][y] = true;

         To move a piece along its path by a specific number of spaces, use the following:
         int[] start = new int[] {startX, startY}
         movePiece(start, numSpaces);

         Note to Developer:
         - You cannot move a piece if it is outside its path
         - Because of this, you shouldn't place a piece outside its path to begin with
         */

        // Initializing and starting the game loop
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            // GAME LOOP
            public void handle(long currentNanoTime) {
                // Getting time in seconds; useful for animations
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                // Resetting the canvas before drawing
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, canvasWidth, canvasHeight);

                // Drawing the board & pieces
                drawBoard(gc, new double[] {50, 50}, 87.5, board, whiteOnBoard, blackOnBoard);
            }
        }.start();

        // END-GAME-LOOP------------------------------------------------------------------------------------------------


        // Back button; navigates to the main menu
        Button toMenu = new Button("Back");
        toMenu.setOnAction(e -> stage.setScene(createMainMenuScene(stage)));

        // Adding game objects to the pane
        gameRoot.setGridLinesVisible(true);
        gameRoot.add(toMenu, 0, 0);
        gameRoot.add(canvas, 0, 1, 1, 1);

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
