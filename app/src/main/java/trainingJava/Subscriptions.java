package trainingJava;

import java.util.ArrayList;
import java.util.Comparator;

public class Subscriptions {

    public static void main(String[] args) {

        Subscriber Georgy = new Subscriber(878377688,"Салманов","Георгий","Алексеевич","Москва",505012372,404099943,344,550);
        Subscriber Leonid = new Subscriber(988773222,"Рюкзаков","Леонид","Иванович","Москва",505014232,404087543,544,763);
        Subscriber Vyacheslav = new Subscriber(831231231,"Латников","Вячеслав","Генадьевич","Москва",505067955,404087543,1550);
        Subscriber Dmitryi = new Subscriber(456345352,"Игнатов","Дмитрий","Димитриевич","Москва",505023452,404075123,5250);
        Subscriber Mihail = new Subscriber(234512314,"Михайлов","Михаил","Никитович","Москва",505023467,9550);

        ArrayList<Subscriber> subscribers = new ArrayList();
        subscribers.add(Georgy);
        subscribers.add(Leonid);
        subscribers.add(Vyacheslav);
        subscribers.add(Dmitryi);
        subscribers.add(Mihail);

    }

    public static String toCals(ArrayList<Subscriber> inputList){
        int time = 5000;
        ArrayList<String> output = new ArrayList(inputList.size());

        for(int i = 0; i < inputList.size(); i++){
            if(inputList.get(i).getTimeCals() > time){
                output.add(inputList.get(i).getSurname());
            }
        }
        return "Превышение лимита у следующих абонентов :" + output;
    }

    public static String toCalsIntercity(ArrayList<Subscriber> inputList){
        ArrayList<String> output = new ArrayList(inputList.size());

        for (int i = 0; i < inputList.size(); i++){
            if(inputList.get(i).checkTimeCalsIntercity(inputList.get(i).getTimeCalsIntercity())){
                output.add(inputList.get(i).getSurname());
            }
        }

        return "Межгородом пользовались следующие абоненты: " + output;
    }

    public static ArrayList<Subscriber> sortAlf(ArrayList<Subscriber> inputList){
        inputList.sort(Comparator.comparing(Subscriber::getSurname));
        return inputList;
    }

}

class Subscriber{

    long number;
    String surname;
    String name;
    String middleName;
    String address;
    long debetCard;
    long creditCard;
    int timeCals;
    int timeCalsIntercity;


    public Subscriber(){}

    public Subscriber(long number, String surname, String name, String middleName, String address, long debetCard, long creditCard, int timeCals, int timeCalsIntercity) {
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debetCard = debetCard;
        this.creditCard = creditCard;
        this.timeCals = timeCals;
        this.timeCalsIntercity = timeCalsIntercity;
    }

    public Subscriber(long number, String surname, String name, String middleName, String address, long debetCard, long creditCard, int timeCals) {
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debetCard = debetCard;
        this.creditCard = creditCard;
        this.timeCals = timeCals;
    }

    public Subscriber(long number, String surname, String name, String middleName, String address, long debetCard, int timeCals) {
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debetCard = debetCard;
        this.timeCals = timeCals;
    }

    public long getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getAddress() {
        return address;
    }

    public long getDebetCard() {
        if(Long.toString(debetCard).length() != 10);
        return debetCard;
    }

    public long getCreditCard() {
        if((Long.toString(debetCard).length() != 10));
        return creditCard;
    }

    public int getTimeCals() {
        return timeCals;
    }

    public int getTimeCalsIntercity() {
        return timeCalsIntercity;
    }

    public void setNumber(long number) {
        if(Long.toString(debetCard).length() != 8);
        this.number = number;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDebetCard(long debetCard) {
        this.debetCard = debetCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public void setTimeCals(int timeCals) {
        this.timeCals = timeCals;
    }

    public void setTimeCalsIntercity(int timeCalsIntercity) {
        this.timeCalsIntercity = timeCalsIntercity;
    }

    public boolean checkTimeCalsIntercity(int timeCalsIntercity){
        this.timeCalsIntercity = timeCalsIntercity;
        if(timeCalsIntercity == 0){
            return false;
        }else return true;
    }

}
