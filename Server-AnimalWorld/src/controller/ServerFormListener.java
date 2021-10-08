package controller;

import gui.ServerForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerFormListener implements ActionListener {

    private ServerForm sf;

    public ServerFormListener(ServerForm sf) {
        this.sf = sf;

        this.sf.getbExit().addActionListener(this);
        this.sf.getbStop().addActionListener(this);
        this.sf.getbStart().addActionListener(this);
        this.sf.getTfPort().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sf.getbStart()) {
            String sPort = sf.getTfPort().getText();
            try {

                if (sPort.isBlank()) {
                    throw new IllegalAccessException("Ошибка. Введите значение порта.");
                }
                int iPort;
                try {
                    iPort = Integer.parseInt(sPort);
                } catch (NumberFormatException ex) {
                    sf.getTfLog().setText(ex.getMessage());
                    throw new IllegalAccessException("Ошибка преобразования порта.");
                }
                sf.startServer();
                GeneralController.startServer(iPort);
            } catch (Exception ex) {
                sf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == sf.getbStop()) {
            try {
                GeneralController.stopServer();
                sf.stopServer();
                sf.getTfLog().setText("Сервер остановлен.");
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == sf.getbExit()) {
            try {

                if (GeneralController.exitServer()) {
                    sf.exitServer();
                } else {
                    sf.getTfLog().setText("Сервер не существует или отсутствуют разрешения.");
                }
            } catch (NumberFormatException ex) {
                sf.getTfLog().setText(ex.getMessage());
            }
        }
    }
}
