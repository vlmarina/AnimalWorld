package controller;

import gui.ServerForm;
import model.*;
import server.*;
import storage.Storage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class GeneralController {

    public static Server server;
    public static Storage storage;
    public static ServerForm sf;
    public static ServerFormListener sfl;
    public static ServerResponce sr;

    public static ServerRequest serverRequest;

    public static void startServer(int port) throws Exception {
        try {
            server.startServer(port);
        } catch (Exception ex) {
            sf.getTfLog().setText(ex.getMessage());
            throw new Exception("Ошибка запуска сервера на порту " + port);
        }
    }

    public static boolean stopServer() {
        try {
            server.stopServer();
            return true;
        } catch (Exception ex) {
            sf.getTfLog().setText(ex.getMessage());
            return false;
        }
    }

    public static boolean exitServer() {
        try {
            if (server.isStart())
                server.stopServer();
            storage.writeFile();
            return true;
        } catch (Exception ex) {
            sf.getTfLog().setText(ex.getMessage());
            return false;
        }
    }

    public static void startApp() {
        try {
            storage = Storage.getInstance();

            server = new Server();
            sf = new ServerForm();
            sfl = new ServerFormListener(sf);
        } catch (Exception ex) {
            sf.getTfLog().setText(ex.getMessage());
        }
    }

    public static void getResponceFromServer(ServerRequest sReq) {
        Integer i = sReq.getCommand();
        switch (i) {
            case 1: {
                sr = new ServerResponce(i, null);
                break;
            }
            case 2: {
                HashMap<Integer, Food> entities = storage.getAll();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 3: {
                HashMap<Integer, Food> entities = storage.getEntitiesPred();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 4: {
                HashMap<Integer, Food> entities = storage.getEntitiesHerb();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 5: {
                HashMap<Integer, Food> entities = storage.getEntitiesGrass();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 6: {
                HashMap<Integer, Food> entities = storage.findTypes();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 7: {
                HashMap<Integer, Food> entities = storage.findAnimals();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 8: {
                HashMap<Integer, Food> entities = new HashMap<>();
                HashMap<Integer, Object> map = new HashMap<>();
                map.putAll((HashMap<Integer, Object>) sReq.getArgument());

                try {

                    if (map.get(0).equals("Predator")) {
                        storage.create(new Predator((String) map.get(1), (Integer) map.get(2)));
                        entities = storage.getEntitiesPred();
                    }
                    if (map.get(0).equals("Herbivore")) {
                        storage.create(new Herbivore((String) map.get(1), (Integer) map.get(2)));
                        entities = storage.getEntitiesHerb();
                    }
                    if (map.get(0).equals("Grass")) {
                        storage.create(new Grass((String) map.get(1), (Integer) map.get(2)));
                        entities = storage.getEntitiesGrass();
                    }

                    sr = new ServerResponce(i, entities);
                    break;
                } catch (Exception ex) {
                    sf.getTfLog().setText(ex.getMessage());
                }
            }
            case 9: {
                HashMap<Integer, Food> entities = storage.findTypes();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 10: {
                HashMap<Integer, Food> entities = new HashMap<>();
                HashMap<Integer, Object> map = new HashMap<>();
                map.putAll((HashMap<Integer, Object>) sReq.getArgument());
                try {
                    if (map.get(0).equals("Predator")) {
                        Predator p = (Predator) storage.findPred((Integer) map.get(1));
                        p.kill();
                        storage.update((Integer) map.get(1), p);
                        entities = storage.getEntitiesPred();
                    }
                    if (map.get(0).equals("Herbivore")) {
                        Herbivore h = (Herbivore) storage.findHerb((Integer) map.get(1));
                        h.kill();
                        storage.update((Integer) map.get(1), h);
                        entities = storage.getEntitiesHerb();
                    }
                    if (map.get(0).equals("Grass")) {
                        Grass g = (Grass) storage.findGrass((Integer) map.get(1));
                        g.setM(0);
                        storage.update((Integer) map.get(1), g);
                        entities = storage.getEntitiesGrass();
                    }
                    sr = new ServerResponce(i, entities);
                    break;
                } catch (Exception ex) {
                    sf.getTfLog().setText(ex.getMessage());
                }
            }
            case 11: {
                HashMap<Integer, Food> entities = new HashMap<>();
                HashMap<Integer, Object> map = new HashMap<>();
                map.putAll((HashMap<Integer, Object>) sReq.getArgument());

                try {
                    if (map.get(0).equals("Predator")) {
                        entities = storage.getEntitiesPred();
                    }
                    if (map.get(0).equals("Herbivore")) {
                        entities = storage.getEntitiesHerb();
                    }
                    if (map.get(0).equals("Grass")) {
                        entities = storage.getEntitiesGrass();
                    }
                    sr = new ServerResponce(i, entities);
                    break;
                } catch (Exception ex) {
                    sf.getTfLog().setText(ex.getMessage());
                }
            }
            case 12: {
                HashMap<Integer, Food> entities = storage.getAll();
                sr = new ServerResponce(i, entities);
                break;
            }
            case 13: {
                HashMap<Integer, Food> entities = new HashMap<>();
                HashMap<Integer, Object> map = new HashMap<>();
                map.putAll((HashMap<Integer, Object>) sReq.getArgument());
                try {
                    int id=Integer.parseInt((String) map.get(0));
                    int id2=Integer.parseInt((String) map.get(1));

                    if(storage.findFoodById(id).eat(storage.findFoodById(id2)))
                    {
                        entities = storage.getAll();
                        sr = new ServerResponce(i, entities);
                        break;
                    }

                } catch (Exception ex) {
                    sf.getTfLog().setText(ex.getMessage());
                }
            }
        }
    }

    public static void putRequestToServer(ServerRequest sr) {

        switch (sr.getCommand()) {
            case 1: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 2: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 3: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 4: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 5: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 6: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 7: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 8: {
                serverRequest = new ServerRequest(sr.getCommand(), (HashMap<Integer, Object>) sr.getArgument());
                break;
            }
            case 9: {
                serverRequest = new ServerRequest(sr.getCommand(), null);
                break;
            }
            case 10: {
                serverRequest = new ServerRequest(sr.getCommand(), (HashMap<Integer, Object>) sr.getArgument());
                break;
            }
            case 11: {
                serverRequest = new ServerRequest(sr.getCommand(), (HashMap<Integer, Object>) sr.getArgument());
                break;
            }
            case 12: {
                serverRequest = new ServerRequest(sr.getCommand(), (HashMap<Integer, Object>) sr.getArgument());
                break;
            }
            case 13: {
                serverRequest = new ServerRequest(sr.getCommand(), (HashMap<Integer, Object>) sr.getArgument());
                break;
            }
        }
    }

    public static ServerResponce getSr() {
        return sr;
    }

    public static void setSr(ServerResponce sr) {
        GeneralController.sr = sr;
    }

    public static ServerRequest getServerRequest() {
        return serverRequest;
    }

    public static void setServerRequest(ServerRequest serverRequest) {
        GeneralController.serverRequest = serverRequest;
    }
}
