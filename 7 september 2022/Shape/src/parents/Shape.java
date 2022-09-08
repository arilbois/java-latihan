package parents;

public abstract class Shape {
    private String color;

    public Shape() {
    }

    public String getColor() {
        return color;
    }
    

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
}
