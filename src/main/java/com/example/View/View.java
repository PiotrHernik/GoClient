package com.example.View;

import com.example.controllers.Controller;
import javafx.stage.Stage;

public abstract class View {
    protected Controller controller;
    protected Stage stage;

    public Controller getController(){return controller;}
    public Stage getStage(){return stage;}
}
