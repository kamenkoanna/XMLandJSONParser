import javax.xml.stream.XMLStreamException;
import java.io.IOException;

enum XML_STYLE{

    STAX,
    DOM
}

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        String fileName = "products.xml";
        Object parsik = ManagerParser.manage(fileName, XML_STYLE.DOM);
        Ecomarket ecomarket = ((AbstractParser)parsik).EcomarketReturn(fileName);
        Display.show(ecomarket);
    }
}