package com.example.View;

import com.example.controllers.BoardController;
import com.example.gameHandler.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardView extends View {
    public BoardView(Game game, int size){
        try{
            FXMLLoader loader = new FXMLLoader();
            if(size == 9){
                loader.setLocation(getClass().getResource("/Board9.fxml"));
            } else if (size == 13) {
                loader.setLocation(getClass().getResource("/Board13.fxml"));
            }else {
                loader.setLocation(getClass().getResource("/Board19.fxml"));
            }
            Parent root = loader.load();
            this.controller = loader.<BoardController>getController();
            this.controller.setGame(game);
            Stage stage = new Stage();
            stage.setTitle("Go GO");
            stage.setScene(new Scene(root, 800, 600));
            this.stage = stage;
            stage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
