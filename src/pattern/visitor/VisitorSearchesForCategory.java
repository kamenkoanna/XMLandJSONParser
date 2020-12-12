package pattern.visitor;

import pattern.composite.Item;
import pattern.composite.Product;
import pattern.composite.Shelf;

public class VisitorSearchesForCategory implements Visitor{
    private String category;
    private boolean found;

    public VisitorSearchesForCategory(){
        found = false;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void visit(Shelf s) {
        for(Item item: s.getChildren()) {
            if(found) {
                break;
            }
            if( s.getCategory().equals(category) ) {
                found = true;
            }
            s.accept(this);
        }
    }

    @Override
    public void visit(Product p) {
        if( p.getCategory().equals(category) )
            found = true;
    }
}
