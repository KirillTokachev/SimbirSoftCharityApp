package trainingJavaPart2.internetshop;

public class Client {

    private Order order;

    public void book(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void showOrder() {
        System.out.println("Ваш заказ: ");
        order.showOrder();
    }

    public void pay() {
        if(order.isPayed()) {
            System.out.println("Вы уже оплатили заказ");
        } else {
            order.setPayed(true);
        }
    }

    public void take() {
        if(!order.isPayed()) {
            System.out.println("Вы ещё не оплатили товар");
        } else if(!order.isRegister()) {
            System.out.println("Ваша заявка ещё не обработана");
        } else {
            System.out.println("Спасибо за покупку!");
        }
    }


}
