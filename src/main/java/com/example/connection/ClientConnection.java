package com.example.connection;

import com.example.commands.EndGameCommand;
import com.example.serwer.ClientMessages.Server_ClientMessage;
import com.example.serwer.MessagefromServer.Server_serverMessage;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public abstract class ClientConnection {
    protected ClientThread clientThred;

    public ClientConnection(String ip, int port){
        this.clientThred = new ClientThread(ip, port);
    }

    protected abstract void getServerCommand(Server_serverMessage serverServerMessage);

    protected void sendMessageToServer(Server_ClientMessage serverClientMessage) throws IOException {
        clientThred.outputStream.writeObject(serverClientMessage);
    }
    public void closeConnection() {
        clientThred.closeConnection();
    }

    public void startConnection() {
        clientThred.start();
    }


    private class ClientThread extends Thread {
        private Socket socket;
        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;
        private int port;
        private String ip;
        private boolean isRunning;

        public ClientThread(String ip, int port){
            this.port = port;
            this.ip = ip;
            isRunning = true;
        }
        public void closeConnection() {isRunning = false;}

        @Override
        public void run (){ read(); }

        public void read(){
            try {
                connect();
                listen();
            } catch (Exception e) {
                e.getStackTrace();
                System.out.println("jestem w ClientConnection read: " + e.getMessage()); //TODO handle
            } finally {
                try {
                    socket.close(); // TODO zrobie nie tak zeby klient mogl spokojnie poczekac na serwer.
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }


        private void connect() {
            int i = 0;
            while(true){

                try{
                    System.out.println("Przed socketem");
                    this.socket = new Socket(ip, port);
                    System.out.println("po nowym sockecie");
                    break;
                }catch (IOException e){
                    System.out.println("Nie udalo się połączyc, proboje jeszcze raz: " + i);
                    i++;
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch(InterruptedException ie) {
                        // Interrupted.
                    };
                }
            }
            try{
                this.outputStream = new ObjectOutputStream(socket.getOutputStream());
                this.inputStream = new ObjectInputStream(socket.getInputStream());
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        private void listen() throws ClassNotFoundException ,IOException {
            while (inputStream != null){
                System.out.println("Jestem w listen w whilu");
                if(!isRunning){
                    socket.close();
                    break;
                }

                final Server_serverMessage serverServerMessage;
                System.out.println("Przed czytaniem obiektu od servera");

                serverServerMessage = (Server_serverMessage) inputStream.readObject();

                System.out.println("Teraz będe nasłuchiwał");
                Platform.runLater(() -> {
                    System.out.println("Jesteem w platform run later");
                    getServerCommand(serverServerMessage);
                    System.out.println("Jesetem za getServerCommand");
                });
                if(serverServerMessage instanceof EndGameCommand) isRunning = false;

            }
        }

    }
}

