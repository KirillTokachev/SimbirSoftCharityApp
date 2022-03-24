package trainingJava;

public class Triangle {

    private Point a,b,c;

    Triangle(Point a, Point b, Point c) {
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
        Point out = new Point((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
        System.out.println(out.toString());
    }

}

// Создание вспомогательного класса для реализации точек координат
class Point {

    private  double x;
    private  double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Нахождение расттояния между точками
    public double distanceTo(Point point) {
        double temp = Math.pow(point.getX() - x, 2);
        temp += Math.pow(point.getY() - y, 2);
        return Math.sqrt(temp);
    }

    // Переопределеие метода для распечатки меридиан
    @Override
    public String toString() {
        return String.format("(%.2f; %.2f)", this.x, this.y);
    }

}

