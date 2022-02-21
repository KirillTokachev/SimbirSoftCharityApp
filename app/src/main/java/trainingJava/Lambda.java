package trainingJava;

@FunctionalInterface
interface Runnable {
    String print(int i, String str);
}
public class Lambda {

    public void repeatTask(int times, Runnable task){
        for (int i = 0; i < times; i++){
            task.print(i, "I love Java");
        }
    }

}
