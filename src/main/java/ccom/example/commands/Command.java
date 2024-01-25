package ccom.example.commands;

import com.example.gameHandler.Game;
import com.example.serverCommand.ServerCommand;

public abstract class Command {
    Game game;
    ServerCommand serverCommand;
    public Command(Game game, ServerCommand serverCommand){
        this.game = game;
        this.serverCommand = serverCommand;
    }
    public abstract void execute();
}
