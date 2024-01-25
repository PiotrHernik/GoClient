package com.example.gameHandler;

import ccom.example.commands.Command;
import com.example.View.View;
import com.example.comandFactory.CommandFactory;
import com.example.comandFactory.CommandFactoryClass;
import com.example.connection.Client;
import com.example.message.Message;
import com.example.serverCommand.ServerCommand;
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
    public void getServerCommand(ServerCommand serverCommand){
        Command command = commandFactory.getCommand(this, serverCommand);
        command.execute();
    }
    public View getView(){
        return view;
    }
}
