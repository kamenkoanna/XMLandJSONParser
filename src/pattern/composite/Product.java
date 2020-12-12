package pattern.composite;

import pattern.visitor.Visitor;

public class Product implements Item{
    private static int staticId = 0;
    private String id;
    private String flavour;
    private String country;
    private String cost;
    private String category;

    public Product() {
        id = String.valueOf(staticId++);
        this.flavour = null;
        this.country = null;
        this.cost = null;
        this.category = null;
    }

    public Product(String category) {
        id = String.valueOf(staticId++);
        this.category = category;
        this.flavour = null;
        this.country = null;
        this.cost = null;
        this.category = null;
    }

    public Product(String flavour, String category) {
        id = String.valueOf(staticId++);
        this.category = category;
        this.flavour = flavour;
        this.country = null;
        this.cost = null;
        this.category = null;
    }

    public Product(String flavour, String country, String cost, String category) {
        id = String.valueOf(staticId++);
        this.flavour = flavour;
        this.country = country;
        this.cost = cost;
        this.category = category;
    }

    public Product(String id, String flavour, String country, String cost, String category) {
        this.id = id;
        this.flavour = flavour;
        this.country = country;
        this.cost = cost;
        this.category = category;
    }


    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        if(flavour != null)
            str.append(flavour).append(" ");
        if(category != null)
            str.append(category);
        if(country != null)
            str.append(", ").append(country);
        if(cost != null)
            str.append("\t\t").append(cost);
        str.append("\n");

        return str.toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int getPrice() {
        return Integer.parseInt(cost);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Item clone() {
        return new Product(id, flavour, country, cost, category);
    }
}
