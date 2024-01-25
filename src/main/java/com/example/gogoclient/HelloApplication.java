package com.example.gogoclient;

import com.example.connection.Client;
import com.example.gameHandler.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Client client;
    @Override
    public void start(Stage stage) throws IOException {
        try{
            client = new Client("localhost", 3558);
        } catch (IOException ex){
            ex.printStackTrace();
        }

        Game game = new Game(stage, client);
        //game.ShowFirstView();
        client.setGame(game);
        client.startConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}