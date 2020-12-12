import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class STAXParserXML extends AbstractParser {

    Shelf shelf = new Shelf();

    public static final String ELEMENT_PRODUCT = "product";
    private static final String ELEMENT_ID = "id";
    public static final String ELEMENT_FLAVOUR = "flavour";
    public static final String ELEMENT_COUNTRY = "country";
    public static final String ELEMENT_COST = "cost";
    private final XMLInputFactory factory = XMLInputFactory.newInstance();

    @Override
    public Shelf shelfReturn(String filePath) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        //String url = "products.xml";
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));
        Product product = new Product();

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case ELEMENT_PRODUCT -> {
                        Attribute category = startElement.getAttributeByName(new QName("category"));
                        if (category != null) {
                            product.setCategory(category.getValue());
                        }
                    }
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
                }
            } if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("product")) {
                    shelf.add(product);
                    product = new Product();
                }
            }
        }
        return shelf;
    }
}

