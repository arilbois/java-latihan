package childs;

import parents.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(String color,double radius) {
        setColor(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    
}
