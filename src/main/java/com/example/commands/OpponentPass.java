package com.example.commands;

import com.example.controllers.BoardController;
import com.example.gameHandler.Game;
import com.example.serverCommand.ServerCommand;

public class OpponentPass extends Command{
    public OpponentPass(Game game, ServerCommand serverCommand) {
        super(game, serverCommand);
    }

    @Override
    public void execute() {
        ((BoardController)game.getView().getController()).showOpponentPass();
    }
}
