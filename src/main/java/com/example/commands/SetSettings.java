package com.example.commands;

import com.example.View.BoardView;
import com.example.gameHandler.Game;
import com.example.serverCommand.SentGameOptionsServer;
import com.example.serverCommand.ServerCommand;

public class SetSettings extends Command{
    public SetSettings(Game game, ServerCommand serverCommand) {
        super(game, serverCommand);
    }

    @Override
    public void execute() {
        int size = ((SentGameOptionsServer)serverCommand).getSize();
        game.setView(new BoardView(game, size));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getStage().show();
    }
}
