package project.chess;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ChessBoard extends VBox {
    GridPane gameBoard;
    public ChessBoard() {
        super(10);
        this.getChildren().add(board());

    }
    public GridPane board() {
        gameBoard = new GridPane();
        return gameBoard;
    }
}
