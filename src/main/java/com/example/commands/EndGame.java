package com.example.commands;

import com.example.View.EndView;
import com.example.gameHandler.Game;
import com.example.serverCommand.EndGameServer;
import com.example.serverCommand.ServerCommand;

public class EndGame extends Command{
    public EndGame(Game game, ServerCommand serverCommand){
        super(game, serverCommand);
    }
    public void execute(){
        int blackPoint = ((EndGameServer)serverCommand).getplayer1Points();
        int whitePoint = ((EndGameServer)serverCommand).getplayer2Points();
        int surrenderPlayer = ((EndGameServer)serverCommand).getPlayerSurrender();
        boolean isSurrender = ((EndGameServer)serverCommand).isSurrender();

        game.setView(new EndView(game, isSurrender, surrenderPlayer, blackPoint, whitePoint));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getView().getStage().show();
    }
}
