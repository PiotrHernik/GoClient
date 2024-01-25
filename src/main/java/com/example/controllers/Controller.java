package com.example.controllers;

import com.example.gameHandler.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class Controller {
    protected Game game;
    public void setGame(Game game){
        this.game = game;
    }
}