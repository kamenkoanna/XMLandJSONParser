package pattern.composite;

import pattern.visitor.Visitor;

public interface Item{
    int getPrice();
    void accept(Visitor v);
    Item clone();
}
