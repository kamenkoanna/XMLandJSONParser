public class Directory {

    public Builder makeCake(){
        return new Builder("Cake").
                add(makeCream().getItems()).
                startShelf("Biscuit").
                    item(new Product("Wheat", "Flour")).
                    item(new Product("Coconut","Butter")).
                endShelf();
    }
    public Builder makeCream(){
        return new Builder().
                startShelf("Cream").
                    item(new Product("Coconut", "Milk")).
                    item(new Product("Honey")).
                endShelf();
    }


}
