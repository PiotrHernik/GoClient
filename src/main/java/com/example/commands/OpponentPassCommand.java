package com.example.commands;

import com.example.controllers.BoardController;
import com.example.gameHandler.Game;
import com.example.MessagefromServer.Server_serverMessage;

public class OpponentPassCommand extends Command{
    public OpponentPassCommand(Game game, Server_serverMessage serverServerMessage) {
        super(game, serverServerMessage);
    }

    @Override
    public void execute() {
        ((BoardController)game.getView().getController()).showOpponentPass();
    }
}
