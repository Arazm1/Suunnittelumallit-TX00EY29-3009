import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {

    private PixelGrid grid = new PixelGrid();
    private Rectangle[][] cells = new Rectangle[8][8];

    private static final String BG_COLOR     = "#0d0d0d";
    private static final String GRID_COLOR   = "#1a3a1a";
    private static final String PIXEL_ON     = "#39ff14";
    private static final String PIXEL_OFF    = "#0d1a0d";
    private static final String CURSOR_COLOR = "#ffdd00";


    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();

        //Creates grid UI
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(40, 40);
                //rect.setStyle("-fx-fill: white; -fx-stroke: black;");
                rect.setStyle(
                    "-fx-fill: " + PIXEL_OFF + "; " +
                    "-fx-stroke: " + GRID_COLOR + ";"
                );
                cells[i][j] = rect;
                root.add(rect, j, i);
            }
        }

        Button btn = new Button("Create Code");
        btn.setStyle(
            "-fx-background-color: #39ff14; " +
            "-fx-text-fill: #0d0d0d; " +
            "-fx-font-weight: bold;"
        );

        VBox layout = new VBox(10, root, btn);

        Scene scene = new Scene(layout);
        layout.setStyle("-fx-background-color: " + BG_COLOR + ";");

        setupControls(scene, btn);

        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
        scene.getRoot().requestFocus();
        drawGrid(); //initial render
    }



    private void setupControls(Scene scene, Button btn) {

        scene.setOnKeyPressed(e -> {
            Command command = null;

            switch (e.getCode()) {
                case UP:
                    command = new MoveCursorUpCommand(grid);
                    break;
                case DOWN:
                    command = new MoveCursorDownCommand(grid);
                    break;
                case LEFT:
                    command = new MoveCursorLeftCommand(grid);
                    break;
                case RIGHT:
                    command = new MoveCursorRightCommand(grid);
                    break;
                case SPACE:
                    command = new TogglePixelCommand(grid);
                    break;
            }

            if (command != null) {
                command.execute();
                drawGrid(); //refresh UI
            }
        });

        btn.setOnAction(e -> {
            Command cmd = new GenerateCodeCommand(grid);
            cmd.execute();
        });
    }



    private void drawGrid() {
        int[][] data = grid.getGrid();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if(data[i][j] == 1){
                    cells[i][j].setStyle(
                        "-fx-fill: " + PIXEL_ON + "; " +
                        "-fx-stroke: " + GRID_COLOR + ";"
                    );
                }
                else{
                    cells[i][j].setStyle(
                        "-fx-fill: " + PIXEL_OFF + "; " +
                        "-fx-stroke: " + GRID_COLOR + ";"
                    );
                }

                //Cursor highlight
                if(i == grid.getCursorRow() && j == grid.getCursorCol()){
                    cells[i][j].setStyle(
                        cells[i][j].getStyle() + 
                        "-fx-stroke: " + CURSOR_COLOR + "; " +
                        "-fx-stroke-width: 3;"
                    );
                }
                else{
                    cells[i][j].setStrokeWidth(1);
                }
            }
        }
    }
}