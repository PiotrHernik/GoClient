package com.example.serwer.ClientMessages;

import java.io.Serial;

public class SetOptions implements Server_ClientMessage
{
    @Serial
    private static final long serialVersionUID = 1L;
    int size;
    String mode; //hotSeat, Online, Multiplayer
    int gameId;

    public SetOptions(int size, String mode) {
        this.size = size;
        this.mode = mode;
    }
    public SetOptions(int size, String mode, int gameId) {
        this.size = size;
        this.mode = mode;
        this.gameId = gameId;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
