package trainingJavaPart2.triangleTask;

public class Point {

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
