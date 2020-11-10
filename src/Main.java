import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        FileParser parsik = new FileParser();
        parsik.parse();
    }
}