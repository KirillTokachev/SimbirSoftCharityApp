package trainingJavaPart2.triangleTask;

public class Triangle {

    private Point a,b,c;

    Triangle (Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double sideAB() {
        return this.a.distanceTo(this.b);
    }

    public double sideBC() {
        return this.b.distanceTo(this.c);
    }

    public double sideAC() {
        return this.a.distanceTo(this.c);
    }

    public double getArea() {
        double p = getPerimeter() / 2.;
        return Math.sqrt(p * (p - sideAB()) * (p - sideBC()) * (p - sideAC()));
    }

    public double getPerimeter(){
        return sideAB() + sideBC() + sideAC();
    }

    public void getMediaCrossing() {
        Point point = new Point((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
        System.out.println(point.toString());
    }

}
