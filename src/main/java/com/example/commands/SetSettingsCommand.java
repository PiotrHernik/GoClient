package com.example.commands;

import com.example.View.BoardView;
import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.SentGameOptions;
import com.example.serwer.MessagefromServer.Server_serverMessage;

public class SetSettingsCommand extends Command{
    public SetSettingsCommand(Game game, Server_serverMessage serverServerMessage) {
        super(game, serverServerMessage);
    }

    @Override
    public void execute() {
        int size = ((SentGameOptions) serverServerMessage).getSize();
        game.setView(new BoardView(game, size));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getStage().show();
    }
}
