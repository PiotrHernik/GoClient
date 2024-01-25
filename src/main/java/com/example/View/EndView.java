package com.example.View;

import com.example.controllers.EndGameController;
import com.example.gameHandler.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EndView extends View{
    public EndView(Game game, boolean isSurrender, int surrenderPlayer, int blackPoint, int whitePoint) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/EndGameView.fxml"));
        Parent root = loader.load();
        EndGameController controller = loader.<EndGameController>getController();
        controller.showEndGameInfo(isSurrender,surrenderPlayer, blackPoint, whitePoint);
        controller.setGame(game);
        Stage stage = new Stage();
        stage.setTitle("GoGame EndGame");
        stage.setScene(new Scene(root,600,400));
        this.stage = stage;
        stage.show();
    }
}
