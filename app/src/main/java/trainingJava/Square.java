package trainingJava;

public class Square implements Shape{



    double sideLength;

    @Override
    public double getPerimeter() {
        return 4*sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength,2);
    }
}
