package trainingJava.Internetshop;

import java.util.ArrayList;

public class Administrator {

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Client> blackclients = new ArrayList<Client>();

    public void registerOrder(Client client) {
        if (client.getOrder().isPayment()) {
            client.getOrder().setRegister(true);
        } else {
            blackclients.add(client);
        }
    }

    public void createNewProduct(String name, int price) {
        products.add(new Product(name,price));
    }

}
