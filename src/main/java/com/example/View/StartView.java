package com.example.View;

import com.example.controllers.NewGameController;
import com.example.gameHandler.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView extends View{
    public StartView(Game game, int[] gameID) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FirstView.fxml"));
            Parent root = loader.load();
            NewGameController controller = loader.<NewGameController>getController();
            controller.setGame(game);
            controller.setGameID(gameID);
            Stage stage = new Stage();
            stage.setTitle("New game");
            stage.setScene(new Scene(root, 500, 500));
            this.stage = stage;
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
