package com.example.comandFactory;

import ccom.example.commands.Command;
import ccom.example.commands.EndGame;
import ccom.example.commands.Move;
import com.example.gameHandler.Game;
import com.example.serverCommand.*;

public class CommandFactoryClass implements CommandFactory{
    @Override
    public Command getCommand(Game game, ServerCommand serverCommand){
        if (serverCommand instanceof SentGameOptionsServer) {
            //return new SetGameSettingsCommand(game, serverCommand);
        } else if (serverCommand instanceof MoveServer) {
            return new Move(game, serverCommand);
        } else if (serverCommand instanceof EndGameServer) {
            return new EndGame(game, serverCommand);
        } else if (serverCommand instanceof NewGameServer) {
            //return new NewGameCommand(game, serverCommand);
        } else if (serverCommand instanceof OpponentPass) {
            //return new OpponentPassCommand(game, serverCommand);
        }

        return null;
    }
}
