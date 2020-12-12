public class ManagerParser {
    static Object manage(String fileName, XML_STYLE choice){
        String extension = fileName.substring(fileName.lastIndexOf("."));
        switch(extension){
            case ".xml":
                switch(choice) {
                    case STAX:
                        System.out.println("STAX XML Parser");
                        return new STAXParserXML();
                    case DOM:
                        System.out.println("DOM XML Parser");
                        return new DOMParserXML();
                }
            case ".json":
                System.out.println("json:\n");
                return new ParserJSON();
            default:
                throw new UnsupportedOperationException("Неподдерживаемый тип файла");
        }
    }
}