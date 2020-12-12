public class Product implements Item{
    private String id;
    private String flavour;
    private String country;
    private String cost;
    private String category;

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", flavour='" + flavour + '\'' +
                ", country='" + country + '\'' +
                ", cost=" + cost +
                '}';
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
}
