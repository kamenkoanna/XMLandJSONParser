import javax.xml.stream.XMLStreamException;
import java.io.IOException;

abstract class AbstractParser {
    abstract public Shelf shelfReturn(String filePath) throws IOException, XMLStreamException;
}

