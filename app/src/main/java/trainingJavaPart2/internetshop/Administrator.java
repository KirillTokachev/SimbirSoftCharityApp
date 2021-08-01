package trainingJavaPart2.internetshop;

import java.util.ArrayList;

public class Administrator {

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Client> blackListClients = new ArrayList<Client>();

    public void orderRegistration(Client client) {
        if (client.getOrder().isPayed()) {
            client.getOrder().setRegister(true);
        } else {
            blackListClients.add(client);
        }
    }
    public void createNewProduct(String name, int price) {
        products.add(new Product(name,price));
    }

}
