package com.example.gameHandler;

import com.example.commands.Command;
import com.example.View.View;
import com.example.comandFactory.CommandFactory;
import com.example.comandFactory.CommandFactoryClass;
import com.example.connection.Client;
import com.example.serwer.ClientMessages.Server_ClientMessage;
import com.example.serwer.MessagefromServer.Server_serverMessage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {
    private Stage stage;
    private Client client;
    private View view;
    private CommandFactory commandFactory;


    public Game(Stage stage, Client client){
        this.stage = stage;
        this.client = client;
        this.commandFactory = new CommandFactoryClass();
    }

    public void sendMessage(Server_ClientMessage serverClientMessage) {
        try {
            client.sendMessage(serverClientMessage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void getServerCommand(Server_serverMessage serverServerMessage){
        System.out.println("Przetwarzam kolejną wiadomość w game");
        Command command = commandFactory.getCommand(this, serverServerMessage);
        command.execute();
    }

    public Stage getStage(){return stage;}
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Client getClient() {
        return client;
    }
    public void ShowWaitView() { // wywolywane w GoGameClientApplication
        VBox vBox = new VBox(new Label("Waiting for server"));
        Scene scene = new Scene(vBox);
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public View getView(){
        return view;
    }
    public void setView(View view) {
        this.view = view;
    }
    public void closeConnection() {
        client.closeConnection();

    }
}
