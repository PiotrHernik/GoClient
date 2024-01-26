package com.example.controllers;

import com.example.serwer.ClientMessages.Server_ClientMessage;
import com.example.serwer.ClientMessages.SetOptions;
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

public class NewGameController extends Controller{
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

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        LinkedList<Integer> oList = new LinkedList<>();
//       //System.out.println(gameIds[0]);
//        for (int gameId : gameIds) {
//            oList.add(gameId);
//
//        }
//        for (int i : oList){
//            System.out.println(i);
//        }
//        comboBox.getItems().addAll(oList);
//    }

    @FXML
    void loadChosenGame(ActionEvent event) {
        int gameId = comboBox.getValue();
        if(gameId != -1) {
            System.out.println("Dziala" + gameId);
            Server_ClientMessage serverClientMessage = new SetOptions(0,"Load",gameId);
            game.sendMessage(serverClientMessage);
        } else {
            textLabel.setText("Nie wybrales opcji!");
        }
    }

    @FXML
    void sendGameOptions(ActionEvent event) {
        System.out.println(event.toString());
        System.out.println("Kliknąłem start");
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
            System.out.println("Wysyłam do servera");
            Server_ClientMessage serverClientMessage = new SetOptions(size,type);
            game.sendMessage(serverClientMessage);
        } else {
            textLabel.setText("Nie wybrales opcji!");
        }
    }

    public int[] getGameID() {
        return gameIds;
    }

    public void setGameID(int[] gameIds) {
        this.gameIds = gameIds;
        LinkedList<Integer> oList = new LinkedList<>();
        //System.out.println(gameIds[0]);
        for (int gameId : gameIds) {
            oList.add(gameId);

        }
        for (int i : oList){
            System.out.println(i);
        }
        comboBox.getItems().addAll(oList);
    }

}
