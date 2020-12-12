package pattern.visitor;

import pattern.composite.Item;
import pattern.composite.Product;
import pattern.composite.Shelf;

import java.util.ArrayList;

public class VisitorCreatesUniqueCategoryList implements Visitor{
    ArrayList<String> categories;

    public VisitorCreatesUniqueCategoryList() {
        categories = new ArrayList<>();
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    @Override
    public void visit(Shelf s) {
        for(Item item: s.getChildren()) {
            String c = s.getCategory();

            if( !categories.contains(c) )
                categories.add(c);
            s.accept(this);
        }
    }

    @Override
    public void visit(Product p) {
        String c = p.getCategory();
        if( !categories.contains(c) )
            categories.add(c);
    }
}
