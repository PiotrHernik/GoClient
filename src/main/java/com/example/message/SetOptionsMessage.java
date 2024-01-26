package com.example.message;

public class SetOptionsMessage implements Message{
    int size;
    String mode; //hotSeat, Online, Multiplayer
    int gameId;



    public SetOptionsMessage(int size, String mode, int gameId) {
        this.size = size;
        this.mode = mode;
        this.gameId = gameId;
    }
    public SetOptionsMessage(int size, String mode) {
        this.size = size;
        this.mode = mode;
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
