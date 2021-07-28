package trainingJava;

public class TwoVariable {

    int a;
    int b;

    public TwoVariable(){ }

    public TwoVariable(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void getVar(int a, int b){
        this.a = a;
        this.b = b;

        System.out.println(a + ", " + b);
    }

    public int plusVar(){
        int summ = a+b;
        return summ;
    }

    public int overVar(){
        if (a > b) return a;
        else return b;
    }

}
