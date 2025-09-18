import java.math.BigInteger;
import java.util.Scanner;

public class assignment_13_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for first rational
        System.out.print("Enter the first rational number: ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger den1 = input.nextBigInteger();
        Rational r1 = new Rational(num1, den1);

        // Prompt for second rational
        System.out.print("Enter the second rational number: ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger den2 = input.nextBigInteger();
        Rational r2 = new Rational(num2, den2);

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " – " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}

class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    // Default constructor
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Constructor with parameters
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        // Normalize sign and reduce
        BigInteger gcd = numerator.gcd(denominator);
        BigInteger sign = denominator.signum() == -1 ? BigInteger.valueOf(-1) : BigInteger.ONE;

        this.numerator = numerator.multiply(sign).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    // Getters
    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    // Arithmetic operations
    public Rational add(Rational other) {
        BigInteger n = this.numerator.multiply(other.denominator)
                          .add(this.denominator.multiply(other.numerator));
        BigInteger d = this.denominator.multiply(other.denominator);
        return new Rational(n, d);
    }

    public Rational subtract(Rational other) {
        BigInteger n = this.numerator.multiply(other.denominator)
                          .subtract(this.denominator.multiply(other.numerator));
        BigInteger d = this.denominator.multiply(other.denominator);
        return new Rational(n, d);
    }

    public Rational multiply(Rational other) {
        return new Rational(
            this.numerator.multiply(other.numerator),
            this.denominator.multiply(other.denominator)
        );
    }

    public Rational divide(Rational other) {
        if (other.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return new Rational(
            this.numerator.multiply(other.denominator),
            this.denominator.multiply(other.numerator)
        );
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rational)) return false;
        Rational other = (Rational) obj;
        return this.numerator.equals(other.numerator) &&
               this.denominator.equals(other.denominator);
    }

    @Override
    public int compareTo(Rational other) {
        BigInteger left = this.numerator.multiply(other.denominator);
        BigInteger right = this.denominator.multiply(other.numerator);
        return left.compareTo(right);
    }

    // Number overrides
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }
}
