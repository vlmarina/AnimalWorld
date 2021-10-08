package storage;

import model.*;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class Storage implements Serializable {

    static private Storage storage;
    static String filename = "Animals.dat";

    private HashMap<Integer, Food> entitiesPred = new HashMap<>();
    private HashMap<Integer, Food> entitiesHerb = new HashMap<>();
    private HashMap<Integer, Food> entitiesGrass = new HashMap<>();

    static private int count;

    private Storage() {
    }

    public static Storage getInstance() throws Exception {

        if (storage == null) {
            storage = new Storage();
        }
        storage.loadFile();
        return storage;
    }

    public Food create(Food food) {

        if (food instanceof Predator) {
            if (findPred(count) == null) {
                entitiesPred.put(count, food);
                food.setId(count);
                count++;
                return food;
            } else
                return null;
        }
        if (food instanceof Herbivore) {
            if (findHerb(count) == null) {
                entitiesHerb.put(count, food);
                food.setId(count);
                count++;
                return food;
            } else
                return null;
        }
        if (food instanceof Grass) {
            if (findGrass(count) == null) {
                entitiesGrass.put(count, food);
                food.setId(count);
                count++;
                return food;
            } else
                return null;
        } else
            return null;
    }

    public boolean update(Integer id, Food entity) {

        if (entity instanceof Predator) {
            if (entitiesPred.containsKey(id)) {
                entitiesPred.remove(id);
                entitiesPred.put(id, entity);
                return true;
            } else
                return false;
        } else if (entity instanceof Herbivore) {
            if (entitiesHerb.containsKey(id)) {
                entitiesHerb.remove(id);
                entitiesHerb.put(id, entity);
                return true;
            } else
                return false;
        } else if (entity instanceof Grass) {
            if (entitiesGrass.containsKey(id)) {
                entitiesGrass.remove(id);
                entitiesGrass.put(id, entity);
                return true;
            } else
                return false;
        } else
            return false;
    }

    public Food findPred(Integer id) {

        if (entitiesPred.containsKey(id)) {
            return entitiesPred.get(id);
        } else
            return null;
    }

    public Food findHerb(Integer id) {

        if (entitiesHerb.containsKey(id)) {
            return entitiesHerb.get(id);
        } else
            return null;
    }

    public Boolean findPredById(Integer id) {

        if (entitiesPred.containsKey(id)) {
            return true;
        } else
            return false;
    }

    public Boolean findHerbById(Integer id) {

        if (entitiesHerb.containsKey(id)) {
            return true;
        } else
            return true;

    }

    public Boolean findGrassById(Integer id) {

        if (entitiesGrass.containsKey(id)) {
            return true;
        } else
            return false;
    }

    public Animal findFoodById(Integer id) {

        if (entitiesPred.containsKey(id)) {
            return (Animal) entitiesPred.get(id);
        } else if (entitiesHerb.containsKey(id)) {
            return (Animal) entitiesHerb.get(id);
        }
            return null;

    }

        public Food findGrass (Integer id){

            if (entitiesGrass.containsKey(id)) {
                return (Animal) entitiesGrass.get(id);
            } else
                return null;
        }


        public boolean removePred (Integer id){

            if (entitiesPred.containsKey(id)) {
                entitiesPred.remove(id);
                return true;
            } else
                return false;
        }

        public boolean removeHerb (Integer id){

            if (entitiesHerb.containsKey(id)) {
                entitiesHerb.remove(id);
                return true;
            } else
                return false;
        }

        public boolean removeGrass (Integer id){

            if (entitiesGrass.containsKey(id)) {
                entitiesGrass.remove(id);
                return true;
            } else
                return false;
        }

        public Food remove (Integer id, Animal an){
            an.setAlive(false);
            update(id, an);
            return an;
        }

        public HashMap<Integer, Food> findAnimals () {

            HashMap<Integer, Food> animals = new HashMap<>();
            animals.putAll(entitiesPred);
            animals.putAll(entitiesHerb);
            return animals;
        }

        public HashMap<Integer, Food> findTypes () {

            HashMap<Integer, Food> animals = new HashMap<>();
            animals.put(0, new Predator("", 1));
            animals.put(1, new Herbivore("", 1));
            animals.put(2, new Grass("", 1));
            return animals;
        }


        public void writeFile () throws IOException {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fileOut);

            obj.writeObject(storage);
            obj.writeObject(count);

            obj.close();
            fileOut.close();
        }

        public void loadFile () throws Exception {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream oFileIn = new ObjectInputStream(fileIn);

            storage = (Storage) oFileIn.readObject();
            count = (Integer) oFileIn.readObject();

            oFileIn.close();
            fileIn.close();
        }

        public HashMap<Integer, Food> getAll () {

            HashMap<Integer, Food> all = new HashMap<>();

            all.putAll(entitiesPred);
            all.putAll(entitiesHerb);
            all.putAll(entitiesGrass);

            return all;
        }

        public static Set<Integer> getKeys (HashMap < Integer, Food > m){
            return m.keySet();
        }

        public HashMap<Integer, Food> getEntitiesPred () {
            return entitiesPred;
        }

        public HashMap<Integer, Food> getEntitiesHerb () {
            return entitiesHerb;
        }

        public HashMap<Integer, Food> getEntitiesGrass () {
            return entitiesGrass;
        }

        public void setItemsPred (HashMap < Integer, Food > items){
            this.entitiesPred = items;
        }

        public void setItemsHerb (HashMap < Integer, Food > items){
            this.entitiesHerb = items;
        }

        public void setItemsGrass (HashMap < Integer, Food > items){
            this.entitiesGrass = items;
        }

        public static int getCount () {
            return count;
        }

        public static void setCount ( int countP){
            Storage.count = countP;
        }

    }
