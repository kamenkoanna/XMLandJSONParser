import java.util.ArrayList;

public class Shelf implements Item{
    ArrayList<Item> children = new ArrayList<>();


    ArrayList<Item> getChildren(Item item){
        return children;
    }

    void add(){

    }

    void remove(Item item){
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (Item item : children){
            price += item.getPrice();
        }
        return price;
    }
}
