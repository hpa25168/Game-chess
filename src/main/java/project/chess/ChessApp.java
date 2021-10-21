package project.chess;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChessApp extends Application {
    VBox Layout; //for Game Switcher
    @Override
    public void start(Stage primaryStage) {
        Layout = new VBox();
        Button chessButton = new Button("Chess");
        chessButton.setMaxHeight(100);

        ImageView chessImage = new ImageView("https://images.chesscomfiles.com/uploads/v1/article/27319.746c2259.668x375o.c6cf8543e2d5@2x.png");
        chessImage.setFitHeight(300.0);
        chessImage.setPreserveRatio(true);
        chessButton.setOnAction((e) -> chessAction(e,primaryStage));
        Layout.getChildren().addAll(chessImage,chessButton);
        Layout.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(Layout);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Chess");
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    public void chessAction(ActionEvent event,Stage stage) {
        ChessBoard chessGame = new ChessBoard();
        Scene chessScene = new Scene(chessGame);
        stage.setScene(chessScene);
        stage.sizeToScene();
        stage.show();
    }
}
