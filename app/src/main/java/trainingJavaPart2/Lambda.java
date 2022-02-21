package trainingJavaPart2;

interface Runnable {

    void print();
}
public class Lambda {

    Runnable myClosure = () -> System.out.println("I Love Java");

    public void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task = myClosure;
            task.print();
        }
    }
}