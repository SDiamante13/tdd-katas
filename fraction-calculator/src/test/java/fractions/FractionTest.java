package fractions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FractionTest {

    @Test
    void addZeroes() {
        Fraction zero = new Fraction(0, 1);

        Fraction sum = zero.plus(zero);

        assertThat(sum).isEqualTo(zero);
    }

    @Test
    void addZeroAndNonZero() {
        Fraction zero = new Fraction(0, 1);
        Fraction one = new Fraction(1, 1);

        assertThat(zero.plus(one)).isEqualTo(one);
        assertThat(one.plus(zero)).isEqualTo(one);
    }
}

class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int numerator() {
        return numerator;
    }

    public int denominator() {
        return denominator;
    }

    public Fraction plus(Fraction fraction) {
        int sumOfNumerators = numerator + fraction.numerator();
        return new Fraction(sumOfNumerators, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (numerator != fraction.numerator) return false;
        return denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }
}
