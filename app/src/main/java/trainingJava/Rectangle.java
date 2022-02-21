package trainingJava;

public class Rectangle implements Shape {
    double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }


    @Override
    public double getPerimeter() {
        double p = 2 * (width + length);
        return p;
    }

    @Override
    public double getArea() {
        double s = width * length;
        return s;
    }
}
