package controller;

import client.*;
import gui.*;
import model.*;
import java.util.HashMap;

public class GeneralController {

    public static Client client;
    public static ClientForm cf;
    public static ClientFormListener cfl;
    public static ServerRequest serverRequest;
    private static boolean newCommand;

    public static void connectClient(int port) throws Exception {
        try {
            client.connectClient(port);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Ошибка подключения к серверу с портом " + port);
        }
    }

    public static boolean disconnectClient() {
        try{
            if(client.isConnect())
                client.disconnectClient();
            return true;
        }
        catch (Exception ex){
            cf.getTfLog().setText(ex.getMessage());
            return false;
        }
    }

    public static boolean exitClient(){
        try{
            if(client.isConnect())
                client.disconnectClient();
            return true;
        }
        catch (Exception ex){
            cf.getTfLog().setText(ex.getMessage());
            return false;
        }
    }

    public static void getResponceFromServer(ServerResponce sr){

        switch (sr.getCommand()){
            case 1: {
                if(client.isConnect())
                    cf.putAllAnimals("Соединение с сервером создано.");
                break;
            }
            case 2: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += " Id=" + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putAllAnimals(data);
                break;
            }
            case 3: {

                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += " IId=" + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putAllAnimals(data);
                break;
            }
            case 4: {

                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += "Id=" + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putAllAnimals(data);
                break;
            }
            case 5: {

                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += " Id= " + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putAllAnimals(data);
                break;
            }
            case 6: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                cf.getChType().removeAll();
                for (Integer id : entities.keySet()) {
                    if(entities.get(id).getClass()==Predator.class)
                        cf.putAllTypes("Predator");
                    else if(entities.get(id).getClass()==Herbivore.class)
                        cf.putAllTypes("Herbivore");
                    else if(entities.get(id).getClass()==Grass.class)
                        cf.putAllTypes("Grass");
                }
                break;
            }
            case 7: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                cf.getChEat().removeAll();
                for (Integer id : entities.keySet()) {
                    cf.putAllEaters(id + " " + (entities.get(id)).getInfo());
                }
                break;
            }
            case 8: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += " Id=" + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putReact(data);
                break;
            }
            case 9: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                cf.getChRemove().removeAll();
                for (Integer id : entities.keySet()) {
                    if(entities.get(id).getClass()==Predator.class)
                        cf.getChRemove().addItem("Predator");
                    else if(entities.get(id).getClass()==Herbivore.class)
                        cf.getChRemove().addItem("Herbivore");
                    else if(entities.get(id).getClass()==Grass.class)
                        cf.getChRemove().addItem("Grass");
                }
                break;
            }
            case 10: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += " Id=" + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putReact(data);
                break;
            }
            case 11: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                cf.getChIdRemove().removeAll();
                for (Integer id : entities.keySet()) {
                    cf.getChIdRemove().addItem(id.toString());
                }
                break;
            }
            case 12: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                cf.getChWhatEat().removeAll();
                for (Integer id : entities.keySet()) {
                    cf.getChWhatEat().addItem(id + " " + (entities.get(id)).getInfo());
                }
                break;
            }
            case 13: {
                HashMap<Integer, Food> entities = (HashMap<Integer, Food>) sr.getArgument();
                String data = "";
                for (Integer id : entities.keySet()) {
                    data += " Id=" + id + " - " + (entities.get(id)).getAllInfo() + "\n";
                }
                cf.putReact(data);
                break;
            }
        }
    }

    public static void putRequestToServer(Integer command, HashMap<Integer,Object> h){

        switch (command){
            case 1: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 2: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 3: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 4: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 5: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 6: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 7: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 8: {
                serverRequest=new ServerRequest(command,h);
                break;
            }
            case 9: {
                serverRequest=new ServerRequest(command,null);
                break;
            }
            case 10: {
                serverRequest=new ServerRequest(command,h);
                break;
            }
            case 11: {
                serverRequest=new ServerRequest(command,h);
                break;
            }
            case 12: {
                serverRequest=new ServerRequest(command,h);
                break;
            }
            case 13: {
                serverRequest=new ServerRequest(command,h);
                break;
            }
        }
        client.setNewCommand(true);
    }


    public static void startApp(){
        try{
            client=new Client();
            cf=new ClientForm();
            cfl=new ClientFormListener(cf);
        }
        catch(Exception ex){
            cf.getTfLog().setText(ex.getMessage());
        }
    }

    public static ServerRequest getServerRequest() {
        return serverRequest;
    }

    public static void setServerRequest(ServerRequest serverRequest) {
        GeneralController.serverRequest = serverRequest;
    }
    public static boolean isNewCommand() {
        return newCommand;
    }

    public static void setNewCommand(boolean newCommand) {
        GeneralController.newCommand = newCommand;
    }
}
