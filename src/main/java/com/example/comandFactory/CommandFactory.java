package com.example.comandFactory;

import com.example.commands.Command;
import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.Server_serverMessage;

public interface CommandFactory {
    public Command getCommand(Game game, Server_serverMessage serverServerMessage);
}
