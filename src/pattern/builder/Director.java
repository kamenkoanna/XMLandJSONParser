package pattern.builder;

import pattern.builder.Builder;
import pattern.composite.Product;
import pattern.composite.Shelf;

public class Director {

    public Shelf cake(){
        return new Builder().
                        startShelf("Cream").
                            item(cream()).
                        endShelf().
                        startShelf("Biscuit").
                            item(new Product("Wheat", "Flour")).
                            item(new Product("Coconut","Butter")).
                        endShelf().
                getItems();

    }

    public Shelf cream(){
        return new Builder().
                        startShelf().
                            item(new Product("Coconut", "Milk")).
                            item(new Product("Honey")).
                        endShelf().
                getItems();
    }


    public Shelf cereals(){
        return new Builder().
                        startShelf("Cereals").
                            item(new Product("Coconut", "Milk")).
                            item(new Product("Granola")).
                        endShelf().
                getItems();
    }

}
