package com.example.MessagefromServer;

public class NewGame implements Server_serverMessage {
    private static final long serialVersionUID = 1L;

    private int[] gamesIdList;
    public NewGame(int[] gamesIdList) {
        System.out.println("Przed przypisaniem tablicy");
        this.gamesIdList = gamesIdList;
        System.out.println("Po przypisaniu tablicy");
    }

    public int[] getGamesIdList() {
        return gamesIdList;
    }

    public void setGamesIdList(int[] gamesIdList) {
        this.gamesIdList = gamesIdList;
    }
}
