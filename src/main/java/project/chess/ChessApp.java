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
        ImageView chessImage = new ImageView("https://www.karacterbox.com/media/catalog/product/cache/9d08971813a040f8f96067a40f75c615/2/9/29eab83d85d79e0d966a6cec840fdc1a_f_6034010_1.jpg");
        chessImage.setFitHeight(300.0);
        chessImage.setPreserveRatio(true);
        Layout.getChildren().addAll(chessImage,chessButton);
        Layout.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(Layout);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Chess");
        primaryStage.show();
    }
    public void chessAction(ActionEvent event) {
    }
}
