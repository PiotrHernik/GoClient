
package com.example.commands;

import com.example.controllers.BoardController;
import com.example.gameHandler.Game;
import com.example.serverCommand.MoveServer;
import com.example.serverCommand.ServerCommand;

public class Move extends Command{

    public Move(Game game, ServerCommand serverCommand) {
        super(game, serverCommand);
    }

    @Override
    public void execute() {
        boolean doMove = ((MoveServer) serverCommand).isCorrectMove();
        int x = ((MoveServer) serverCommand).getX();
        int y = ((MoveServer) serverCommand).getY();
        int[][] empty = ((MoveServer) serverCommand).getEmptyPlaces();
        int color = ((MoveServer) serverCommand).getPlayer();

        if(doMove) {
            ((BoardController)game.getView().getController()).showMove(x, y, color);
            ((BoardController)game.getView().getController()).emptyPlaces(empty);
        } else {
            //TODO what to do when move is not correct?
        }
    }
}
