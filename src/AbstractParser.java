import javax.xml.stream.XMLStreamException;
import java.io.IOException;

abstract class AbstractParser {
    abstract public Ecomarket EcomarketReturn(String filePath) throws IOException, XMLStreamException;
}

