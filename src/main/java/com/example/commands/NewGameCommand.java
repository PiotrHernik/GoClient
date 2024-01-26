package com.example.commands;

import com.example.View.StartView;
import com.example.gameHandler.Game;
import com.example.MessagefromServer.Server_serverMessage;

public class NewGameCommand extends Command{
    public NewGameCommand(Game game, Server_serverMessage serverServerMessage) {
        super(game, serverServerMessage);
    }

    @Override
    public void execute() {
        game.setView(new StartView(game,((com.example.MessagefromServer.NewGame) serverServerMessage).getGamesIdList()));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getStage().show();
    }


}
