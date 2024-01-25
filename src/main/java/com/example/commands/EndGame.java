package com.example.commands;

import com.example.gameHandler.Game;
import com.example.serverCommand.ServerCommand;

public class EndGame extends Command{
    public EndGame(Game game, ServerCommand serverCommand){
        super(game, serverCommand);
    }
    public void execute(){}
}
