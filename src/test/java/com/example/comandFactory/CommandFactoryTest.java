package com.example.comandFactory;

import com.example.commands.*;
import com.example.gameHandler.Game;
import com.example.serwer.MessagefromServer.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {
    @Mock
    Game gameMock;

    @Test
    public void moveInfoTest () {
        CommandFactory commandFactory = new CommandFactoryClass();
        Server_serverMessage serverMessage = new MoveInfo(0,false,0,0, null);
        Command command = commandFactory.getCommand(gameMock, serverMessage);
        assertTrue(command instanceof MoveCommand);
    }

    @Test
    public void newGameMessageTest () {
        CommandFactory commandFactory = new CommandFactoryClass();
        int[] gameId = new int [5];
        Server_serverMessage serverMessage = new NewGame(gameId);
        Command command = commandFactory.getCommand(gameMock, serverMessage);
        assertTrue(command instanceof NewGameCommand);
    }

    @Test
    public void opponentPassTest () {
        CommandFactory commandFactory = new CommandFactoryClass();
        Server_serverMessage serverMessage = new OpponentPass();
        Command command = commandFactory.getCommand(gameMock, serverMessage);
        assertTrue(command instanceof OpponentPassCommand);
    }

    @Test
    public void optionsMessageTest() {
        CommandFactory commandFactory = new CommandFactoryClass();
        Server_serverMessage serverMessage = new SentGameOptions(0,0,null);
        Command command = commandFactory.getCommand(gameMock, serverMessage);
        assertTrue(command instanceof SetSettingsCommand);
    }

    @Test
    public void endGameTest() {
        CommandFactory commandFactory = new CommandFactoryClass();
        Server_serverMessage serverMessage = new EndGame(false, 0, 0, 0);
        Command command = commandFactory.getCommand(gameMock, serverMessage);
        assertTrue(command instanceof EndGameCommand);
    }
}