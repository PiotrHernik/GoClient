package com.example.comandFactory;

import com.example.commands.*;
import com.example.gameHandler.Game;
import com.example.serverCommand.*;
import com.example.serverCommand.OpponentPassServer;

public class CommandFactoryClass implements CommandFactory{
    @Override
    public Command getCommand(Game game, ServerCommand serverCommand){
        if (serverCommand instanceof SentGameOptionsServer) {
            return new SetSettings(game, serverCommand);
        } else if (serverCommand instanceof MoveServer) {
            return new Move(game, serverCommand);
        } else if (serverCommand instanceof EndGameServer) {
            return new EndGame(game, serverCommand);
        } else if (serverCommand instanceof NewGameServer) {
            return new NewGame(game, serverCommand);
        } else if (serverCommand instanceof OpponentPassServer) {
            return new OpponentPass(game, serverCommand);
        }

        return null;
    }
}
