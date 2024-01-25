package com.example.connection;

import com.example.gameHandler.Game;
import com.example.message.Message;
import com.example.serverCommand.ServerCommand;

import java.io.IOException;
import java.lang.reflect.Member;
import java.net.UnknownHostException;

public class Client extends ClientConnection{
    private Game game;
    public Client(String ip,int port) throws UnknownHostException, IOException {
        super(ip, port);
    }

    @Override
    public void getServerCommand(ServerCommand serverCommand){
        //game.getServerCommand(serverCommand);
    }

    public void sendMessage(Message message) throws IOException {
        this.sendMessageToServer(message);
    }

    public void setGame(Game game){
        this.game = game;
    }

}
