package com.example.controllers;

import com.example.serwer.ClientMessages.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class BoardController extends Controller{
    @FXML
    private GridPane gridPane;

    @FXML
    private Text pass;

    @FXML
    void OnNextAction(ActionEvent event) {
        hideOpponentPass();
        Server_ClientMessage serverClientMessage = new Next();
        game.sendMessage(serverClientMessage);
    }
    @FXML
    void MakeMove(MouseEvent event) {
        hideOpponentPass();
        Node node = (Node) event.getSource();
        int x = GridPane.getRowIndex(node);
        int y = GridPane.getColumnIndex(node);
        Server_ClientMessage serverClientMessage = new Move(x,y);
        System.out.println(x + " " + y);
        game.sendMessage(serverClientMessage);
    }
    @FXML
    void OnPassAction(ActionEvent event) {
        System.out.println("Pasue");
        hideOpponentPass();
        Server_ClientMessage serverClientMessage = new Pass();
        game.sendMessage(serverClientMessage);
    }
    @FXML
    void OnSurrenderAction(ActionEvent event) {
        hideOpponentPass();
        Server_ClientMessage serverClientMessage = new Surrender();
        game.sendMessage(serverClientMessage);
    }

    public void showMove(int x, int y, int color) {
        Node node = findNode(x,y);
        if(node != null) {
            if(color == 1)
                ((Circle) node).setFill(javafx.scene.paint.Color.BLACK);
            else if(color == 2)
                ((Circle) node).setFill(javafx.scene.paint.Color.WHITE);
            else
                System.out.println("Niepoprawny kolor gracza ");
        }
    }
    public Node findNode(int x, int y) {
        Node nodeFound = null;
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            if(GridPane.getRowIndex(node) == x && GridPane.getColumnIndex(node) == y) {
                nodeFound = node;
                return nodeFound;
            }
        }
        return nodeFound;
    }
    public void emptyPlaces(int[][] empty) {
        Node nodeFound = null;
        for (int i = 0; i<empty.length ; i++) {
            nodeFound = null;
            nodeFound = findNode(empty[i][0], empty[i][1]);
            if(nodeFound != null)
                ((Circle) nodeFound).setFill(javafx.scene.paint.Color.TRANSPARENT);
        }
    }

    public void showOpponentPass() { pass.setText("Przeciwnik czeka"); }
    public void hideOpponentPass() {
        pass.setText("");
    }
}
