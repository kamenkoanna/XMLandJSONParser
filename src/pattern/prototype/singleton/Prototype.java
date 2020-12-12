package pattern.prototype.singleton;

import pattern.composite.Item;

import java.util.HashMap;

public class Prototype implements Cloneable{
    private final HashMap<String, Item>  prototypes = new HashMap<>();
    private static Prototype singleton;
    private static boolean created = false;

    private Prototype(){


    }
    public static Prototype create(){
        if(!created){
            singleton = new Prototype();
            created = true;
        }
        return singleton;
    }
    public void add(String key, Item item){
        prototypes.put(key,item);
    }
    public Item clone(String key){
        return prototypes.get(key).clone();
    }
}
