package trainingJava;

public class Circle implements Shape{

    double diameter;

    @Override
    public double getPerimeter() {
        double r = diameter/2;
        double p = 2 * Math.PI * r;
        return p;
    }

    @Override
    public double getArea() {
        double s = Math.pow(diameter,2) / 4 * Math.PI;
        return s;
    }
}
