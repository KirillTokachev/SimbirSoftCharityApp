package trainingJavaPart2.internetshop;

import java.util.ArrayList;

public class Order {

    private ArrayList<Product> orderlist = new ArrayList<Product>();
    private boolean payed = false;
    private boolean register = false;

    public void addProductToOrder(ArrayList<Product> orderslist) {
        this.orderlist = orderslist;
    }

    public void addProductToOrder(Product product) {
        orderlist.add(product);
    }

    public void showOrder() {
        for (Product e: orderlist) {
            System.out.println (e);
        }
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean s) {
        payed = s;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean s) {
        register = s;
    }

}
