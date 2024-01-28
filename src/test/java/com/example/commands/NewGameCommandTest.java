//package com.example.commands;
//
//import com.example.View.StartView;
//import com.example.gameHandler.Game;
//import com.example.serwer.MessagefromServer.NewGame;
//import com.example.serwer.MessagefromServer.Server_serverMessage;
//import javafx.application.Platform;
//import org.junit.jupiter.api.Test;
//import org.testfx.api.FxToolkit;
//import org.testfx.framework.junit5.ApplicationTest;
//
//import java.util.concurrent.TimeoutException;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//class NewGameCommandTest extends ApplicationTest {
//
//
//    public void start(Game game) throws Exception {
//        // Implementacja start metody, np. otwarcie okna aplikacji
//    }
//
//    @Test
//    void execute_shouldSetViewAndShowStage() {
//        // Arrange
//        Game mockGame = mock(Game.class);
//        Server_serverMessage mockServerMessage = mock(NewGame.class);
//        NewGameCommand newGameCommand = new NewGameCommand(mockGame, mockServerMessage);
//
//        // Act
//        interact(() -> {
//            try {
//                FxToolkit.registerPrimaryStage();
//            } catch (TimeoutException e) {
//                throw new RuntimeException(e);
//            }
//            newGameCommand.execute();
//        });
//
//        // Assert
//        verify(mockGame).setView(new StartView(mockGame, ((NewGame) mockServerMessage).getGamesIdList()));
//        verify(mockGame).getStage().close();
//        verify(mockGame).setStage(mockGame.getView().getStage());
//
//        // Sprawdzanie, czy kod jest uruchamiany w wątku aplikacji JavaFX
//        Platform.runLater(() -> {
//            assertTrue(Platform.isFxApplicationThread());
//        });
//    }
//}