public class assignment_9_9 {
	public static void main(String[] args) {
		RegularPolygon poly1 = new RegularPolygon();
		RegularPolygon poly2 = new RegularPolygon(6, 4);
		RegularPolygon poly3 = new RegularPolygon(10, 4, 5.6, 7.8);

		System.out.printf("Polygon 1: Perimeter = %.2f, Area = %.2f\n", poly1.getPerimeter(), poly1.getArea());
		System.out.printf("Polygon 2: Perimeter = %.2f, Area = %.2f\n", poly2.getPerimeter(), poly2.getArea());
		System.out.printf("Polygon 3: Perimeter = %.2f, Area = %.2f\n", poly3.getPerimeter(), poly3.getArea());
	}
}

/** Create the RegularPolygon class */
class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;

	/** No-arg constructor */
	public RegularPolygon() {
	}

	/** Constructor with n and side */
	public RegularPolygon(int n, double side) {
		this.n = n;
		this.side = side;
	}

	/** Constructor with n, side, x, y */
	public RegularPolygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}

	// Accessors
	public int getN() {
		return n;
	}
    
	public double getSide() {
		return side;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	// Mutators
	public void setN(int n) {
		this.n = n;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	// Perimeter
	public double getPerimeter() {
		return n * side;
	}

	// Area
	public double getArea() {
		return (n * side * side) / (4 * Math.tan(Math.PI / n));
	}
}
