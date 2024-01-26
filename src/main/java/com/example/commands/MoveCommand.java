
package com.example.commands;

import com.example.MessagefromServer.MoveInfo;
import com.example.controllers.BoardController;
import com.example.gameHandler.Game;
import com.example.MessagefromServer.Server_serverMessage;

public class MoveCommand extends Command{

    public MoveCommand(Game game, Server_serverMessage serverServerMessage) {
        super(game, serverServerMessage);
    }

    @Override
    public void execute() {
        boolean doMove = ((MoveInfo) serverServerMessage).isCorrectMove();
        int x = ((MoveInfo) serverServerMessage).getX();
        int y = ((MoveInfo) serverServerMessage).getY();
        int[][] empty = ((MoveInfo) serverServerMessage).getEmptyPlaces();
        int color = ((MoveInfo) serverServerMessage).getPlayer();

        if(doMove) {
            ((BoardController)game.getView().getController()).showMove(x, y, color);
            ((BoardController)game.getView().getController()).emptyPlaces(empty);
        } else {
            //TODO what to do when move is not correct?
        }
    }
}
