package com.example.gameHandler;

import com.example.commands.Command;
import com.example.View.View;
import com.example.comandFactory.CommandFactory;
import com.example.comandFactory.CommandFactoryClass;
import com.example.connection.Client;
import com.example.message.Message;
import com.example.MessagefromServer.Server_serverMessage;
import javafx.stage.Stage;

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

    public void sendMessage(Message message) {
    }
    public void getServerCommand(Server_serverMessage serverServerMessage){
        Command command = commandFactory.getCommand(this, serverServerMessage);
        command.execute();
    }

    public Stage getStage(){return getStage();}
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Client getClient() {
        return client;
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
