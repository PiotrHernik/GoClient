package com.example.commands;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.View.StartView;
import com.example.View.View;
import com.example.controllers.BoardController;
import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.MoveInfo;
import com.example.serwer.MessagefromServer.NewGame;
import com.example.serwer.MessagefromServer.OpponentPass;
import com.example.serwer.MessagefromServer.Server_serverMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javafx.stage.Stage;
class CommandTest {
    View viewMock;
    Game gameMock;
    Stage stageMock;

    @BeforeEach
    public void beforeCommandTest(){
        this.viewMock = mock(View.class);
        this.gameMock = mock(Game.class);
        this.stageMock = mock(Stage.class);
        Mockito.when(gameMock.getView()).thenReturn(viewMock);
    }

    @Test
    public void moveCommandTest(){
        BoardController controllerMock = mock(BoardController.class);
        Mockito.when(viewMock.getController()).thenReturn(controllerMock);
        Server_serverMessage serverMessage = new MoveInfo(0, true, 0, 0, null);
        Command command = new MoveCommand(gameMock, serverMessage);
        command.execute();
        verify(controllerMock).showMove(0,0,0);
        verify(controllerMock).emptyPlaces(null);
    }

    @Test
    public void opponentPassCommandTest() {
        BoardController controllerMock = mock(BoardController.class);
        Mockito.when(viewMock.getController()).thenReturn(controllerMock);
        Server_serverMessage serverMessage = new OpponentPass();
        Command command = new OpponentPassCommand(gameMock, serverMessage);
        command.execute();
        verify(controllerMock).showOpponentPass();
    }

//    @Test
//    public void setGameSettingsCommandTest(){
//
//    }

//    @Test
//    public void newGameCommandTest(){
//        int[] gameId = {5};
//        Server_serverMessage serverMessage = new NewGame(gameId);
//        Command command = new NewGameCommand(gameMock, serverMessage);
//        command.execute();
//        Mockito.verify(gameMock).setView(new StartView(gameMock, gameId));
//        Mockito.verify(gameMock).getStage().show();
//
//    }
//@Test
//void execute_shouldSetViewAndShowStage() {
//    // Arrange
//    Game mockGame = mock(Game.class);
//    Server_serverMessage mockServerMessage = mock(NewGame.class);
//    NewGameCommand newGameCommand = new NewGameCommand(mockGame, mockServerMessage);
//
//    // Act
//    newGameCommand.execute();
//
//    // Assert
//    verify(mockGame).setView(new StartView(mockGame, ((NewGame) mockServerMessage).getGamesIdList()));
//    verify(mockGame).getStage().close();
//    verify(mockGame).setStage(mockGame.getView().getStage());
//    verify(mockGame).getStage().show();
//}


}