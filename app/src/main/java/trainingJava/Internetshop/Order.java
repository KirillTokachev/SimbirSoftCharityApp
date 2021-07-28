package trainingJava.Internetshop;

import java.util.ArrayList;

public class Order {

    private ArrayList<Product> orderlist = new ArrayList<Product>();
    private boolean payment = false;
    private boolean register = false;


    public void addProdToOrder(ArrayList<Product> orderlist) {
        this.orderlist = orderlist;
    }


    public void addProdToOrder(Product product) {
        orderlist.add(product);
    }


    public void showOrder() {
        for (Product e: orderlist) {
            System.out.println (e);
        }
    }


    public boolean isPayment() {
        return payment;
    }


    public void setPayment(boolean s) {
        payment = s;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean s) {
        register = s;
    }

}
