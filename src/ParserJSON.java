import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParserJSON  extends AbstractParser {

    @Override
    public Shelf shelfReturn(String filePath) {
        Shelf products = new Shelf();

        try {

            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject ecomarket = (JSONObject) jsonObject.get("ecomarket");

            JSONArray product = (JSONArray) ecomarket.get("product");

            for (int i = 0; i < product.size(); i++) {
                product.get(i);
            }
            Iterator i = product.iterator();


            while (i.hasNext()) {

                JSONObject innerObj = (JSONObject) i.next();
                Product product1 = new Product();
                product1.setCategory((String) innerObj.get("-category"));
                product1.setId((String) innerObj.get("id"));
                product1.setFlavour((String) innerObj.get("flavour"));
                product1.setCountry((String) innerObj.get("country"));
                product1.setCost((String) innerObj.get("cost"));

                products.add(product1);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return products;
    }
}
