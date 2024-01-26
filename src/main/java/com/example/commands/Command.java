
package com.example.commands;

import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.Server_serverMessage;

public abstract class Command {
    Game game;
    Server_serverMessage serverServerMessage;
    public Command(Game game, Server_serverMessage serverServerMessage){
        this.game = game;
        this.serverServerMessage = serverServerMessage;
    }
    public abstract void execute();

}
