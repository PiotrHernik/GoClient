package com.example.serverCommand;

public class SentGameOptionsServer {
    int player;
    int size;
    String mode; //hotSeat, singleplayer, multiplayer

    public SentGameOptionsServer(int player, int size, String mode) {
        this.player = player;
        this.size = size;
        this.mode = mode;
    }

    public int getPlayer() {
        return this.player;
    }

    public int getSize() {
        return size;
    }

    public String getMode() {
        return mode;
    }
}
