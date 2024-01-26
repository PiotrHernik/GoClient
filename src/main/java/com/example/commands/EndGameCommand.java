
package com.example.commands;

import com.example.serwer.MessagefromServer.EndGame;
import com.example.View.EndView;
import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.Server_serverMessage;

public class EndGameCommand extends Command{
    public EndGameCommand(Game game, Server_serverMessage serverServerMessage){
        super(game, serverServerMessage);
    }
    public void execute(){
        int blackPoint = ((EndGame) serverServerMessage).getplayer1Points();
        int whitePoint = ((EndGame) serverServerMessage).getplayer2Points();
        int surrenderPlayer = ((EndGame) serverServerMessage).getPlayerSurrender();
        boolean isSurrender = ((EndGame) serverServerMessage).isSurrender();

        game.setView(new EndView(game, isSurrender, surrenderPlayer, blackPoint, whitePoint));
        game.getStage().close();
        game.setStage(game.getView().getStage());
        game.getView().getStage().show();
    }

}
