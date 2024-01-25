package com.example.comandFactory;

import ccom.example.commands.Command;
import com.example.gameHandler.Game;
import com.example.serverCommand.ServerCommand;

public interface CommandFactory {
    public Command getCommand(Game game, ServerCommand serverCommand);
}
