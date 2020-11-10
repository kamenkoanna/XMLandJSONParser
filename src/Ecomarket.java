import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Ecomarket {
    private ArrayList<Product> productsList = new ArrayList();

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = (ArrayList<Product>) productsList;
    }

    public void add(Product product) {
        productsList.add(product);
    }
}
