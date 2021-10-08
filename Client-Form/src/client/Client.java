package client;

import controller.*;
import java.io.*;
import java.net.*;

public class Client implements Runnable {

    private Socket s = null;
    private boolean isConnect = false;
    private boolean newCommand = true;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public void command() {
        newCommand = true;
    }

    public void setNewCommand(boolean newCommand) {
        this.newCommand = newCommand;
    }

    public void connectClient(int port) throws Exception {

        s = new Socket("localhost", port);
        isConnect = true;
        Thread clientThread = new Thread(this);
        clientThread.start();
    }

    public void disconnectClient() throws Exception {
        try {
            isConnect = false;
            s.close();
            newCommand = true;
        } catch (Exception e) {
            throw new Exception("Ошибка  отключения от сервера");
        }
    }

    @Override
    public void run() {
        try {
            ServerRequest sr;
            GeneralController.putRequestToServer(1, null);
            while (isConnect) {
                while (!newCommand)
                    System.out.print("");
                sr = GeneralController.getServerRequest();
                oos = new ObjectOutputStream(s.getOutputStream());

                while (newCommand) {
                    oos.writeObject(sr);

                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    GeneralController.getResponceFromServer((ServerResponce) ois.readObject());
                    newCommand = false;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean isConnect() {
        return isConnect;
    }
    public void setConnect(boolean start) {
        isConnect = start;
    }
}
