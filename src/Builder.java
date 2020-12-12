public class Builder {
    private Shelf items;
    private Builder parent;

    public Builder()
    {
        items = new Shelf();
    }

    public Builder(String name)
    {
        items = new Shelf();
        items.setCategory(name);
    }

    public void setCategory(String name){
        items.setCategory(name);
    }

    public void setParent(Builder parent){
        this.parent = parent;
    }

    public Builder item(Item item){
        items.add(item);
        return this;
    }
    public Builder startShelf(String name){
        Builder builder = new Builder();
        builder.setParent(this);
        builder.setCategory(name);
        return builder;
    }
    public Builder endShelf(){
        parent.add(items);
        return parent;
    }
    public Shelf getItems(){
        return items;
    }
    public Builder add(Item item){
        items.add(item);
        return this;
    }
}
