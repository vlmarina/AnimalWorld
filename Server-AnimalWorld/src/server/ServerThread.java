package server;

import controller.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread implements Runnable {

    Socket s;

    public ServerThread(Socket s) {
        this.s=s;
    }

    @Override
    public void run() {

        try {

            GeneralController.setServerRequest(new ServerRequest(0,null));

            while (s.isConnected()) {

                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ServerRequest sr=(ServerRequest) ois.readObject();

                    GeneralController.putRequestToServer(sr);
                    GeneralController.getResponceFromServer(GeneralController.getServerRequest());

                    ObjectOutputStream oob = new ObjectOutputStream(s.getOutputStream());
                    oob.writeObject(GeneralController.getSr());

            }
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }

    public Socket getS() {
        return s;
    }
    public void setS(Socket s) {
        this.s = s;
    }
}
