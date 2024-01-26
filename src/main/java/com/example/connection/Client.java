package com.example.connection;

import com.example.gameHandler.Game;
import com.example.serwer.ClientMessages.Server_ClientMessage;
import com.example.serwer.MessagefromServer.Server_serverMessage;

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

    public void sendMessage(Server_ClientMessage serverClientMessage) throws IOException {
        this.sendMessageToServer(serverClientMessage);
    }

    public void setGame(Game game){
        this.game = game;
    }

}
