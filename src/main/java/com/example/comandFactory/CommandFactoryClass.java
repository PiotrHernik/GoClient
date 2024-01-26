package com.example.comandFactory;

import com.example.MessagefromServer.EndGame;
import com.example.MessagefromServer.MoveInfo;
import com.example.commands.*;
import com.example.gameHandler.Game;
import com.example.MessagefromServer.*;
import com.example.MessagefromServer.NewGame;
import com.example.MessagefromServer.OpponentPass;

public class CommandFactoryClass implements CommandFactory{
    @Override
    public Command getCommand(Game game, Server_serverMessage serverServerMessage){
        if (serverServerMessage instanceof SentGameOptions) {
            return new SetSettingsCommand(game, serverServerMessage);
        } else if (serverServerMessage instanceof MoveInfo) {
            return new MoveCommand(game, serverServerMessage);
        } else if (serverServerMessage instanceof EndGame) {
            return new EndGameCommand(game, serverServerMessage);
        } else if (serverServerMessage instanceof NewGame) {
            return new NewGameCommand(game, serverServerMessage);
        } else if (serverServerMessage instanceof OpponentPass) {
            return new OpponentPassCommand(game, serverServerMessage);
        }

        return null;
    }
}
