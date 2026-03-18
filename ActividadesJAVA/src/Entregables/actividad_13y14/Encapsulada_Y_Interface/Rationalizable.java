package Entregables.actividad_13y14;

public interface Rationalizable {
    Rational addition(Rational r1, Rational r2);
    Rational subtraction(Rational r1, Rational r2);
    Rational multiplication(Rational r1, Rational r2);
    Rational division(Rational r1, Rational r2);
    Rational exponentiation(Rational r2, int exponent);
    Rational negation(Rational r2);
    Rational assignment(Rational r2);
    boolean equalsOperator(Rational r1, Rational r2);
    boolean greater_thanOperator(Rational r1, Rational r2);
    boolean less_thanOperator(Rational r1, Rational r2);
    boolean greater_equalsOperator(Rational r1, Rational r2);
    boolean less_equalsOperator(Rational r1, Rational r2);
    boolean notEquals_Operator(Rational r1, Rational r2);
}