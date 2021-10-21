package project.chess;

import java.io.File;

import javax.imageio.ImageIO;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends VBox {
    GridPane gameBoard;
    TilePane[][] tiles;
    ImageView[][] BlackchessObjects;
    ImageView[][] whitechessObjects;
    public ChessBoard() {
        super(10);
        this.getChildren().add(board());
    }
    public GridPane board() {
        gameBoard = new GridPane();
        tiles = new TilePane[8][8];
        chessImages();
        for (int i = 0; i < tiles.length; i++) {

            for (int j = 0; j < tiles[i].length; j++) {
                Rectangle s = new Rectangle(75, 75);
                tiles[i][j] = new TilePane();
                // if (alternator(i, j)) {
                //     s.setFill(Paint.valueOf("White"));
                // } else {
                //     s.setFill(Paint.valueOf("Grey"));
                // }
                if (i == 0 || i == 1) {
                    imageSizeChange(i,j);
                    tiles[i][j].getChildren().add(BlackchessObjects[i][j]);
                    tiles[i][j].setAlignment(Pos.CENTER);
                } else if (i == 6 || i == 7) {
                   imageSizeChange(i,j);
                    int index = 0;
                    if (i == 7) {
                        index = 1;
                    }
                    tiles[i][j].getChildren().add(whitechessObjects[index][j]);
                    tiles[i][j].setAlignment(Pos.CENTER);
                }
                gameBoard.add(tiles[i][j], j, i);
               // gameBoard.add(s, j, i);
            }

        }
        gameBoard.setGridLinesVisible(true);
        gameBoard.setVgap(10.0);
        gameBoard.setHgap(10.0);
        return gameBoard;
    }
    public boolean alternator(int row, int col) {
        if (row % 2 == 0 && col % 2 == 0) {
            return true;
        } else if (row % 2 != 0 && col % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
    public void chessObjects() {
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].getChildren().addAll();
            }
        }
    }
    public void chessImages() {
        String pawn = "https://github.com/hpa25168/Game-chess/blob/work_Board/bPawn.png?raw=true";
        String rook = "https://github.com/hpa25168/Game-chess/blob/work_Board/BRook.png?raw=true";
        String knight = "https://github.com/hpa25168/Game-chess/blob/work_Board/bKnigth.png?raw=true";
        String bishop = "https://github.com/hpa25168/Game-chess/blob/work_Board/Bbishop.png?raw=true";
        String queen = "https://github.com/hpa25168/Game-chess/blob/work_Board/BQueen.png?raw=true";
        String king = "https://github.com/hpa25168/Game-chess/blob/work_Board/BKing.png?raw=true";
        BlackchessObjects = new ImageView[][] {
                    {
                            new ImageView(rook),new ImageView(knight),new ImageView(bishop),new ImageView(queen),new ImageView(king),new ImageView(bishop),new ImageView(knight),new ImageView(rook)
                    },
                    {
                            new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn)
                    }

        };
        String wRook = "https://github.com/hpa25168/Game-chess/blob/work_Board/rook.png?raw=true?raw=true";
        Image wPawn = new Image("https://github.com/hpa25168/Game-chess/blob/work_Board/pawn.png?raw=true");
        String wKnight = "https://github.com/hpa25168/Game-chess/blob/work_Board/knight.png?raw=true";
        String wBishop = "https://github.com/hpa25168/Game-chess/blob/work_Board/rook.png?raw=true";
        String wQueen = "https://github.com/hpa25168/Game-chess/blob/work_Board/GQueen.png?raw=true";
        String wKing = "https://github.com/hpa25168/Game-chess/blob/work_Board/GKing.png?raw=true";
        whitechessObjects = new ImageView[][] {
                {
                        new ImageView(wPawn),new ImageView(wPawn), new ImageView(wPawn),new ImageView(wPawn),new ImageView(wPawn),new ImageView(wPawn),new ImageView(wPawn),new ImageView(wPawn)
                },
                {
                    new ImageView(wRook),new ImageView(wKnight),new ImageView(wBishop),new ImageView(wQueen),new ImageView(wKing),new ImageView(wBishop),new ImageView(wKnight),new ImageView(wRook)
                }

        };

    }
    public void imageSizeChange(int row , int col) {
        if (row == 0 || row == 1) {
            BlackchessObjects[row][col].setFitHeight(50);
            BlackchessObjects[row][col].setPreserveRatio(true);

        } else if (row == 6 || row == 7 ) {
            int index = 0;
            if (row == 7) {
                index = 1;
            }
            whitechessObjects[index][col].setFitHeight(50);
            whitechessObjects[index][col].setPreserveRatio(true);

        }
    }
}
