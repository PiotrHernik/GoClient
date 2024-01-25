package com.example.commands;

import com.example.View.StartView;
import com.example.gameHandler.Game;
import com.example.serverCommand.NewGameServer;
import com.example.serverCommand.ServerCommand;

public class NewGame extends Command{
    public NewGame(Game game, ServerCommand serverCommand) {
        super(game, serverCommand);
    }

    @Override
    public void execute() {
        game.setView(new StartView(game,((NewGameServer) serverCommand).getGamesIdList()));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getStage().show();
    }


}
