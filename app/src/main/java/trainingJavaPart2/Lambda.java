package trainingJavaPart2;

@FunctionalInterface
interface Runnable {
    public String sayLoveJava();
}
public class Lambda {

    Runnable run = () -> {
        return "I Love Java!";
    };
    public void repeatTask(int times){
        for (int i = 0; i < times; i++){
            System.out.println(run);
        }
    }

}
