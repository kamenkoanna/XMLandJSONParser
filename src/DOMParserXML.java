import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DOMParserXML extends AbstractParser {

        public Ecomarket EcomarketReturn(String filePath){
        Ecomarket ecomarket = new Ecomarket();
        Product product = new Product();
        try {

            //File fXmlFile = new File("products.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(filePath);

            doc.getDocumentElement().normalize();

            //doc.getDocumentElement().getNodeName();

            NodeList nList = doc.getElementsByTagName("product");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                //nNode.getNodeName();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    product.setCategory(eElement.getAttribute("category"));
                    product.setId(eElement.getElementsByTagName("id").item(0).getTextContent());
                    product.setFlavour(eElement.getElementsByTagName("flavour").item(0).getTextContent());
                    product.setCountry(eElement.getElementsByTagName("country").item(0).getTextContent());
                    product.setCost(eElement.getElementsByTagName("cost").item(0).getTextContent());
                    ecomarket.add(product);
                    product = new Product();
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ecomarket;
    }
}