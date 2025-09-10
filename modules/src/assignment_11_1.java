

public class assignment_11_1 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setColor("blue");
        triangle.setFilled(true);

        System.out.printf("Area: %.2f\n", triangle.getArea());
        System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
    }
    
}


class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    /** No-arg constructor */
    public Triangle() {
    }

    /** Constructor with specified sides */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Accessors
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    /** Implement the getArea method */
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2; // semi-perimeter
        return s;
    }

    /** Implement the getPerimeter method */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /** Override the toString method */
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " , side2 = " + side2 + " , side3 = " + side3;
    }
}