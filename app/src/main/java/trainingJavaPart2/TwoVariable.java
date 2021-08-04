package trainingJavaPart2;

public class TwoVariable {

    int a;
    int b;

    public TwoVariable(){ }

    public TwoVariable(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void setVar(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void getVar(int a, int b){
        System.out.println(a + ", " + b);
    }

    public int plusVar(){
        int sum = a+b;
        return sum;
    }

    public int overVar(){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}
