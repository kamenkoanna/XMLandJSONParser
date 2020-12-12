import java.util.ArrayList;
import java.util.Objects;

public class Shelf implements Item{
    ArrayList<Item> children = new ArrayList<>();
    String category;

    ArrayList<Item> getChildren(){
        return children;
    }

    void add(Item item){
        children.add(item);
    }

    void remove(Item item){
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

    public void setCategory(String category){
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(Objects.requireNonNullElse(category, "<No name shelf>"));
        str.append(" ").append(getPrice()).append("\n");

        for(Item item: children){
            str.append("\t").append(item.toString());
        }
        return str.toString();
    }
}
