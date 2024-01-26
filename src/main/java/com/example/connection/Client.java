package com.example.connection;

import com.example.gameHandler.Game;
import com.example.message.Message;
import com.example.MessagefromServer.Server_serverMessage;

import java.io.IOException;
import java.net.UnknownHostException;

public class Client extends ClientConnection{
    private Game game;
    public Client(String ip,int port) throws UnknownHostException, IOException {
        super(ip, port);
    }

    @Override
    public void getServerCommand(Server_serverMessage serverServerMessage){
        game.getServerCommand(serverServerMessage);
    }

    public void sendMessage(Message message) throws IOException {
        this.sendMessageToServer(message);
    }

    public void setGame(Game game){
        this.game = game;
    }

}
