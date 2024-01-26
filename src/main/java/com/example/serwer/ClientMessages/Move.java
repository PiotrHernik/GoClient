package com.example.serwer.ClientMessages;

public class Move implements Server_ClientMessage {
    private int x;
    private int y;

    public Move(int setX, int setY) {
        this.x=setX;
        this.y=setY;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
