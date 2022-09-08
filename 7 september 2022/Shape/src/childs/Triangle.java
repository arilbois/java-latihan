package childs;

import parents.Shape;

public class Triangle extends Shape {
    private double base, height;

    public Triangle() {
    }

    public Triangle(double base, double height, String color) {
        setColor(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = 0.5 * base * height;
        return area;
    }
}
