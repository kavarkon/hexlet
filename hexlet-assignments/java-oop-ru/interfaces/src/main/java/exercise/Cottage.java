package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    public String toString() {
        return String.format("%s этажный коттедж площадью %s метров", this.floorCount, this.area);
    }

    public int compareTo(Home another) {
        if (this.area > another.getArea()) {
            return 1;
        } else if (this.area < another.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
