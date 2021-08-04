package trainingJavaPart2.abonentTask;

import java.util.ArrayList;
import java.util.Comparator;

public class Subscriptions {

    public static void main(String[] args) {

        Subscriber Georgy = new Subscriber(878377688,"Салманов","Георгий","Алексеевич","Москва",505012372,404099943,344,550,1234);
        Subscriber Leonid = new Subscriber(988773222,"Рюкзаков","Леонид","Иванович","Москва",505014232,404087543,544);
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

    public static String getSubscribersWithExceedingCallTime(ArrayList<Subscriber> inputList, int time){
        ArrayList<String> output = new ArrayList(inputList.size());

        for(int i = 0; i < inputList.size(); i++){
            if(inputList.get(i).getTimeCals() > time){
                output.add(inputList.get(i).getSurname());
            }
        }
        return "Лимит превыщает у следующих абонентов :" + output;
    }

    public static String getSubscribersWithExceedingIntercityCallTime(ArrayList<Subscriber> inputList){
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
