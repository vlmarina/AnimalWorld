package controller;

import gui.ClientForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

public class ClientFormListener implements ActionListener, ItemListener {

    private ClientForm cf;

    public ClientFormListener(ClientForm cf) {
        this.cf = cf;
        this.cf.getbExit().addActionListener(this);
        this.cf.getbStop().addActionListener(this);
        this.cf.getbStart().addActionListener(this);
        this.cf.getTfPort().addActionListener(this);

        this.cf.getViewAll().addItemListener(this);
        this.cf.getViewPred().addItemListener(this);
        this.cf.getViewHerb().addItemListener(this);
        this.cf.getViewGrass().addItemListener(this);

        this.cf.getChEat().addItemListener(this);
        this.cf.getChRemove().addItemListener(this);
        this.cf.getChEat().addItemListener(this);

        this.cf.getbCreate().addActionListener(this);
        this.cf.getbTypeLoad().addActionListener(this);
        this.cf.getbEatLoad().addActionListener(this);
        this.cf.getbRemoveLoad().addActionListener(this);
        this.cf.getbRemove().addActionListener(this);
        this.cf.getbEat().addActionListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == cf.getViewAll()) {
            GeneralController.putRequestToServer(2, null);
        }
        if (e.getSource() == cf.getViewPred()) {
            GeneralController.putRequestToServer(3, null);
        }
        if (e.getSource() == cf.getViewHerb()) {
            GeneralController.putRequestToServer(4, null);
        }
        if (e.getSource() == cf.getViewGrass()) {
            GeneralController.putRequestToServer(5, null);
        }
        if (e.getSource() == cf.getChRemove()) {
            try {
                String type = cf.getChRemove().getSelectedItem();
                if (type.isBlank())
                    throw new IllegalAccessException("Ошибка. Выберите тип живого сущесва.");

                HashMap<Integer, Object> hash = new HashMap<>();
                hash.put(0, type);
                GeneralController.putRequestToServer(11, hash);
            } catch (Exception ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }
        if (e.getSource() == cf.getChEat()) {
            try {
                String type = cf.getChEat().getSelectedItem();
                if (type.isBlank())
                    throw new IllegalAccessException("Ошибка. Выберите сущесво.");

                if (type.contains(" ")) {
                    type = type.substring(0, type.indexOf(" "));

                    HashMap<Integer, Object> hash = new HashMap<>();
                    hash.put(0, type);
                    GeneralController.putRequestToServer(12, hash);
                }
            } catch (IllegalAccessException ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }
    }
            @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cf.getbStart()) {
            String sPort = cf.getTfPort().getText();
            try {
                if (sPort.isBlank()) {
                    throw new IllegalAccessException("Ошибка. Введите значение порта.");
                }
                int iPort;
                try {
                    iPort = Integer.parseInt(sPort);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    throw new IllegalAccessException("Ошибка преобразования порта.");
                }
                GeneralController.connectClient(iPort);
                cf.connectServer();
            } catch (Exception ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == cf.getbStop()) {
            try {
                if (GeneralController.disconnectClient()) {
                    cf.disconnectClient();
                    cf.getTfLog().setText("Клиент отключен от сервера.");
                } else {
                    cf.getTfLog().setText("Ошибка отключения от сервера.");
                }
            } catch (NumberFormatException ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == cf.getbExit()) {
            try {
                if (GeneralController.exitClient()) {
                    cf.exitClient();
                } else {
                    cf.getTfLog().setText("Сервер не существует или отсутствуют разрешения.");
                }
            } catch (NumberFormatException ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == cf.getbTypeLoad()) {
            try {
                GeneralController.putRequestToServer(6, null);
            } catch (NumberFormatException ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == cf.getbEatLoad()) {
            try {
                GeneralController.putRequestToServer(7, null);
            } catch (NumberFormatException ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if(e.getSource() == cf.getbCreate()){
            try {
                String s=cf.getTfName().getText();
                if(s.isBlank())
                    throw new IllegalAccessException("Ошибка. Введите имя живого сущесва.");

                String m=cf.getTfMass().getText();
                if(m.isBlank())
                    throw new IllegalAccessException("Ошибка. Введите массу живого сущесва.");
                int ma;
                try{
                    ma = Integer.parseInt(m);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    throw new IllegalAccessException("Ошибка преобразования массы.");
                }

                String type=cf.getChType().getSelectedItem();
                if(type.isBlank())
                    throw new IllegalAccessException("Ошибка. Выберите тип живого сущесва.");

                HashMap<Integer,Object> hash=new HashMap<>();
                hash.put(0,type);
                hash.put(1,s);
                hash.put(2,ma);

                GeneralController.putRequestToServer(8,hash);
            } catch (Exception ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == cf.getbRemoveLoad()) {
            try {
                GeneralController.putRequestToServer(9, null);
            } catch (NumberFormatException ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

        if (e.getSource() == cf.getbRemove()) {
            try {
                String type=cf.getChRemove().getSelectedItem();
                if(type.isBlank())
                    throw new IllegalAccessException("Ошибка. Выберите тип живого сущесва.");

                String m=cf.getChIdRemove().getSelectedItem();
                if(m.isBlank())
                    throw new IllegalAccessException("Ошибка. Введите массу живого сущесва.");
                int id;
                try{
                    id = Integer.parseInt(m);
                } catch (NumberFormatException ex) {
                    throw new IllegalAccessException("Ошибка преобразования массы.");
                }

                HashMap<Integer,Object> hash=new HashMap<>();
                hash.put(0,type);
                hash.put(1,id);

                GeneralController.putRequestToServer(10, hash);
            } catch (Exception ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }
        if (e.getSource() == cf.getbEat()) {
            try {

                String ide=cf.getChEat().getSelectedItem();
                if(ide.isBlank())
                    throw new IllegalAccessException("Ошибка. Выберите тип живого сущесва.");

                String id = cf.getChWhatEat().getSelectedItem();
                if (id.isBlank())
                    throw new IllegalAccessException("Ошибка. Выберите сущесво.");

                if (ide.contains(" "))
                    ide = ide.substring(0, ide.indexOf(" "));
                if (id.contains(" "))
                        id = id.substring(0, id.indexOf(" "));

                    HashMap<Integer, Object> hash = new HashMap<>();
                    hash.put(0, ide);
                    hash.put(1,id);

                GeneralController.putRequestToServer(13, hash);
            } catch (Exception ex) {
                cf.getTfLog().setText(ex.getMessage());
            }
        }

    }
}
