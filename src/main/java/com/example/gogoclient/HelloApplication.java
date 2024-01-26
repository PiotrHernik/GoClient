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
    public static void main(String[] args) {
        launch();
    }
    public void init(){
        try{
            client = new Client("localhost", 3311);
        } catch (IOException ex){
            ex.printStackTrace();
        }


    }
    @Override
    public void start(Stage stage) throws IOException {
        Game game = new Game(stage, client);
        System.out.println("Stworzyłem klienta i uruchamiam połaczenie");
        //game.ShowFirstView();
        client.setGame(game);
        client.startConnection();
    }


}