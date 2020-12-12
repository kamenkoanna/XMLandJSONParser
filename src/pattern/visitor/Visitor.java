package pattern.visitor;

import pattern.composite.Product;
import pattern.composite.Shelf;

public interface Visitor {
    void visit(Product p);
    void visit(Shelf s);
}
