package Entregables.actividad_13y14;

public class Rational implements Rationalizable {
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }
    public Rational(Rational r2) {
        this.numerator = r2.getNumerator();
        this.denominator = r2.getDenominator();
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
    }

    // Getters y Setters
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }
    public void setNumerator(int numerator) { this.numerator = numerator; }
    public void setDenominator(int denominator) {
        this.denominator = (denominator == 0) ? 1 : denominator; }

    @Override
    public Rational addition(Rational r1, Rational r2) {
        int newNUM = (r1.numerator * r2.denominator) + (r2.numerator * r1.denominator);
        int newDEN = r1.denominator * r2.denominator;
        return new Rational(newNUM, newDEN);
    }

    @Override
    public Rational subtraction(Rational r1, Rational r2) {
        int newNUM = (r1.numerator * r2.denominator) - (r2.numerator * r1.denominator);
        int newDEN = r1.denominator * r2.denominator;
        return new Rational(newNUM, newDEN);
    }

    @Override
    public Rational multiplication(Rational r1, Rational r2) {
        return new Rational(r1.numerator * r2.numerator, r1.denominator * r2.denominator);
    }

    @Override
    public Rational division(Rational r1, Rational r2) {
        // División: (a/b) / (c/d) = (a*d) / (b*c)
        return new Rational(r1.numerator * r2.denominator, r1.denominator * r2.numerator);
    }

    @Override
    public Rational exponentiation(Rational r1, int exponent) {
        int newNUM = (int) Math.pow(r1.numerator, exponent);
        int newDEN = (int) Math.pow(r1.denominator, exponent);
        return new Rational(newNUM, newDEN);
    }

    @Override
    public Rational negation(Rational r1) {
        return new Rational(-r1.numerator, r1.denominator);
    }

    @Override
    public Rational assignmentOperator(Rational r2) {
        this.numerator = r2.numerator;
        this.denominator = r2.denominator;
        return this;
    }

    @Override
    public boolean equalsOperator(Rational r1, Rational r2) {
        return (r1.numerator * r2.denominator) == (r2.numerator * r1.denominator);
    }

    @Override
    public boolean greater_thanOperator(Rational r1, Rational r2) {
        return (r1.numerator * r2.denominator) > (r2.numerator * r1.denominator);
    }

    @Override
    public boolean less_thanOperator(Rational r1, Rational r2) {
        return (r1.numerator * r2.denominator) < (r2.numerator * r1.denominator);
    }

    @Override
    public boolean greater_equalsOperator(Rational r1, Rational r2) {
        return equalsOperator(r1, r2) || greater_thanOperator(r1, r2);
    }

    @Override
    public boolean less_equalsOperator(Rational r1, Rational r2) {
        return equalsOperator(r1, r2) || less_thanOperator(r1, r2);
    }

    @Override
    public boolean notEquals_Operator(Rational r1, Rational r2) {
        return !equalsOperator(r1, r2);
    }

}