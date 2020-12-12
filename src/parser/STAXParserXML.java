package parser;

import pattern.builder.Builder;
import pattern.composite.Product;
import pattern.composite.Shelf;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class STAXParserXML extends AbstractParser {

    Builder builder;
    Product product;

    public static final String ELEMENT_SHELF = "ecomarket";
    public static final String ELEMENT_PRODUCT = "product";
    private static final String ELEMENT_ID = "id";
    public static final String ELEMENT_FLAVOUR = "flavour";
    public static final String ELEMENT_COUNTRY = "country";
    public static final String ELEMENT_COST = "cost";

    @Override
    public Shelf shelfReturn(String filePath) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));

        while (reader.hasNext()) {
            builder = new Builder();
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case ELEMENT_SHELF -> builder.startShelf();
                    case ELEMENT_PRODUCT -> product = new Product();
                    case ELEMENT_ID -> {
                        nextEvent = reader.nextEvent();
                        product.setId(nextEvent.asCharacters().getData());
                    }
                    case ELEMENT_FLAVOUR -> {
                        nextEvent = reader.nextEvent();
                        product.setFlavour(nextEvent.asCharacters().getData());
                    }
                    case ELEMENT_COUNTRY -> {
                        nextEvent = reader.nextEvent();
                        product.setCountry(nextEvent.asCharacters().getData());
                    }
                    case ELEMENT_COST -> {
                        nextEvent = reader.nextEvent();
                        product.setCost(nextEvent.asCharacters().getData());
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + startElement.getName().getLocalPart());
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                switch (endElement.getName().getLocalPart()) {
                    case ELEMENT_PRODUCT -> builder.item(product);
                    case ELEMENT_SHELF -> builder.endShelf();
                    default -> throw new IllegalStateException("Unexpected value: " + endElement.getName().getLocalPart());
                }
            }
        }

        return builder.getItems();
    }
}

