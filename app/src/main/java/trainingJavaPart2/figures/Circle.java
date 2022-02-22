package trainingJavaPart2.figures;

public class Circle implements Shape {

    private double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double getPerimeter() {
        double r = diameter/2;
        double p = 2 * Math.PI * r;
        return p;
    }

    @Override
    public double getArea() {
        double area = Math.pow(diameter,2) / 4 * Math.PI;
        return area;
    }

}
