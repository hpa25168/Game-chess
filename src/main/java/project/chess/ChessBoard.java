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
                if (alternator(i, j)) {
                    s.setFill(Paint.valueOf("White"));
                } else {
                    s.setFill(Paint.valueOf("Grey"));
                }
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
                gameBoard.add(s, j, i);
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
        String pawn = "https://toppng.com/uploads/preview/awn-chess-piece-pawn-chess-piece-transparent-11563391176oxnhiiocwr.png";
        String rook = "https://p7.hiclipart.com/preview/541/207/793/chess-piece-queen-pawn-checkmate-chess.jpg";
        String knight = "https://cdn.imgbin.com/8/17/8/imgbin-chess-piece-knight-bishop-rook-international-chess-kAZh637cjfjimB17UwwEbLrNj.jpg";
        String bishop = "https://www.clipartmax.com/png/middle/242-2426241_free-png-bishop-black-chess-piece-png-images-transparent-chess.png";
        String queen = "https://www.clipartmax.com/png/middle/242-2426241_free-png-bishop-black-chess-piece-png-images-transparent-chess.png";
        String king = "https://toppng.com/uploads/preview/king-black-chess-piece-115328561199vb1bvbiin.png";
        BlackchessObjects = new ImageView[][] {
                    {
                            new ImageView(rook),new ImageView(knight),new ImageView(bishop),new ImageView(queen),new ImageView(king),new ImageView(bishop),new ImageView(knight),new ImageView(rook)
                    },
                    {
                            new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn), new ImageView(pawn)
                    }

        };
        Image wPawn = new Image("file:///C:/Users/Het20/Game-chess/pawn.png");
        String wRook = "https://static.thenounproject.com/png/3435242-200.png";
        String wKnight = "https://www.clipartmax.com/png/middle/257-2577557_horse-chess-piece-knight-comments-knight.png";
        String wBishop = "https://e7.pngegg.com/pngimages/113/13/png-clipart-chess-piece-pawn-bishop-chess-white-hand.png";
        String wQueen = "https://cdn.shopify.com/s/files/1/2209/1363/products/MF48QW_large.png?v=1535651144";
        String wKing = "https://cdn.shopify.com/s/files/1/2209/1363/products/additional_megachess-44_33afb3f4-7bfe-4438-a46a-46b5d1b35078_1200x1200.png?v=1535649501";
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
