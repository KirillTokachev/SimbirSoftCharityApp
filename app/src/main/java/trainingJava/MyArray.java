package trainingJava;

import java.util.ArrayList;

public class MyArray {

    ArrayList<Integer> myArray;
    int size;

    public MyArray(int size){
        this.size = size;
        myArray = new ArrayList(size);
    }

    public ArrayList<Integer> myArrayRandom (ArrayList<Integer> input){
        this.myArray = input;
        for (int i = 0; i < size; i++){
            input.add(i, (int) ( 0 + (Math.random() * 100)));
        }
        return input;
    }

    public void getRandomElement (ArrayList<Integer> input) {
        this.myArray = input;
        int randId = input.get((int) ( 0 + (Math.random() * size)));
        System.out.println(randId);
    }

    public void printMyArray (ArrayList<Integer> input){
        this.myArray = input;
        for (int i = 0; i < size; i++){
            System.out.print(input.get(i)+ " ");
        }
    }

}
