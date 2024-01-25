package com.example.connection;

import com.example.message.Message;
import com.example.serverCommand.ServerCommand;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class ClientConnection {
    protected ClientThread clientThred;

    public ClientConnection(String ip, int port){
        this.clientThred = new ClientThread(ip, port);
    }

    protected abstract void getServerCommand(ServerCommand serverCommand);

    protected void sendMessageToServer(Message message) throws IOException {
        clientThred.outputStream.writeObject(message);
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
        public void run (){
            try{
                connect();
                listen();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        private void connect() throws IOException {
            while(true){
                this.socket = new Socket(ip, port);
                try{
                    this.socket = new Socket(ip, port);
                    break;
                }catch (IOException e){
                    e.printStackTrace();
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
                if(!isRunning){
                    socket.close();
                    break;
                }

                final ServerCommand serverCommand;
                serverCommand = (ServerCommand) inputStream.readObject();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        getServerCommand(serverCommand);
                    }
                });
                //if(serverCommand instanceof EndGame) isRunning = false;

            }
        }

    }
}

