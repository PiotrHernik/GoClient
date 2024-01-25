package com.example.serverCommand;

public class NewGameServer implements ServerCommand {
    private int[] gamesIdList;

    public NewGameServer(int[] gamesIdList) {
        this.gamesIdList = gamesIdList;
    }

    public int[] getGamesIdList() {
        return gamesIdList;
    }

    public void setGamesIdList(int[] gamesIdList) {
        this.gamesIdList = gamesIdList;
    }
}
