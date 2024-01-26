package com.example.message;

public class MoveMessage implements Message{
    private int x;
    private int y;

    public MoveMessage(int setX, int setY) {
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
