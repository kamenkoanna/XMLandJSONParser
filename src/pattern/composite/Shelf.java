package pattern.composite;

import pattern.visitor.Visitor;

import java.util.ArrayList;
import java.util.Objects;

public class Shelf implements Item{
    private ArrayList<Item> children;
    private String category;
    private static final String NO_NAME = "<No name shelf>";

    public Shelf(){
        children = new ArrayList<>();
        category = NO_NAME;
    }

    public Shelf(String category){
        children = new ArrayList<>();
        this.category = category;
    }

    public ArrayList<Item> getChildren(){
        return children;
    }

    public void add(Item item){
        children.add(item);
    }

    public void remove(Item item){
        children.remove(item);
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (Item item : children){
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Item clone() {
        Shelf shelf = new Shelf(category);
        for(Item item: children){
            shelf.add(item.clone());
        }
        return shelf;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(category);
        str.append(" ").append(getPrice()).append("\n");

        for(Item item: children){
            str.append("\t").append(item.toString());
        }
        return str.toString();
    }
}
