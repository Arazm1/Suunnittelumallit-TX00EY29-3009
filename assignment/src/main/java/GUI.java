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

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();

        //Creates grid UI
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(40, 40);
                rect.setStyle("-fx-fill: white; -fx-stroke: black;");
                cells[i][j] = rect;
                root.add(rect, j, i);
            }
        }

        Button btn = new Button("Create Code");

        VBox layout = new VBox(10, root, btn);

        Scene scene = new Scene(layout);

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

                if (data[i][j] == 1) {
                    cells[i][j].setStyle("-fx-fill: black; -fx-stroke: black;");
                } else {
                    cells[i][j].setStyle("-fx-fill: white; -fx-stroke: black;");
                }

                //Cursor highlight
                if (i == grid.getCursorRow() && j == grid.getCursorCol()) {
                    cells[i][j].setStrokeWidth(3);
                } else {
                    cells[i][j].setStrokeWidth(1);
                }
            }
        }
    }
}