package trainingJavaPart2;

import java.util.ArrayList;

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

    public int numberOfDifferentElements (){
        int count = 0;
        for (int i = 0; i < myArray.size()-1; i++) {
            if(!myArray.get(i).equals(myArray.get(i + 1))) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Integer> myArrayRandom (){
        for (int i = 0; i < size; i++){
            myArray.add(i, (int) ( 0 + (Math.random() * 100)));
        }
        return myArray;
    }

    public ArrayList<Integer> getRandomElement () {
        // Лёгкий способ
        /*Collections.shuffle(myArray);*/
        int tmp;

        for (int i = 0; i < myArray.size(); i++){
            int buf1 = (int) (Math.random() * myArray.size());
            int buf2 = (int) (Math.random() * myArray.size());
            tmp = myArray.get(buf1);
            myArray.set(buf1, myArray.get(buf2));
            myArray.set(buf2, tmp);
        }
        return myArray;
    }

    public void printMyArray (){
        for (int i = 0; i < size; i++){
            System.out.print(myArray.get(i)+ " ");
        }
    }

}
