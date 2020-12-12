import pattern.builder.Director;
import pattern.composite.Item;
import pattern.composite.Shelf;
import parser.AbstractParser;
import parser.ManagerParser;
import parser.XML_STYLE;
import pattern.prototype.singleton.Prototype;
import pattern.visitor.VisitorCreatesUniqueCategoryList;
import pattern.visitor.VisitorSearchesForCategory;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {

        //get ready

        Director make = new Director();
        Prototype recipes = Prototype.create();
        VisitorCreatesUniqueCategoryList vUniqList = new VisitorCreatesUniqueCategoryList();
        VisitorSearchesForCategory vCategory = new VisitorSearchesForCategory();

        recipes.add("cake", make.cake());
        recipes.add("cereals", make.cereals());

        //start

        System.out.println("\n[ A client ]\n I want to cook a vegan cake and cereals for my breakfast, mmmm.. ");

        Item cake = recipes.clone("cake");
        Item cereals = recipes.clone("cereals");

        cake.accept(vUniqList);
        ArrayList<String> cakeIngr = vUniqList.getCategories();
        System.out.println("\n[ A client ] \nDo the vegan store has all the ingredients");

        String fileName = "products.xml";
        Object parserManager = ManagerParser.manage(fileName, XML_STYLE.DOM);
        Shelf store = ((AbstractParser)parserManager).shelfReturn(fileName);
        System.out.println("\n[ Goods in a vegan store ]");
        Display.show(store);

        boolean notFound = false;
        for (String c: cakeIngr){
            vCategory.setCategory(c);
            store.accept(vCategory);
            notFound = !vCategory.isFound();
            if(notFound)
                break;
        }
        if(notFound)
            System.out.println("It doesn't have all needed ingredients for the cake.");
        else
            System.out.println("It has all the ingredients for the cake. Nice!");

    }
}