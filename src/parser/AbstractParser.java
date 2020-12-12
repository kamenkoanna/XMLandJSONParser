package parser;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import pattern.composite.Shelf;

public abstract class AbstractParser {
    abstract public Shelf shelfReturn(String filePath) throws IOException, XMLStreamException;
}

