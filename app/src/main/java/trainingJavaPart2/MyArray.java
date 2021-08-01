package trainingJavaPart2;

import java.util.ArrayList;
import java.util.Random;

public class MyArray {

    private ArrayList<Integer> myArray;
    private int size;

    public MyArray(int size){
        this.size = size;
        myArray = new ArrayList(size);
    }

    public ArrayList<Integer> getMyArray() {
        return myArray;
    }

    public void setMyArray(ArrayList<Integer> myArray) {
        this.myArray = myArray;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int numberOfDifferentElements (ArrayList<Integer> input){
        int count = 0;
        this.myArray = input;
        for (int i = 0; i < input.size()-1; i++) {
            if(!input.get(i).equals(input.get(i + 1))) {
                count++;
            }
        }
        return count;
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
        // Лёгкий способ
        /*Collections.shuffle(input);*/

        Random random = new Random();
        for(int i = 0; i < input.size(); i++) {
            int index = random.nextInt(i + 1);
            int a = input.get(index);
            input.set(index, i);
            input.set(i, a);
        }
    }

    public void printMyArray (ArrayList<Integer> input){
        this.myArray = input;
        for (int i = 0; i < size; i++){
            System.out.print(input.get(i)+ " ");
        }
    }

}
