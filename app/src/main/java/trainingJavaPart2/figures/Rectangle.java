package trainingJavaPart2.figures;

public class Rectangle implements Shape {
    private double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        double p = 2 * (width + length);
        return p;
    }

    @Override
    public double getArea() {
        double area = width * length;
        return area;
    }
}
