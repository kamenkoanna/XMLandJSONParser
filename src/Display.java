import pattern.composite.Product;
import pattern.composite.Shelf;

public class Display {
    public static void show (Product p){
        System.out.println(p);
    }

    public static void show(Shelf shelf){
        shelf.getChildren().forEach(System.out::println);
    }
}
