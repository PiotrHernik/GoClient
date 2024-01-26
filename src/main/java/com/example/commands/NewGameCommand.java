package com.example.commands;

import com.example.serwer.MessagefromServer.NewGame;
import com.example.View.StartView;
import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.Server_serverMessage;

public class NewGameCommand extends Command{
    public NewGameCommand(Game game, Server_serverMessage serverServerMessage) {
        super(game, serverServerMessage);
    }

    @Override
    public void execute() {
        System.out.println("Jestem w NewGameCommand");
        game.setView(new StartView(game,((NewGame) serverServerMessage).getGamesIdList()));
        System.out.println("Jestem za nowym widokiem");
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getStage().show();
    }


}
