
package com.example.commands;

import com.example.View.EndView;
import com.example.gameHandler.Game;
import com.example.MessagefromServer.Server_serverMessage;

public class EndGameCommand extends Command{
    public EndGameCommand(Game game, Server_serverMessage serverServerMessage){
        super(game, serverServerMessage);
    }
    public void execute(){
        int blackPoint = ((com.example.MessagefromServer.EndGame) serverServerMessage).getplayer1Points();
        int whitePoint = ((com.example.MessagefromServer.EndGame) serverServerMessage).getplayer2Points();
        int surrenderPlayer = ((com.example.MessagefromServer.EndGame) serverServerMessage).getPlayerSurrender();
        boolean isSurrender = ((com.example.MessagefromServer.EndGame) serverServerMessage).isSurrender();

        game.setView(new EndView(game, isSurrender, surrenderPlayer, blackPoint, whitePoint));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getView().getStage().show();
    }

}
