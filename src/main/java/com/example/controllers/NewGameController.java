package com.example.controllers;

import com.example.gameHandler.Game;
import com.example.message.Message;
import com.example.message.SetOptionsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class NewGameController extends Controller implements Initializable {
    @FXML
    private Text textLabel;

    @FXML
    private ToggleGroup typeGroup;

    @FXML
    private ToggleGroup sizeGroup;

    @FXML
    private Button startButton;

    @FXML
    private Button load;

    @FXML
    private ComboBox<Integer> comboBox;


    private int[] gameIds;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LinkedList<Integer> oList = new LinkedList<>();
        for (int gameId : gameIds) {
            oList.add(gameId);
        }
        comboBox.getItems().addAll(oList);
    }

    @FXML
    void loadChosenGame(ActionEvent event) {
        int gameId = comboBox.getValue();
        if(gameId != -1) {
            System.out.println("Dziala" + gameId);
            Message message = new SetOptionsMessage(0,"Load",gameId);
            game.sendMessage(message);
        } else {
            textLabel.setText("Nie wybrales opcji!");
        }
    }

    @FXML
    void sendGameOptions(ActionEvent event) {
        System.out.println(event.toString());
        int size;
        String type;
        RadioButton selectedTypeButton = (RadioButton) typeGroup.getSelectedToggle();
        RadioButton selectedSizeButton = (RadioButton) sizeGroup.getSelectedToggle();
        if(selectedTypeButton != null && selectedSizeButton != null) {
            type = selectedTypeButton.getText();
            if(selectedSizeButton.getText().equals("9x9")) {
                size = 9;
            } else if(selectedSizeButton.getText().equals("13x13")) {
                size = 13;
            } else if(selectedSizeButton.getText().equals("19x19")) {
                size = 19;
            } else {
                System.out.println("Size się nei ustawił w NewGame Frame > SendGameOptions.");
                size=0;
            }
            Message message = new SetOptionsMessage(size,type);
            game.sendMessage(message);
        } else {
            textLabel.setText("Nie wybrales opcji!");
        }
    }

    public int[] getGameID() {
        return gameIds;
    }

    public void setGameID(int[] gameIds) {
        this.gameIds = gameIds;
    }

}
