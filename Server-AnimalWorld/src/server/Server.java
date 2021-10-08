package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    private boolean isStart = false;
    private static ServerSocket ss = null;
    ArrayList<ServerThread> treds = new ArrayList<>();

    @Override
    public void run() {

        isStart = true;

        try {
            System.out.println(isStart);
            while (isStart) {
                java.net.Socket s = ss.accept();

                ServerThread sThread = new ServerThread(s);
                Thread tr = new Thread(sThread);
                treds.add(sThread);
                tr.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void startServer(int port) {

        try {
            ss = new ServerSocket(port);

            Server server = new Server();
            Thread tr = new Thread(server);
            tr.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void stopServer() {
        try {
            for (ServerThread st : treds) {
                st.getS().close();
            }
            ss.close();
            isStart = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }
}
