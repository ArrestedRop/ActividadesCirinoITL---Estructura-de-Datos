package Entregables.actividad_13y14.Encapsulada_Y_Interface;

public class Rational implements Rationalizable {
    private int numerator;
    private int denominator;

    // Constructores (Default, Copy, Normal)
    public Rational() { this.numerator = 0; this.denominator = 1; }
    public Rational(Rational r2) { this.numerator = r2.numerator; this.denominator = r2.denominator; }
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
    }
    // Reductores
    public int getMCD(int num, int den){
        return (den==0) ? num : getMCD(den, num %den);
    }
    public Rational simplify(int num, int den) {
        int comun = getMCD(Math.abs(num),Math.abs(den));
        return new Rational(num/comun,den/comun);
    }
    // Aritmetica rational|rational
    @Override
    public Rational addition(Rational r1, Rational r2) {
        int a = r1.numerator, b = r1.denominator;
        int c = r2.numerator, d = r2.denominator;
        Rational r3 = simplify((a * d) + (b * c), b * d);
        return r3;
    }

    @Override
    public Rational subtraction(Rational r1, Rational r2) {
        int a = r1.numerator, b = r1.denominator;
        int c = r2.numerator, d = r2.denominator;
        Rational r3 = simplify((a * d) - (b * c), b * d);
        return r3;
    }

    @Override
    public Rational multiplication(Rational r1, Rational r2) {
        int a = r1.numerator, b = r1.denominator;
        int c = r2.numerator, d = r2.denominator;
        Rational r3 = simplify((a*c),(b*d));
        return r3;
    }

    @Override
    public Rational division(Rational r1, Rational r2) {
        int a = r1.numerator, b = r1.denominator;
        int c = r2.numerator, d = r2.denominator;
        Rational r3 = simplify((a*d),(c*b));
        return r3;
    }

//    Sobrecargados rational|entero
    public Rational addition(Rational r1, int num) {
        int a = r1.numerator, b = r1.denominator;
        int c = num, d = 1;
        Rational r3 = simplify((a * d) + (b * c), b * d);
        return r3;
    }

    public Rational subtraction(Rational r1, int num) {
        int a = r1.numerator, b = r1.denominator;
        int c = num, d = 1;
        Rational r3 = simplify((a * d) - (b * c), b * d);
        return r3;
    }

    public Rational multiplication(Rational r1, int num) {
        int a = r1.numerator, b = r1.denominator;
        int c = num, d = 1;
        Rational r3 = simplify((a*c),(b*d));
        return r3;
    }

    public Rational division(Rational r1, int num) {
        int a = r1.numerator, b = r1.denominator;
        int c = num, d = 1;
        Rational r3 = simplify((a*d),(c*b));
        return r3;
    }

//    Otros operadores
    @Override
    public Rational exponentiation(Rational r1, int exponent) {
        int newNUM = (int) Math.pow(r1.numerator, exponent);
        int newDEN = (int) Math.pow(r1.denominator, exponent);
        Rational r3 = simplify(newNUM,newDEN);
        return r3;
    }

    @Override
    public Rational negation(Rational r1) {
        return new Rational(-r1.numerator, r1.denominator);
    }

    @Override
    public Rational assignment(Rational r2) {
        this.numerator = r2.numerator;
        this.denominator = r2.denominator;
        return this;
    }

    // --- COMPARADORES ---
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

    @Override
    public String toString() { return numerator + "/" + denominator; }
}